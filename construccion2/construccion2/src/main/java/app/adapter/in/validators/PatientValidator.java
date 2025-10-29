package app.adapter.in.validators;

public class PatientValidator extends SimpleValidator {
	
	public String nameValidator(String value) throws Exception {
		return stringValidator("nombre", value);
	}
	
	public String passwordValidator(String value) throws Exception {
		return stringValidator("contraseña", value);	
	}
	
	public long documentValidator (String value) throws Exception{
		return longValidator("El documento de la persona value", value);
	}
	
	
	
	

}
