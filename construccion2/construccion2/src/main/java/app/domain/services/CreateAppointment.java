package app.domain.services;

import app.domain.entities.Appointment;
import app.domain.ports.AppointmentPort;

public class CreateAppointment {
	
	// dependencia con el puerto  de appointmentport
	private final AppointmentPort appointmentPort;
	
	
	// constructor con su inyeccion de dependencias(spring)

	public CreateAppointment(AppointmentPort appointmentPort) {
		this.appointmentPort = appointmentPort;
	}
	// metodo para crear una nueva cita
	public void createAppointment(Appointment appointment) throws Exception {
	 // valido que no exista una cita con el mismo id
        if (appointmentPort.findById(appointment.getAppointmentId()) != null) {
            throw new Exception(" An appointment with THIS ID  already exists.");
        }
        // si no existe, se guarda la cita 
        appointmentPort.save(appointment);
	}

}
