package app.adapter.in.builder;
import app.adapter.in.validators.PatientValidator;
import app.domain.entities.Patient;


public class PatientBuilders{
	
	private PatientValidator patientValidator;


	public  Patient build(String Name,String LastName,String document, String email, String phoneNumber, String address, String gender, String dateOfBirth, String weigth, String height)
		throws Exception {
		Patient patient = new Patient();
		patient.setName(patientValidator.nameValidator(Name));
		patient.setLastName(patientValidator.lastNameValidator(LastName));
		patient.setDocument(patientValidator.documentValidator(document));
		patient.setEmail(patientValidator.emailValidator(email)); // problema, el tipo es un objecto de valor y el setters esta ingresando un string (conflicto en el tipo de dato)
		patient.setPhoneNumber(patientValidator.phoneValidator(phoneNumber));// conflicto en el tipo de dato
		patient.setAddress(patientValidator.addressValidator(address)); //conflicto en el tipo de dato
		patient.setGender(patientValidator.genderValidator(gender));
		patient.setDateOfBirth(patientValidator.dateOfBirthValidator(dateOfBirth));
		patient.setWeigth(patientValidator.weightValidator(weigth)); 
		patient.setHeight(patientValidator.heightValidator(height));
		
		
		return patient;

	}
	
	

}
