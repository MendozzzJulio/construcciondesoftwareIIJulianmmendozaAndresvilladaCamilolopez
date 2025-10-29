package app.adapter.in.validators;
import app.domain.entities.EmergencyContact;
import app.domain.entities.enums.Gender;
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
	
	public EmergencyContact emergencyContactValidator(String value, String name, String lastName, String phoneNumber) throws Exception {
		stringValidator("Contacto de emergencia", value);
		EmergencyContact contact = new EmergencyContact();
		contact.setLastName(stringValidator("apelldo de Contacto de emergencia", lastName));
		contact.setName(stringValidator("Nombre del contacto de emergencia", name));
		contact.setPhoneNumber(phoneValidator(phoneNumber));;
		return contact;
	}
	
	public Gender genderValidator(String value) throws Exception {
		stringValidator("genero", value);
		return Gender.valueOf(value.toUpperCase()); 
	} 
	
	
	public String passwordValidator(String value) throws Exception {
		return stringValidator("contraseña", value);	
	}
	
	public long documentValidator (String value) throws Exception{
		return longValidator("El documento de la persona value", value);
	}
	
	
	
	
	
	

}
