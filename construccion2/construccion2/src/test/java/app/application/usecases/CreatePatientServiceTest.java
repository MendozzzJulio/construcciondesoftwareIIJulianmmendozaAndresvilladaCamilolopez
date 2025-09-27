package app.application.usecases;

import app.domain.entities.Patient;
import app.domain.entities.enums.Role;
import app.domain.ports.out.PatientRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreatePatientServiceTest {

    @Test
    void shouldCreatePatientWhenRoleIsAdministrative() {
        PatientRepository patientRepository = mock(PatientRepository.class);
        Patient patient = new Patient(123L, "John Doe"," 1234567890", "carlos");
        when(patientRepository.save(patient)).thenReturn(patient);

        CreatePatientService service = new CreatePatientService(patientRepository);

        Patient result = service.create(patient, Role.AMINISTRATIVE);

        assertEquals(patient, result);
        verify(patientRepository).save(patient);
    }
   @Test

	void shouldThrowExceptionWhenPatientAlreadyExists() {

		PatientRepository patientRepository = mock(PatientRepository.class);
		Patient patient = new Patient(123L, "Jane Doe", " 1234567890", "carlos");
		when(patientRepository.findById(123L)).thenReturn(patient);

		CreatePatientService service = new CreatePatientService(patientRepository);

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			service.create(patient, Role.AMINISTRATIVE);
		});

		assertEquals("El paciente con id 123 ya existe.", exception.getMessage());
		verify(patientRepository, never()).save(any());
	}

    @Test
    void shouldThrowExceptionWhenRoleIsNotAdministrative() {
        PatientRepository patientRepository = mock(PatientRepository.class);
        Patient patient = new Patient(123L, "Jane Doe"," 1234567890", "carlos");
        CreatePatientService service = new CreatePatientService(patientRepository);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.create(patient, Role.DOCTOR);
        });

        assertEquals("Only an administrative can create a patient.", exception.getMessage());
        verify(patientRepository, never()).save(any());
    }
}