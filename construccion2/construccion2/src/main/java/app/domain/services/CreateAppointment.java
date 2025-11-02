package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Appointment;
import app.domain.ports.AppointmentPort;
@Service
public class CreateAppointment {
	@Autowired
	private AppointmentPort AppointmentPort;

    public void create(Appointment appointment) throws Exception {
        
        if (!AppointmentPort.isDoctorAvailable(appointment.getDoctor(), appointment.getDate())) {
            throw new Exception("El doctor ya tiene una cita agendada para esa fecha y hora.");
        }

        if (!AppointmentPort.isPatientAvailable(appointment.getPatient(), appointment.getDate())) {
            throw new Exception("El paciente ya tiene una cita agendada para esa fecha y hora.");
        }
        AppointmentPort.save(appointment);
    }


		
	
}