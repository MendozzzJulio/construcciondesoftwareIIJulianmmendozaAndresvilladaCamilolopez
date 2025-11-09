package app.adapter.in.validators;

import java.sql.Date;

public class DiagnosticValidator extends SimpleValidator {
	
	public String descriptionValidator(String value) throws Exception {
		return stringValidator("descripción del diagnóstico", value);
	}

	public String resultsValidator(String value) throws Exception {
		return stringValidator("resultados", value);
	}

	public Date dateValidator(String value) throws Exception {
		stringValidator("fecha", value);
		return Date.valueOf(value);
	}

	public String severityValidator(String value) throws Exception {
		return stringValidator("severidad", value);
	}

	public String notesValidator(String value) throws Exception {
		return stringValidator("notas", value);
	}
}
