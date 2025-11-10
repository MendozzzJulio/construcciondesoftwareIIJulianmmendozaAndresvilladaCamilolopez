package app.infrastructure.adapter.api.rest.mapper;

import org.springframework.stereotype.Component;

import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.entities.valueobjects.Address;
import app.domain.entities.valueobjects.Email;
import app.domain.entities.valueobjects.PhoneNumber;
import app.infrastructure.adapter.api.rest.dto.request.CreateUserRequest;
import app.infrastructure.adapter.api.rest.dto.response.UserResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Mapper para convertir entre entidades User y DTOs
 */
@Component
public class UserMapper {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    /**
     * Convierte CreateUserRequest a entidad User
     */
    public User toEntity(CreateUserRequest request) {
        if (request == null) {
            return null;
        }
        
        User user = new User();
        
        // Campos básicos de Person
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setDocument(request.getDocument());
        user.setAge(request.getAge());
        
        // Email
        if (request.getEmail() != null) {
            Email email = new Email();
            email.setEmail(request.getEmail());
            user.setEmail(email);
        }
        
        // PhoneNumber
        if (request.getPhoneNumber() != null) {
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.setPhoneNumber(request.getPhoneNumber());
            user.setPhoneNumber(phoneNumber);
        }
        
        // Address
        if (request.getAddress() != null) {
            Address address = new Address();
            address.setStreet(request.getAddress().getStreet());
            address.setCity(request.getAddress().getCity());
            address.setState(request.getAddress().getState());
            address.setZipCode(request.getAddress().getZipCode());
            user.setAddress(address);
        }
        
        // Date of birth
        if (request.getDateOfBirth() != null) {
            LocalDate dateOfBirth = LocalDate.parse(request.getDateOfBirth(), DATE_FORMATTER);
            user.setDateOfBirth(dateOfBirth);
        }
        
        // Campos específicos de User
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        
        if (request.getRole() != null) {
            user.setRole(Role.valueOf(request.getRole().toUpperCase()));
        }
        
        return user;
    }
    
    /**
     * Convierte entidad User a UserResponse
     */
    public UserResponse toResponse(User user) {
        if (user == null) {
            return null;
        }
        
        UserResponse response = new UserResponse();
        
        // Campos básicos
        response.setId(user.getId());
        response.setName(user.getName());
        response.setLastName(user.getLastName());
        response.setDocument(user.getDocument());
        response.setAge(user.getAge());
        
        // Email
        if (user.getEmail() != null) {
            response.setEmail(user.getEmail().getEmail());
        }
        
        // PhoneNumber
        if (user.getPhoneNumber() != null) {
            response.setPhoneNumber(user.getPhoneNumber().getPhoneNumber());
        }
        
        // Address
        if (user.getAddress() != null) {
            UserResponse.AddressResponse addressResponse = new UserResponse.AddressResponse();
            addressResponse.setStreet(user.getAddress().getStreet());
            addressResponse.setCity(user.getAddress().getCity());
            addressResponse.setState(user.getAddress().getState());
            addressResponse.setZipCode(user.getAddress().getZipCode());
            response.setAddress(addressResponse);
        }
        
        // Date of birth
        if (user.getDateOfBirth() != null) {
            response.setDateOfBirth(user.getDateOfBirth().format(DATE_FORMATTER));
        }
        
        // Campos específicos de User
        response.setUsername(user.getUsername());
        
        if (user.getRole() != null) {
            response.setRole(user.getRole().toString());
        }
        
        // Nota: No incluimos la contraseña en la respuesta por seguridad
        
        return response;
    }
}
