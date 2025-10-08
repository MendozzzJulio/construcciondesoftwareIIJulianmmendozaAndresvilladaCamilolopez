package app.domain.services;


import app.domain.entities.Patient;
import app.domain.ports.PatientPort;

public class PatientService {
	
	private final PatientPort patientsPort;
	
	public PatientService(PatientPort patientsPort) {
		this.patientsPort = patientsPort;
	}
	
	//vamos a registar el nuevo paciente 
	public void registerPatient(Patient patient) throws Exception {
        if (patientsPort.findById(patient.getId()) != null) {
            throw new Exception(" A Patient with THIS ID  already exists.");
        }
        patientsPort.save(patient);
	}
      // buscar paciente por id
	  public Patient getPatient(Patient patient) throws Exception {
	        Patient found = patientsPort.findById(patient.getId());
	        if (found == null) {
	            throw new Exception("Patient not found");
	        }
	        return found;
	    }
	  
	  // actualizar info del paciente 
	    public void updatePatient(Patient patient) throws Exception {
	        Patient existing = patientsPort.findById(patient.getId());
	        if (existing == null) {
	            throw new Exception("Cannot update: patient does not exist");
	        }
	        patientsPort.save(patient);
	    }
	  
	  
	  
}
