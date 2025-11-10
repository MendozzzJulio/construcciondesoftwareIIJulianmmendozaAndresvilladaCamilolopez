package app.infrastructure.adapter.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.application.usecase.AdministrativeUseCase;
import app.domain.entities.Billing;
import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.services.AuthenticationService;
import app.infrastructure.adapter.api.rest.dto.request.CreateBillingRequest;
import app.infrastructure.adapter.api.rest.dto.request.CreatePatientRequest;
import app.infrastructure.adapter.api.rest.dto.response.BillingResponse;
import app.infrastructure.adapter.api.rest.dto.response.PatientResponse;
import app.infrastructure.adapter.api.rest.exception.ValidationException;
import app.infrastructure.adapter.api.rest.mapper.BillingMapper;
import app.infrastructure.adapter.api.rest.mapper.PatientMapper;

/**
 * Controlador REST para operaciones del personal administrativo
 * Maneja la gestión de pacientes, facturas, citas y contactos de emergencia
 */
@RestController
@RequestMapping("/api/administrative")
@CrossOrigin(origins = "*")
public class AdministrativeController {
    
    @Autowired
    private AdministrativeUseCase administrativeUseCase;
    
    @Autowired
    private AuthenticationService authenticationService;
    
    @Autowired
    private PatientMapper patientMapper;
    
    @Autowired
    private BillingMapper billingMapper;
    
    /**
     * Crear un nuevo paciente
     * Solo personal administrativo y doctores pueden crear pacientes
     */
    @PostMapping("/patients")
    public ResponseEntity<PatientResponse> createPatient(@RequestBody CreatePatientRequest request) {
        
        try {
            // Validar request
            validateCreatePatientRequest(request);
            
            // Convertir DTO a entidad
            Patient patient = patientMapper.toEntity(request);
            
            // Crear paciente (el usuario ya está establecido por el JWT filter)
            administrativeUseCase.createPatient(patient);
            
            // Convertir respuesta
            PatientResponse response = patientMapper.toResponse(patient);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al crear paciente: " + e.getMessage(), e);
        }
    }
    
    /**
     * Actualizar información de un paciente existente
     */
    @PutMapping("/patients/{document}")
    public ResponseEntity<PatientResponse> updatePatient(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable Long document,
            @RequestBody CreatePatientRequest request) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Validar request
            validateCreatePatientRequest(request);
            
            // Convertir DTO a entidad
            Patient patient = patientMapper.toEntity(request);
            patient.setDocument(document);
            
            // Actualizar paciente
            administrativeUseCase.updatePatient(patient);
            
            // Convertir respuesta
            PatientResponse response = patientMapper.toResponse(patient);
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar paciente: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Buscar paciente por documento
     */
    @GetMapping("/patients/{document}")
    public ResponseEntity<PatientResponse> searchPatient(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable Long document) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Crear paciente para búsqueda
            Patient searchPatient = new Patient();
            searchPatient.setDocument(document);
            
            // Buscar paciente
            Patient foundPatient = administrativeUseCase.searchPatient(searchPatient);
            
            // Convertir respuesta
            PatientResponse response = patientMapper.toResponse(foundPatient);
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar paciente: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Crear factura para servicios médicos
     * Solo personal administrativo puede crear facturas
     */
    @PostMapping("/billing")
    public ResponseEntity<BillingResponse> createBilling(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @RequestBody CreateBillingRequest request) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Validar request
            validateCreateBillingRequest(request);
            
            // Convertir DTO a entidad
            Billing billing = billingMapper.toEntity(request);
            
            // Crear factura
            administrativeUseCase.createBilling(billing);
            
            // Convertir respuesta
            BillingResponse response = billingMapper.toResponse(billing);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al crear factura: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    // Métodos auxiliares
    private User createUserFromHeaders(Long userId, String userRole) {
        User user = new User();
        user.setId(userId);
        user.setRole(Role.valueOf(userRole.toUpperCase()));
        return user;
    }
    
    private void validateCreatePatientRequest(CreatePatientRequest request) {
        if (request == null) {
            throw new ValidationException("Request no puede ser nulo");
        }
        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new ValidationException("El nombre es requerido");
        }
        if (request.getLastName() == null || request.getLastName().trim().isEmpty()) {
            throw new ValidationException("El apellido es requerido");
        }
        if (request.getDocument() <= 0) {
            throw new ValidationException("El documento debe ser un número válido");
        }
        if (request.getAge() <= 0) {
            throw new ValidationException("La edad debe ser mayor a 0");
        }
        if (request.getPhoneNumber() == null || request.getPhoneNumber().length() != 10) {
            throw new ValidationException("El número de teléfono debe tener exactamente 10 dígitos");
        }
    }
    
    private void validateCreateBillingRequest(CreateBillingRequest request) {
        if (request == null) {
            throw new ValidationException("Request no puede ser nulo");
        }
        if (request.getPatientDocument() <= 0) {
            throw new ValidationException("El documento del paciente debe ser un número válido");
        }
        if (request.getDoctorId() <= 0) {
            throw new ValidationException("El ID del doctor debe ser un número válido");
        }
    }
}
