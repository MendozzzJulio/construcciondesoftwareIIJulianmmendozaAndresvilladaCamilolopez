package app.infrastructure.adapter.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.application.usecase.DoctorsUseCase;
import app.domain.entities.MedicalOrder;
import app.domain.entities.MedicalOrderType;
import app.domain.entities.MedicalRecord;
import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.enums.MedicalItemType;
import app.domain.entities.enums.Role;
import app.domain.services.AuthenticationService;
import app.infrastructure.adapter.api.rest.dto.request.CreateMedicalOrderRequest;
import app.infrastructure.adapter.api.rest.dto.request.CreateMedicalRecordRequest;
import app.infrastructure.adapter.api.rest.dto.request.CreatePatientRequest;
import app.infrastructure.adapter.api.rest.dto.response.PatientResponse;
import app.infrastructure.adapter.api.rest.exception.ValidationException;
import app.infrastructure.adapter.api.rest.mapper.PatientMapper;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador REST para operaciones de los médicos
 * Maneja la gestión de registros médicos, órdenes médicas y pacientes
 */
@RestController
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {
    
    @Autowired
    private DoctorsUseCase doctorsUseCase;
    
    @Autowired
    private AuthenticationService authenticationService;
    
    @Autowired
    private PatientMapper patientMapper;
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    /**
     * Crear un nuevo paciente
     * Los médicos pueden registrar pacientes durante consultas
     */
    @PostMapping("/patients")
    public ResponseEntity<PatientResponse> createPatient(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @RequestBody CreatePatientRequest request) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Validar request
            validateCreatePatientRequest(request);
            
            // Convertir DTO a entidad
            Patient patient = patientMapper.toEntity(request);
            
            // Crear paciente
            doctorsUseCase.createPatient(patient);
            
            // Convertir respuesta
            PatientResponse response = patientMapper.toResponse(patient);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al crear paciente: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Crear un nuevo registro médico
     * Los médicos documentan consultas, diagnósticos y tratamientos
     */
    @PostMapping("/medical-records")
    public ResponseEntity<String> createMedicalRecord(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @RequestBody CreateMedicalRecordRequest request) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Validar request
            validateCreateMedicalRecordRequest(request);
            
            // Convertir DTO a entidad
            MedicalRecord medicalRecord = toMedicalRecordEntity(request);
            
            // Crear registro médico
            doctorsUseCase.createMedicalRecord(medicalRecord);
            
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Registro médico creado exitosamente");
            
        } catch (Exception e) {
            throw new RuntimeException("Error al crear registro médico: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Actualizar un registro médico existente
     * Permite modificar información clínica según evolución del paciente
     */
    @PutMapping("/medical-records/{recordId}")
    public ResponseEntity<String> updateMedicalRecord(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable Long recordId,
            @RequestBody CreateMedicalRecordRequest request) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Validar request
            validateCreateMedicalRecordRequest(request);
            
            // Convertir DTO a entidad
            MedicalRecord medicalRecord = toMedicalRecordEntity(request);
            medicalRecord.setId(recordId);
            
            // Actualizar registro médico
            doctorsUseCase.updateMedicalRecord(medicalRecord);
            
            return ResponseEntity.ok("Registro médico actualizado exitosamente");
            
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar registro médico: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Buscar registros médicos de un paciente
     * Consulta el historial clínico completo para toma de decisiones
     */
    @GetMapping("/medical-records/patient/{document}")
    public ResponseEntity<List<String>> searchMedicalRecords(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable Long document) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Crear paciente para búsqueda
            Patient patient = new Patient();
            patient.setDocument(document);
            
            // Buscar registros médicos
            List<MedicalRecord> records = doctorsUseCase.searchMedicalRecord(patient);
            
            // Convertir a respuesta simple (en una implementación real usarías un DTO apropiado)
            List<String> response = new ArrayList<>();
            for (MedicalRecord record : records) {
                response.add("Registro ID: " + record.getId() + " - Diagnóstico: " + 
                           (record.getDiagnosis() != null ? record.getDiagnosis() : "N/A"));
            }
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar registros médicos: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Crear una orden médica
     * Prescribe medicamentos, procedimientos o ayudas diagnósticas
     */
    @PostMapping("/medical-orders")
    public ResponseEntity<String> createMedicalOrder(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @RequestBody CreateMedicalOrderRequest request) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Validar request
            validateCreateMedicalOrderRequest(request);
            
            // Convertir DTO a entidad
            MedicalOrder medicalOrder = toMedicalOrderEntity(request);
            
            // Crear orden médica
            doctorsUseCase.createMedicalOrder(medicalOrder);
            
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Orden médica creada exitosamente");
            
        } catch (Exception e) {
            throw new RuntimeException("Error al crear orden médica: " + e.getMessage(), e);
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
    
    private MedicalRecord toMedicalRecordEntity(CreateMedicalRecordRequest request) {
        MedicalRecord record = new MedicalRecord();
        
        // Paciente
        Patient patient = new Patient();
        patient.setDocument(request.getPatientDocument());
        record.setPatient(patient);
        
        // Doctor
        User doctor = new User();
        doctor.setId(request.getDoctorId());
        record.setDoctor(doctor);
        
        // Fecha
        if (request.getDate() != null) {
            LocalDate date = LocalDate.parse(request.getDate(), DATE_FORMATTER);
            record.setDate(Date.valueOf(date));
        }
        
        // Otros campos (estos dependen de la estructura real de MedicalRecord)
        // record.setDiagnosis(request.getDiagnosis());
        // record.setTreatment(request.getTreatment());
        // record.setObservations(request.getObservations());
        
        return record;
    }
    
    private MedicalOrder toMedicalOrderEntity(CreateMedicalOrderRequest request) {
        MedicalOrder order = new MedicalOrder();
        
        // Paciente
        Patient patient = new Patient();
        patient.setDocument(request.getPatientDocument());
        order.setPatient(patient);
        
        // Doctor
        User doctor = new User();
        doctor.setId(request.getDoctorId());
        order.setDoctor(doctor);
        
        // Fecha
        if (request.getDate() != null) {
            LocalDate date = LocalDate.parse(request.getDate(), DATE_FORMATTER);
            order.setDate(Date.valueOf(date));
        }
        
        // Items
        if (request.getItems() != null) {
            List<MedicalOrderType> items = new ArrayList<>();
            
            for (CreateMedicalOrderRequest.MedicalOrderItemRequest itemRequest : request.getItems()) {
                MedicalOrderType item = new MedicalOrderType();
                item.setItem(MedicalItemType.valueOf(itemRequest.getType().toUpperCase()));
                item.setDescription(itemRequest.getDescription());
                item.setItemNumber(itemRequest.getQuantity());
                items.add(item);
            }
            
            order.setItems(items);
        }
        
        return order;
    }
    
    // Validaciones
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
    }
    
    private void validateCreateMedicalRecordRequest(CreateMedicalRecordRequest request) {
        if (request == null) {
            throw new ValidationException("Request no puede ser nulo");
        }
        if (request.getPatientDocument() <= 0) {
            throw new ValidationException("El documento del paciente debe ser un número válido");
        }
        if (request.getDoctorId() <= 0) {
            throw new ValidationException("El ID del doctor debe ser un número válido");
        }
        if (request.getDiagnosis() == null || request.getDiagnosis().trim().isEmpty()) {
            throw new ValidationException("El diagnóstico es requerido");
        }
    }
    
    private void validateCreateMedicalOrderRequest(CreateMedicalOrderRequest request) {
        if (request == null) {
            throw new ValidationException("Request no puede ser nulo");
        }
        if (request.getPatientDocument() <= 0) {
            throw new ValidationException("El documento del paciente debe ser un número válido");
        }
        if (request.getDoctorId() <= 0) {
            throw new ValidationException("El ID del doctor debe ser un número válido");
        }
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new ValidationException("La orden médica debe tener al menos un item");
        }
    }
}
