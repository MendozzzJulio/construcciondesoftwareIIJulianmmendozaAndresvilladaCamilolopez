package app.infrastructure.adapter.api.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO para la respuesta de facturas médicas
 */
public class BillingResponse {
    
    @JsonProperty("billingDate")
    private String billingDate;
    
    @JsonProperty("patient")
    private PatientInfo patient;
    
    @JsonProperty("doctor")
    private DoctorInfo doctor;
    
    @JsonProperty("medicalInsurance")
    private MedicalInsuranceInfo medicalInsurance;
    
    @JsonProperty("medicalOrders")
    private List<MedicalOrderInfo> medicalOrders;
    
    @JsonProperty("totalAmount")
    private BigDecimal totalAmount;
    
    @JsonProperty("copayAmount")
    private BigDecimal copayAmount;
    
    @JsonProperty("insuranceAmount")
    private BigDecimal insuranceAmount;
    
    @JsonProperty("patientAmount")
    private BigDecimal patientAmount;
    
    @JsonProperty("hasActivePolicy")
    private boolean hasActivePolicy;
    
    @JsonProperty("yearlyCopayCumulative")
    private BigDecimal yearlyCopayCumulative;
    
    @JsonProperty("billingDetails")
    private String billingDetails;
    
    // Constructors
    public BillingResponse() {}
    
    // Getters y setters
    public String getBillingDate() {
        return billingDate;
    }
    
    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }
    
    public PatientInfo getPatient() {
        return patient;
    }
    
    public void setPatient(PatientInfo patient) {
        this.patient = patient;
    }
    
    public DoctorInfo getDoctor() {
        return doctor;
    }
    
    public void setDoctor(DoctorInfo doctor) {
        this.doctor = doctor;
    }
    
    public MedicalInsuranceInfo getMedicalInsurance() {
        return medicalInsurance;
    }
    
    public void setMedicalInsurance(MedicalInsuranceInfo medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }
    
    public List<MedicalOrderInfo> getMedicalOrders() {
        return medicalOrders;
    }
    
    public void setMedicalOrders(List<MedicalOrderInfo> medicalOrders) {
        this.medicalOrders = medicalOrders;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public BigDecimal getCopayAmount() {
        return copayAmount;
    }
    
    public void setCopayAmount(BigDecimal copayAmount) {
        this.copayAmount = copayAmount;
    }
    
    public BigDecimal getInsuranceAmount() {
        return insuranceAmount;
    }
    
    public void setInsuranceAmount(BigDecimal insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }
    
    public BigDecimal getPatientAmount() {
        return patientAmount;
    }
    
    public void setPatientAmount(BigDecimal patientAmount) {
        this.patientAmount = patientAmount;
    }
    
    public boolean isHasActivePolicy() {
        return hasActivePolicy;
    }
    
    public void setHasActivePolicy(boolean hasActivePolicy) {
        this.hasActivePolicy = hasActivePolicy;
    }
    
    public BigDecimal getYearlyCopayCumulative() {
        return yearlyCopayCumulative;
    }
    
    public void setYearlyCopayCumulative(BigDecimal yearlyCopayCumulative) {
        this.yearlyCopayCumulative = yearlyCopayCumulative;
    }
    
    public String getBillingDetails() {
        return billingDetails;
    }
    
    public void setBillingDetails(String billingDetails) {
        this.billingDetails = billingDetails;
    }
    
    // DTOs anidados
    public static class PatientInfo {
        @JsonProperty("name")
        private String name;
        
        @JsonProperty("lastName")
        private String lastName;
        
        @JsonProperty("document")
        private long document;
        
        @JsonProperty("age")
        private int age;
        
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
    }
    
    public static class DoctorInfo {
        @JsonProperty("name")
        private String name;
        
        @JsonProperty("lastName")
        private String lastName;
        
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
    }
    
    public static class MedicalInsuranceInfo {
        @JsonProperty("companyName")
        private String companyName;
        
        @JsonProperty("policyNumber")
        private long policyNumber;
        
        @JsonProperty("policyStatus")
        private boolean policyStatus;
        
        @JsonProperty("policyEndDate")
        private String policyEndDate;
        
        // Getters y setters
        public String getCompanyName() {
            return companyName;
        }
        
        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }
        
        public long getPolicyNumber() {
            return policyNumber;
        }
        
        public void setPolicyNumber(long policyNumber) {
            this.policyNumber = policyNumber;
        }
        
        public boolean isPolicyStatus() {
            return policyStatus;
        }
        
        public void setPolicyStatus(boolean policyStatus) {
            this.policyStatus = policyStatus;
        }
        
        public String getPolicyEndDate() {
            return policyEndDate;
        }
        
        public void setPolicyEndDate(String policyEndDate) {
            this.policyEndDate = policyEndDate;
        }
    }
    
    public static class MedicalOrderInfo {
        @JsonProperty("id")
        private long id;
        
        @JsonProperty("date")
        private String date;
        
        @JsonProperty("items")
        private List<MedicalOrderItemInfo> items;
        
        // Getters y setters
        public long getId() {
            return id;
        }
        
        public void setId(long id) {
            this.id = id;
        }
        
        public String getDate() {
            return date;
        }
        
        public void setDate(String date) {
            this.date = date;
        }
        
        public List<MedicalOrderItemInfo> getItems() {
            return items;
        }
        
        public void setItems(List<MedicalOrderItemInfo> items) {
            this.items = items;
        }
    }
    
    public static class MedicalOrderItemInfo {
        @JsonProperty("type")
        private String type;
        
        @JsonProperty("description")
        private String description;
        
        @JsonProperty("quantity")
        private int quantity;
        
        @JsonProperty("cost")
        private BigDecimal cost;
        
        // Getters y setters
        public String getType() {
            return type;
        }
        
        public void setType(String type) {
            this.type = type;
        }
        
        public String getDescription() {
            return description;
        }
        
        public void setDescription(String description) {
            this.description = description;
        }
        
        public int getQuantity() {
            return quantity;
        }
        
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
        
        public BigDecimal getCost() {
            return cost;
        }
        
        public void setCost(BigDecimal cost) {
            this.cost = cost;
        }
    }
}
