package app.adapter.in.validators;

public class PatientValidator extends SimpleValidator {
	
	public String nameValidator(String value) throws Exception {
		return stringValidator("nombre", value);
	}

	public String lastNameValidator(String value) throws Exception {
		return stringValidator("apellido", value);
	}

	public String emailValidator(String value) throws Exception {
		return stringValidator("email", value);
	}

	public String addressValidator(String value) throws Exception {
		return stringValidator("direccion", value);
	}

	public String phoneNumberValidator(String value) throws Exception {
		return stringValidator("numero de telefono", value);
	}
	
	public String passwordValidator(String value) throws Exception {
		return stringValidator("contraseña", value);	
	}
	
	public long documentValidator (String value) throws Exception{
		return longValidator("El documento de la persona value", value);
	}
	
	
	
	

}
