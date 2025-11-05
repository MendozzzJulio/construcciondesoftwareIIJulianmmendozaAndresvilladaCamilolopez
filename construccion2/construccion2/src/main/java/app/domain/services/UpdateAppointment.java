package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Appointment;
import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.AppointmentPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

@Service
public class UpdateAppointment {
	@Autowired
	private AppointmentPort appointmentPort;
	@Autowired
	private UserPort userPort;
	@Autowired
	private PatientPort patientPort;

    public void update(Appointment appointment) throws Exception {
        
        if (appointment == null) {
            throw new Exception("La cita no puede ser nula");
        }
        
        Appointment existingAppointment = appointmentPort.findById(appointment);
        if (existingAppointment == null) {
            throw new Exception("La cita a actualizar no existe en el sistema");
        }
        
        if (appointment.getDoctor() != null) {
            User doctor = userPort.findById(appointment.getDoctor());
            if (doctor == null) {
                throw new Exception("El doctor especificado no existe en el sistema");
            }
            
            if (!doctor.getRole().equals(Role.DOCTOR)) {
                throw new Exception("El usuario asignado como doctor debe tener rol de médico");
            }
        }
        
        if (appointment.getPatient() != null) {
            Patient patient = patientPort.findById(appointment.getPatient());
            if (patient == null) {
                throw new Exception("El paciente especificado no existe en el sistema");
            }
        }
        
        if (appointment.getDate() != null && appointment.getDoctor() != null) {
            if (!appointmentPort.isDoctorAvailable(appointment.getDoctor(), appointment.getDate())) {
                throw new Exception("El doctor ya tiene una cita agendada para esa fecha y hora");
            }
        }

        if (appointment.getDate() != null && appointment.getPatient() != null) {
            if (!appointmentPort.isPatientAvailable(appointment.getPatient(), appointment.getDate())) {
                throw new Exception("El paciente ya tiene una cita agendada para esa fecha y hora");
            }
        }
        
        appointmentPort.save(appointment);
    }
}
