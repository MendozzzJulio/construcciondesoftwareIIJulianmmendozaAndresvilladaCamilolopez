package app.adapter.in.validators;

import app.domain.entities.valueobjects.PhoneNumber;

public class EmergencyContactValidator extends SimpleValidator {
	
	public String nameValidator(String value) throws Exception {
		return stringValidator("nombre del contacto", value);
	}

	public String lastNameValidator(String value) throws Exception {
		return stringValidator("apellido del contacto", value);
	}

	public PhoneNumber phoneValidator(String value) throws Exception {
		stringValidator("número de teléfono", value);
		return new PhoneNumber(value);
	}

	public String relationshipValidator(String value) throws Exception {
		return stringValidator("relación", value);
	}
}
