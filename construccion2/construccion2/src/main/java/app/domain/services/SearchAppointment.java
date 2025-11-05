package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Appointment;
import app.domain.ports.AppointmentPort;

@Service
public class SearchAppointment {
	@Autowired
	private AppointmentPort appointmentPort;
	

    public Appointment search(Appointment appointment) throws Exception {
        
        if (appointment == null) {
            throw new Exception("Los criterios de búsqueda no pueden ser nulos");
        }
        
        Appointment foundAppointment = appointmentPort.findById(appointment);
        if (foundAppointment == null) {
            throw new Exception("No se encontró la cita especificada");
        }  
        return foundAppointment;
    }
}
