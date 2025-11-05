package app.domain.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.MedicalOrder;
import app.domain.entities.MedicalOrderType;
import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.entities.enums.MedicalItemType;
import app.domain.ports.UserPort;
import app.domain.ports.MedicalOrderPort;
import app.domain.ports.PatientPort;

@Service 
public class CreateMedicalOrder {
	
	@Autowired  
	private UserPort userPort;
	@Autowired
	private PatientPort patientPort;
	@Autowired
	private MedicalOrderPort medicalOrderPort;	
	
	public void create(MedicalOrder medicalOrder) throws Exception{  

			
		User doctor = userPort.findById(medicalOrder.getDoctor());
        if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
            throw new Exception("Las ordenes solo pueden ser creadas por un doctor");
        }
        
        Patient patient = patientPort.findById(medicalOrder.getPatient());

        if (patient==null) {
        	throw new Exception("Las ordenes medicas deben de asociarse a un paciente");
        }

        MedicalOrder existing = medicalOrderPort.findById(medicalOrder);
        if (existing != null) {
        	throw new Exception("El identificador de la orden ya existe, debe ser único");
        }

        List<MedicalOrderType> items = medicalOrder.getItems();
        if (items == null || items.isEmpty()) {
        	throw new Exception("La orden debe contener al menos un ítem");
        }

        boolean hasDiagnostic = false;
        boolean hasMedOrProc = false;
        Set<String> seenItems = new HashSet<>(); 

        int counter = 1;
        for (MedicalOrderType i : items) {
        	if (i == null) {
        		throw new Exception("Ítem inválido en la orden");
        	}
        	MedicalItemType type = i.getItem();
        	if (type == null) {
        		throw new Exception("Cada ítem debe tener un tipo");
        	}
        	String key = (i.getDescription() == null ? "" : i.getDescription().trim().toLowerCase());
        	if (key.isEmpty()) {
        		throw new Exception("Cada ítem debe tener una descripción no vacía");
        	}
        	if (!seenItems.add(key)) {
        		throw new Exception("No pueden existir dos elementos con el mismo ítem en la misma orden");
        	}

        	if (type == MedicalItemType.DIAGNOSTIC) {
        		hasDiagnostic = true;
        	} else if (type == MedicalItemType.MEDICATION || type == MedicalItemType.PROCEDURE) {
        		hasMedOrProc = true;
        	}

        	i.setItemNumber(counter++);
        }

        if (hasDiagnostic && hasMedOrProc) {
        	throw new Exception("Una orden con ayuda diagnóstica no puede incluir procedimientos ni medicamentos");
        }

        medicalOrderPort.save(medicalOrder);
   
	}
		
}//end class
	
	

