package app.adapter.in.validators;

import java.sql.Date;

import app.domain.entities.Patient;
import app.domain.entities.User;

public class VisitValidator extends SimpleValidator {
	

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
	public User userdoctoridValidator(String doctorId) throws Exception {
		long id = longValidator("id del doctor", doctorId);
		User u = new User();
		u.setId(id);
		return u;
	} 
	public Patient patientIdValidator(String patientId) throws Exception {
		long id = longValidator("id del doctor", patientId);
		Patient z = new Patient();
		z.setId(id);
		return z;
	} 
}
