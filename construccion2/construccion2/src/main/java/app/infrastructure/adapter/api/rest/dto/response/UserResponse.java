package app.infrastructure.adapter.api.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para la respuesta de usuarios/empleados
 */
public class UserResponse {
    
    @JsonProperty("id")
    private long id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("lastName")
    private String lastName;
    
    @JsonProperty("document")
    private long document;
    
    @JsonProperty("age")
    private int age;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    
    @JsonProperty("address")
    private AddressResponse address;
    
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    
    @JsonProperty("username")
    private String username;
    
    @JsonProperty("role")
    private String role;
    
    @JsonProperty("createdAt")
    private String createdAt;
    
    // Constructors
    public UserResponse() {}
    
    // Getters y setters
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public long getDocument() {
        return document;
    }
    
    public void setDocument(long document) {
        this.document = document;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public AddressResponse getAddress() {
        return address;
    }
    
    public void setAddress(AddressResponse address) {
        this.address = address;
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    /**
     * DTO anidado para la dirección en respuesta
     */
    public static class AddressResponse {
        @JsonProperty("street")
        private String street;
        
        @JsonProperty("city")
        private String city;
        
        @JsonProperty("state")
        private String state;
        
        @JsonProperty("zipCode")
        private String zipCode;
        
        // Getters y setters
        public String getStreet() {
            return street;
        }
        
        public void setStreet(String street) {
            this.street = street;
        }
        
        public String getCity() {
            return city;
        }
        
        public void setCity(String city) {
            this.city = city;
        }
        
        public String getState() {
            return state;
        }
        
        public void setState(String state) {
            this.state = state;
        }
        
        public String getZipCode() {
            return zipCode;
        }
        
        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}
