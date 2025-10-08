package app.domain.services;


import app.domain.entities.Patient;

import app.domain.ports.PatientsPort;                        //seguImos el esquema CRUD (CREATE,READ,UPDATE,DELETE)

import app.domain.ports.PatientPort;

public class CreatePatient {
	
	private final PatientPort patientsPort;
	

	public Create(PatientsPort patientsPort) {

	//vamos a crear el nuevo (enfermo) paciente 
	public void createPatient(Patient patient) throws Exception {
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
	   
}
