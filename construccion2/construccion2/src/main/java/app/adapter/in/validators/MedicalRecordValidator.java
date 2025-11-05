package app.adapter.in.validators;

import java.sql.Date;

public class MedicalRecordValidator extends SimpleValidator {
	
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

	public String diagnosisValidator(String value) throws Exception {
		return stringValidator("diagnóstico", value);
	}

	public String treatmentValidator(String value) throws Exception {
		return stringValidator("tratamiento", value);
	}

	public String notesValidator(String value) throws Exception {
		return stringValidator("notas", value);
	}
}
