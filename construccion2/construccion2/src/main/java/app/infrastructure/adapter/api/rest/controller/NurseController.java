package app.infrastructure.adapter.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.application.usecase.NursesUseCase;
import app.domain.entities.MedicalOrder;
import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.Visit;
import app.domain.entities.enums.Role;
import app.domain.services.AuthenticationService;
import app.infrastructure.adapter.api.rest.dto.request.CreateVisitRequest;
import app.infrastructure.adapter.api.rest.dto.response.PatientResponse;
import app.infrastructure.adapter.api.rest.exception.ValidationException;
import app.infrastructure.adapter.api.rest.mapper.PatientMapper;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador REST para operaciones de las enfermeras
 * Maneja el registro de visitas, búsqueda de órdenes médicas y pacientes
 */
@RestController
@RequestMapping("/api/nurse")
@CrossOrigin(origins = "*")
public class NurseController {
    
    @Autowired
    private NursesUseCase nursesUseCase;
    
    @Autowired
    private AuthenticationService authenticationService;
    
    @Autowired
    private PatientMapper patientMapper;
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    /**
     * Registrar una nueva visita médica
     * Las enfermeras pueden documentar visitas y intervenciones
     */
    @PostMapping("/visits")
    public ResponseEntity<String> registerVisit(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @RequestBody CreateVisitRequest request) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Validar request
            validateCreateVisitRequest(request);
            
            // Convertir DTO a entidad
            Visit visit = toVisitEntity(request);
            
            // Registrar visita
            nursesUseCase.registerVisit(visit);
            
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Visita registrada exitosamente");
            
        } catch (Exception e) {
            throw new RuntimeException("Error al registrar visita: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Buscar órdenes médicas
     * Permite a las enfermeras consultar las órdenes para ejecutar tratamientos
     */
    @GetMapping("/medical-orders")
    public ResponseEntity<List<String>> searchMedicalOrders(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @RequestParam(required = false) Long patientDocument,
            @RequestParam(required = false) Long orderId) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Crear orden médica para búsqueda
            MedicalOrder searchOrder = new MedicalOrder();
            
            if (orderId != null) {
                searchOrder.setId(orderId);
            }
            
            if (patientDocument != null) {
                Patient patient = new Patient();
                patient.setDocument(patientDocument);
                searchOrder.setPatient(patient);
            }
            
            // Buscar órdenes médicas
            List<MedicalOrder> orders = nursesUseCase.searchMedicalOrder(searchOrder);
            
            // Convertir a respuesta simple (en una implementación real usarías un DTO apropiado)
            List<String> response = new ArrayList<>();
            for (MedicalOrder order : orders) {
                response.add("Orden ID: " + order.getId() + 
                           " - Paciente: " + (order.getPatient() != null ? order.getPatient().getDocument() : "N/A") +
                           " - Fecha: " + (order.getDate() != null ? order.getDate().toString() : "N/A"));
            }
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar órdenes médicas: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Buscar paciente en el sistema
     * Necesario para localizar pacientes durante las rondas médicas
     */
    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponse>> searchPatients(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @RequestParam(required = false) Long document,
            @RequestParam(required = false) String name) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Crear paciente para búsqueda
            Patient searchPatient = new Patient();
            
            if (document != null) {
                searchPatient.setDocument(document);
            }
            
            if (name != null) {
                searchPatient.setName(name);
            }
            
            // Buscar pacientes
            List<Patient> patients = nursesUseCase.searchPatient(searchPatient);
            
            // Convertir a respuesta
            List<PatientResponse> response = new ArrayList<>();
            for (Patient patient : patients) {
                response.add(patientMapper.toResponse(patient));
            }
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar pacientes: " + e.getMessage(), e);
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
    
    private Visit toVisitEntity(CreateVisitRequest request) {
        Visit visit = new Visit();
        
        // Paciente
        Patient patient = new Patient();
        patient.setDocument(request.getPatientDocument());
        visit.setPatient(patient);
        
        // Enfermera
        User nurse = new User();
        nurse.setId(request.getNurseId());
        visit.setNurse(nurse);
        
        // Fecha
        if (request.getDate() != null) {
            LocalDate date = LocalDate.parse(request.getDate(), DATE_FORMATTER);
            visit.setDate(Date.valueOf(date));
        }
        
        // Otros campos (estos dependen de la estructura real de Visit)
        // visit.setObservations(request.getObservations());
        // visit.setVitalSigns(request.getVitalSigns());
        
        return visit;
    }
    
    // Validaciones
    private void validateCreateVisitRequest(CreateVisitRequest request) {
        if (request == null) {
            throw new ValidationException("Request no puede ser nulo");
        }
        if (request.getPatientDocument() <= 0) {
            throw new ValidationException("El documento del paciente debe ser un número válido");
        }
        if (request.getNurseId() <= 0) {
            throw new ValidationException("El ID de la enfermera debe ser un número válido");
        }
        if (request.getDate() == null || request.getDate().trim().isEmpty()) {
            throw new ValidationException("La fecha es requerida");
        }
    }
}
