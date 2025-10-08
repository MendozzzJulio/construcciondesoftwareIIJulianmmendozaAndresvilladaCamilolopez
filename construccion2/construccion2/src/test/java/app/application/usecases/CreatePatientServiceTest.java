package app.application.usecases;


import app.domain.entities.Patient;
import app.domain.entities.enums.Role;
import app.domain.repository.PatientRepository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreatePatientServiceTest {

    @Test
    void shouldCreatePatientWhenRoleIsAdministrative() {
        PatientRepository patientRepository = mock(PatientRepository.class);
        Patient patient = new Patient(123L, "Carlos", "Sura", "pipi");
        when(patientRepository.save(patient)).thenReturn(patient);

        CreatePatientService service = new CreatePatientService(patientRepository);

        Patient result = service.create(patient, Role.ADMINISTRATIVE);

        assertEquals(patient, result);
        verify(patientRepository).save(patient);
    }
    @Test

	void shouldThrowExceptionWhenPatientAlreadyExists() {

		PatientRepository patientRepository = mock(PatientRepository.class);
		Patient patient = new Patient(123L, "Carlos", "Sura", "pipi");
		when(patientRepository.findById(123L)).thenReturn(patient);

		CreatePatientService service = new CreatePatientService(patientRepository);

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			service.create(patient, Role.ADMINISTRATIVE);
		});

		assertTrue(exception.getMessage().contains("ya existe."));
		verify(patientRepository, never()).save(any());
	}

    @Test
    void shouldThrowExceptionWhenRoleIsNotAdministrative() {
        PatientRepository patientRepository = mock(PatientRepository.class);
        Patient patient = new Patient(123L, "Carlos", "Sura", "pipi");
        CreatePatientService service = new CreatePatientService(patientRepository);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.create(patient, Role.DOCTOR);
        });

        assertEquals("Solo un personal administrativo puede crar pacientes.", exception.getMessage());
        verify(patientRepository, never()).save(any());
    }
}