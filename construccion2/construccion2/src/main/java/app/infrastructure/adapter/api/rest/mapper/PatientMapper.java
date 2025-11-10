package app.infrastructure.adapter.api.rest.mapper;

import org.springframework.stereotype.Component;

import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.enums.Gender;
import app.domain.entities.valueobjects.Address;
import app.domain.entities.valueobjects.Email;
import app.domain.entities.valueobjects.PhoneNumber;
import app.infrastructure.adapter.api.rest.dto.request.CreatePatientRequest;
import app.infrastructure.adapter.api.rest.dto.response.PatientResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Mapper para convertir entre entidades Patient y DTOs
 */
@Component
public class PatientMapper {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    /**
     * Convierte CreatePatientRequest a entidad Patient
     */
    public Patient toEntity(CreatePatientRequest request) {
        if (request == null) {
            return null;
        }
        
        Patient patient = new Patient();
        
        // Campos básicos de Person
        patient.setName(request.getName());
        patient.setLastName(request.getLastName());
        patient.setDocument(request.getDocument());
        patient.setAge(request.getAge());
        
        // Email
        if (request.getEmail() != null) {
            Email email = new Email();
            email.setEmail(request.getEmail());
            patient.setEmail(email);
        }
        
        // PhoneNumber
        if (request.getPhoneNumber() != null) {
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.setPhoneNumber(request.getPhoneNumber());
            patient.setPhoneNumber(phoneNumber);
        }
        
        // Address
        if (request.getAddress() != null) {
            Address address = new Address();
            address.setStreet(request.getAddress().getStreet());
            address.setCity(request.getAddress().getCity());
            address.setState(request.getAddress().getState());
            address.setZipCode(request.getAddress().getZipCode());
            patient.setAddress(address);
        }
        
        // Date of birth
        if (request.getDateOfBirth() != null) {
            LocalDate dateOfBirth = LocalDate.parse(request.getDateOfBirth(), DATE_FORMATTER);
            patient.setDateOfBirth(dateOfBirth);
        }
        
        // Campos específicos de Patient
        if (request.getGender() != null) {
            patient.setGender(Gender.valueOf(request.getGender().toUpperCase()));
        }
        
        patient.setWeigth(request.getWeight());
        patient.setHeight(request.getHeight());
        
        return patient;
    }
    
    /**
     * Convierte entidad Patient a PatientResponse
     */
    public PatientResponse toResponse(Patient patient) {
        if (patient == null) {
            return null;
        }
        
        PatientResponse response = new PatientResponse();
        
        // Campos básicos
        response.setId(patient.getId());
        response.setName(patient.getName());
        response.setLastName(patient.getLastName());
        response.setDocument(patient.getDocument());
        response.setAge(patient.getAge());
        
        // Email
        if (patient.getEmail() != null) {
            response.setEmail(patient.getEmail().getEmail());
        }
        
        // PhoneNumber
        if (patient.getPhoneNumber() != null) {
            response.setPhoneNumber(patient.getPhoneNumber().getPhoneNumber());
        }
        
        // Address
        if (patient.getAddress() != null) {
            PatientResponse.AddressResponse addressResponse = new PatientResponse.AddressResponse();
            addressResponse.setStreet(patient.getAddress().getStreet());
            addressResponse.setCity(patient.getAddress().getCity());
            addressResponse.setState(patient.getAddress().getState());
            addressResponse.setZipCode(patient.getAddress().getZipCode());
            response.setAddress(addressResponse);
        }
        
        // Date of birth
        if (patient.getDateOfBirth() != null) {
            response.setDateOfBirth(patient.getDateOfBirth().format(DATE_FORMATTER));
        }
        
        // Campos específicos de Patient
        if (patient.getGender() != null) {
            response.setGender(patient.getGender().toString());
        }
        
        response.setWeight(patient.getWeigth());
        response.setHeight(patient.getHeight());
        
        // Doctor
        if (patient.getDoctor() != null) {
            response.setDoctorName(patient.getDoctor().getName() + " " + patient.getDoctor().getLastName());
        }
        
        return response;
    }
}
