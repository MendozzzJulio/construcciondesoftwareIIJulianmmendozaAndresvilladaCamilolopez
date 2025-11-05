package app.adapter.in.validators;

import java.sql.Date;

public class VisitValidator extends SimpleValidator {
	
	public long patientIdValidator(String value) throws Exception {
		return longValidator("ID del paciente", value);
	}

	public long doctorIdValidator(String value) throws Exception {
		return longValidator("ID del doctor", value);
	}

	public Date dateValidator(String value) throws Exception {
		stringValidator("fecha", value);
		return Date.valueOf(value);
	}

	public String reasonValidator(String value) throws Exception {
		return stringValidator("motivo de la visita", value);
	}

	public String notesValidator(String value) throws Exception {
		return stringValidator("notas", value);
	}

	public String statusValidator(String value) throws Exception {
		return stringValidator("estado", value);
	}
}
