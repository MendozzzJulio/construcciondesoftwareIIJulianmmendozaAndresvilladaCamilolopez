package app.adapter.in.builder;

import app.adapter.in.validators.AppointmentValidator;
import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.entities.Appointment;
import app.domain.entities.Patient;
import app.domain.entities.User;

public class AppointmentBuilders {

	private  AppointmentValidator appointmentValidator;
	
	private PatientValidator patientValidator;
	
	private UserValidator userValidator;
	
	public Appointment build(String date, String doctorName,String patientName) throws Exception{
		
		Appointment appointment = new Appointment();
		Patient patient = new Patient();
		User doctor= new User();
		
		appointment.setDate(appointmentValidator.dateValidator(date));
		doctor.setName(userValidator.nameValidator(doctorName)); // Debo de crear los validadores de user
		patient.setName(patientValidator.nameValidator(patientName));
		
		return appointment;
	}

}