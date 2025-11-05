package app.adapter.in.validators;

public class DiagnosticAidValidator extends SimpleValidator {
	
	public String nameValidator(String value) throws Exception {
		return stringValidator("nombre de la ayuda diagnóstica", value);
	}

	public String descriptionValidator(String value) throws Exception {
		return stringValidator("descripción", value);
	}

	public double costValidator(String value) throws Exception {
		return doubleValidator("costo", value);
	}

	public String requirementsValidator(String value) throws Exception {
		return stringValidator("requisitos", value);
	}
}
