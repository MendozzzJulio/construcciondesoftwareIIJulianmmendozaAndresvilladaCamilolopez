package app.infrastructure.adapter.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.application.usecase.HRUseCase;
import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.services.AuthenticationService;
import app.infrastructure.adapter.api.rest.dto.request.CreateUserRequest;
import app.infrastructure.adapter.api.rest.dto.response.UserResponse;
import app.infrastructure.adapter.api.rest.exception.ValidationException;
import app.infrastructure.adapter.api.rest.mapper.UserMapper;

/**
 * Controlador REST para operaciones de Recursos Humanos
 * Maneja la gestión completa de empleados del sistema
 */
@RestController
@RequestMapping("/api/hr")
@CrossOrigin(origins = "*")
public class HRController {
    
    @Autowired
    private HRUseCase hrUseCase;
    
    @Autowired
    private AuthenticationService authenticationService;
    
    @Autowired
    private UserMapper userMapper;
    
    /**
     * Crear un nuevo empleado en el sistema
     * Solo usuarios con rol HR pueden ejecutar esta acción
     */
    @PostMapping("/employees")
    public ResponseEntity<UserResponse> createEmployee(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @RequestBody CreateUserRequest request) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Validar request
            validateCreateUserRequest(request);
            
            // Convertir DTO a entidad
            User employee = userMapper.toEntity(request);
            
            // Crear empleado
            hrUseCase.createEmployee(employee);
            
            // Convertir respuesta
            UserResponse response = userMapper.toResponse(employee);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al crear empleado: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Actualizar información de un empleado existente
     * Solo usuarios con rol HR pueden ejecutar esta acción
     */
    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<UserResponse> updateEmployee(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable Long employeeId,
            @RequestBody CreateUserRequest request) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Validar request
            validateCreateUserRequest(request);
            
            // Convertir DTO a entidad
            User employee = userMapper.toEntity(request);
            employee.setId(employeeId);
            
            // Actualizar empleado
            hrUseCase.updateEmployee(employee);
            
            // Convertir respuesta
            UserResponse response = userMapper.toResponse(employee);
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar empleado: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Eliminar un empleado del sistema
     * Solo usuarios con rol HR pueden ejecutar esta acción
     */
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable Long employeeId) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Crear usuario para eliminación
            User employee = new User();
            employee.setId(employeeId);
            
            // Eliminar empleado
            hrUseCase.deleteEmployee(employee);
            
            return ResponseEntity.ok("Empleado eliminado exitosamente");
            
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar empleado: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Buscar empleado por ID
     */
    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<UserResponse> searchEmployee(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable Long employeeId) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Crear usuario para búsqueda
            User searchUser = new User();
            searchUser.setId(employeeId);
            
            // Buscar empleado
            User foundEmployee = hrUseCase.searchEmployee(searchUser);
            
            // Convertir respuesta
            UserResponse response = userMapper.toResponse(foundEmployee);
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar empleado: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Buscar empleado por documento
     */
    @GetMapping("/employees/document/{document}")
    public ResponseEntity<UserResponse> searchEmployeeByDocument(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable Long document) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Crear usuario para búsqueda
            User searchUser = new User();
            searchUser.setDocument(document);
            
            // Buscar empleado por documento
            User foundEmployee = hrUseCase.searchEmployeeByDocument(searchUser);
            
            // Convertir respuesta
            UserResponse response = userMapper.toResponse(foundEmployee);
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar empleado por documento: " + e.getMessage(), e);
        } finally {
            authenticationService.clearCurrentUser();
        }
    }
    
    /**
     * Buscar empleado por nombre de usuario
     */
    @GetMapping("/employees/username/{username}")
    public ResponseEntity<UserResponse> searchEmployeeByUsername(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable String username) {
        
        try {
            // Establecer usuario en contexto
            User currentUser = createUserFromHeaders(userId, userRole);
            authenticationService.setCurrentUser(currentUser);
            
            // Crear usuario para búsqueda
            User searchUser = new User();
            searchUser.setUsername(username);
            
            // Buscar empleado por username
            User foundEmployee = hrUseCase.searchEmployeeByUsername(searchUser);
            
            // Convertir respuesta
            UserResponse response = userMapper.toResponse(foundEmployee);
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar empleado por username: " + e.getMessage(), e);
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
    
    // Validaciones
    private void validateCreateUserRequest(CreateUserRequest request) {
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
        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new ValidationException("El nombre de usuario es requerido");
        }
        if (request.getPassword() == null || request.getPassword().length() < 6) {
            throw new ValidationException("La contraseña debe tener al menos 6 caracteres");
        }
        if (request.getRole() == null || request.getRole().trim().isEmpty()) {
            throw new ValidationException("El rol es requerido");
        }
    }
}
