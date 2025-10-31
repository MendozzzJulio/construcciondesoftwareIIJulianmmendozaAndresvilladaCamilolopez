package app.adapter.in.validators;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class AppointmentValidator extends SimpleValidator {
	
	public Date dateValidator(String value) throws Exception {
		stringValidator("fecha", value);
		// Suponiendo que la fecha está en formato "yyyy-MM-dd"
		return Date.valueOf(value);
	}
}
