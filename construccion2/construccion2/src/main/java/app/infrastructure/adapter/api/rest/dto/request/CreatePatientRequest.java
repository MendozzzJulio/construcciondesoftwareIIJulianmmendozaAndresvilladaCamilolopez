package app.infrastructure.adapter.api.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para la creación de pacientes
 */
public class CreatePatientRequest {
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("lastName")
    private String lastName;
    
    @JsonProperty("document")
    private long document;
    
    @JsonProperty("age")
    private int age;
    
    @JsonProperty("gender")
    private String gender;
    
    @JsonProperty("weight")
    private double weight;
    
    @JsonProperty("height")
    private double height;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    
    @JsonProperty("address")
    private AddressRequest address;
    
    @JsonProperty("dateOfBirth")
    private String dateOfBirth; // Format: YYYY-MM-DD
    
    // Constructors
    public CreatePatientRequest() {}
    
    // Getters y setters
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
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
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
    
    public AddressRequest getAddress() {
        return address;
    }
    
    public void setAddress(AddressRequest address) {
        this.address = address;
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * DTO anidado para la dirección
     */
    public static class AddressRequest {
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
