package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Patient;
import app.domain.entities.Visit;
import app.domain.ports.PatientPort;
import app.domain.ports.VisitPort;

// Servicio para crear una visita médica asociada a un paciente registrado

@Service
public class CreateVisit {
	@Autowired
	private VisitPort visitPort;
	@Autowired
	private PatientPort patientPort;
	
	public void createVisit(Visit visit) throws Exception {
		Patient patient = patientPort.findByDocument(visit.getPatient());
		
		if(patient == null) {
			throw new Exception(" Tiene que asociar la visita a un paciente que se encuentre registrado");
		}
		
		visit.setPatient(patient);
		
		// validamos la presion arterial que se encuentre en un rango valido y que no se nos vaya a ir al mas alla 
		if (visit.getBloodPressure() == 0 || visit.getBloodPressure() < 50 || visit.getBloodPressure() > 250) {
			throw new Exception(" La presion arterial debe estar en un rango valido");
		}
		//validamos la temperatura corporal que no este muy hot ni muy ice 
		if (visit.getTemperature() == 0 || visit.getTemperature() < 30 || visit.getTemperature() > 43) {
			throw new Exception(" La temperatura corporal debe estar en un rango valido");
		
		}
		//  Validamos frecuencia cardíaca (en pulsaciones por minuto)
        if (visit.getPulse() == 0 || visit.getPulse() < 30 || visit.getPulse() > 220) {
            throw new Exception("Debe registrar un pulso válido.");
        }
        //  Validar nivel de oxígeno en sangre (SpO2 en %)
        if (visit.getOxygenLevel() == 0 ||visit.getOxygenLevel() < 70 || visit.getOxygenLevel() > 100) {
            throw new Exception("Debe registrar un nivel de oxígeno válido");
        }
        
        // Guardamos la visita si todas las validaciones son correctas
        visitPort.save(visit);

	}

}
