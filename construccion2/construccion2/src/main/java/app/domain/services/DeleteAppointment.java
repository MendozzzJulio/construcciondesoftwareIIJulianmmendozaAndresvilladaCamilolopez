package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Appointment;
import app.domain.ports.AppointmentPort;

@Service
public class DeleteAppointment {
	@Autowired
	private AppointmentPort appointmentPort;

    public void delete(Appointment appointment) throws Exception {
        
        if (appointment == null) {
            throw new Exception("La cita no puede ser nula");
        }
        
        Appointment existingAppointment = appointmentPort.findById(appointment);
        if (existingAppointment == null) {
            throw new Exception("La cita a eliminar no existe en el sistema");
        }
        
        appointmentPort.delete(appointment);
    }
}
