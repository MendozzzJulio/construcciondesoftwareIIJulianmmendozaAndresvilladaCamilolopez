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

/* Hey aqui Mendoza
 * 
 * En esta clase tenemos que cumplir con las validaciones que se nos piden
 * 
 * No recuerdo las validaciones pero veamos a ver
 * 
 * 
 * */

@Service 
public class CreateMedicalOrder {
	
	@Autowired  
	private UserPort userPort;
	@Autowired
	private PatientPort patientPort;
	@Autowired
	private MedicalOrderPort medicalOrderPort;	
	
	public void create(MedicalOrder medicalOrder) throws Exception{  
		
		// Extraemos informacion del user creador y validamos que sea un doctor o un admin
		User doctor = userPort.findById(medicalOrder.getDoctor());
        if (doctor == null || !doctor.getRole().equals(Role.DOCTOR) || doctor.getRole().equals(Role.ADMINISTRATIVE)) {
            throw new Exception("Las ordenes solo pueden ser creadas por un doctor o un admin.");
        }
        
        // Validamos que el paciente exista
        Patient patient = patientPort.findById(medicalOrder.getPatient());
        if (patient==null) {
        	throw new Exception("Las ordenes medicas deben de asociarse a un paciente");
        }
        // Validamos que el identificador de la orden sea unico
        // La vaerdad creo que no será necesario porque el id es automatico
        MedicalOrder existing = medicalOrderPort.findById(medicalOrder);
        if (existing != null) {
        	throw new Exception("El identificador de la orden ya existe, debe ser único");
        }
        
        //Se valida que la orden tenga al menos un item
        List<MedicalOrderType> items = medicalOrder.getItems();
        if (items == null || items.isEmpty()) {
        	throw new Exception("La orden debe contener al menos un ítem");
        }

        // Banderita para ver si hay un diagnostico y si hay medicamentos o procedimientos
        boolean hasDiagnostic = false;
        boolean hasMedOrProc = false;
        // Este visaje es para ver si hay duplicados
        // funciona con el set. Set es una coleccion que no permite duplicados. 
        
        Set<String> seenItems = new HashSet<>(); 

        int counter = 1;
        
        // I es un item e Items es la coleccion de items en la database 
        
        for (MedicalOrderType i : items) {
        	
        	if (i == null) {
        		throw new Exception("Ítem inválido en la orden");
        	}
        	
        	// instacio a un item en especifico 
        	MedicalItemType type = i.getItem();
        	if (type == null) {
        		throw new Exception("Cada ítem debe tener un tipo");
        	}
        	
        	/*es null? si es asi lo convierto a un cadena 
        	 * vacia y si no lo convierto a minusculas y quito espacios en blanco */ 
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
	
	

