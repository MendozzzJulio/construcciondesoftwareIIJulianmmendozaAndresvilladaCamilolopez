package app.domain.services;

import app.domain.entities.Appointment;
import app.domain.ports.AppointmentPort;

public class AppointmentService {
	
	// dependencia con el puerto  de appointmentport
	private final AppointmentPort appointmentPort;
	
	
	// constructor con su inyeccion de dependencias(spring)

	public AppointmentService(AppointmentPort appointmentPort) {
		this.appointmentPort = appointmentPort;
	}
	// metodo para registrar una nueva cita
	public void registerAppointment(Appointment appointment) throws Exception {
	 // valido que no exista una cita con el mismo id
        if (appointmentPort.findById(appointment.getAppointmentId()) != null) {
            throw new Exception(" An appointment with THIS ID  already exists.");
        }
        // si no existe, se guarda la cita 
        appointmentPort.save(appointment);
	}

}
