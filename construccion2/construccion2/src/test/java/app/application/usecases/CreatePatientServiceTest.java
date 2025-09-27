
package app.application.usecases;

import app.domain.entities.Patient;
import app.domain.entities.enums.Role;
import app.domain.ports.out.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CreatePatientServiceTest {

    private PatientRepository patientRepository;
    private CreatePatientService service;

    @BeforeEach
    void setUp() {
        patientRepository = mock(PatientRepository.class);
        service = new CreatePatientService(patientRepository);
    }

    @Test
    void shouldCreatePatientWhenRoleIsAdministrative() {
        Patient patient = new Patient(123L, "Juan Pérez","M","01/01/1990", null);
        when(patientRepository.existsById(123L)).thenReturn(false);

        service.create(patient, Role.ADMINISTRATIVE);

        verify(patientRepository).save(patient);
    }

    @Test
    void shouldThrowExceptionWhenRoleIsNotAdministrative() {
        Patient patient = new Patient(123L, "Juan Pérez","M","01/01/1990", null);

        assertThrows(IllegalArgumentException.class, () -> {
            service.create(patient, Role.DOCTOR);
        });
    }

    @Test
    void shouldThrowExceptionWhenPatientAlreadyExists() {

    	 Patient patient = new Patient(123L, "Juan Pérez","M","01/01/1990", null);
    	    patient.setId(123L); // Este ID debe coincidir con el que se mockea
    	    patient.setName("Juan");
    	    patient.setLastName("Pérez");
    	    patient.setGender("M");
    	    patient.setBirthDate("01/01/1990");

    	    when(patientRepository.existsById(123L)).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> {
            service.create(patient, Role.ADMINISTRATIVE);
        });
    }
}
