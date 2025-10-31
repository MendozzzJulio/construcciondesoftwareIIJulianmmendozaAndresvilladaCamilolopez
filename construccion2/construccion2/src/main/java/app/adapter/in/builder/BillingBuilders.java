package app.adapter.in.builder;

import app.adapter.in.validators.MedicalInsuranceValidator;
import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.entities.Billing;
import app.domain.entities.Patient;
import app.domain.entities.User;

public class BillingBuilders {
	
	private MedicalInsuranceValidator medicalinsuranceValidator;
	
	private PatientValidator patientValidator;
	
	private UserValidator userValidator;
	
	public Billing build(String doctorName,String doctorDocument,String patientName,String patietnDocument,  String policyEndDate,String policyNumber, String policyValidity, String nameCompany) throws Exception {
		Billing billing = new Billing();
		User doctor = new User();
		Patient patient = new Patient();
		
		doctor.setName(userValidator.nameValidator(doctorName));
		doctor.setDocument(userValidator.documentValidator(doctorDocument));
		patient.setDocument(patientValidator.documentValidator(patietnDocument));//esto es lo creo redundante
		billing.setUser(doctor);// accedemos al nombre del medico tratante 
		billing.setPatient(patient);// accedemos al nombre del paciente (aunque creo que no solo el nombre, sino todo el objeto paciente) por lo cual seria redundante lo del inicio 
		billing.setPatientDocument(patient.getDocument());
		billing.setPolicyNumber(billingValidator.policyNumberValidator(policyNumber));
	    billing.setMedicalInsurance(medicalinsuranceValidator.policyValidityValidator(policyValidity)); // se me frito el cerebro 
	   //se me frito muy frito 
	   
		return billing;

	}
	
	

}
