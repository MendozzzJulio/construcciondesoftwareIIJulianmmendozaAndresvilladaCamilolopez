package app.adapter.in.validators;



import app.domain.entities.EmergencyContact;
import app.domain.entities.valueobjects.Address;
import app.domain.entities.valueobjects.Email;
import app.domain.entities.valueobjects.PhoneNumber;

public class PatientValidator extends SimpleValidator {
	
	public String nameValidator(String value) throws Exception {
		return stringValidator("nombre", value);
	}

	public String lastNameValidator(String value) throws Exception {
		return stringValidator("apellido", value);
	}

	public Email emailValidator(String value) throws Exception {
		stringValidator("email", value);
		return new Email(value); 
	}

	

	public PhoneNumber phoneValidator(String value) throws Exception {
		stringValidator("numero de telefono", value);
		return new PhoneNumber(value); 
	}
	
	public Address addressValidator(String value) throws Exception{
		stringValidator("Direccion", value);
		return new Address(value);
	}
	
	public EmergencyContact emergencyContactValidator(String value) throws Exception {
		stringValidator("Contacto de emergencia", value);
		return new EmergencyContact(value);
	}
	
	
	public String passwordValidator(String value) throws Exception {
		return stringValidator("contraseña", value);	
	}
	
	public long documentValidator (String value) throws Exception{
		return longValidator("El documento de la persona value", value);
	}
	
	
	
	
	
	

}
