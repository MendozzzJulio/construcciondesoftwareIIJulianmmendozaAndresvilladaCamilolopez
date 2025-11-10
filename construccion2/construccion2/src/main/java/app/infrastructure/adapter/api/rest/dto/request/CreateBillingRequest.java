package app.infrastructure.adapter.api.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * DTO para la creación de facturas médicas
 */
public class CreateBillingRequest {
    
    @JsonProperty("patientDocument")
    private long patientDocument;
    
    @JsonProperty("doctorId")
    private long doctorId;
    
    @JsonProperty("medicalInsurance")
    private MedicalInsuranceRequest medicalInsurance;
    
    @JsonProperty("yearlyCopayCumulative")
    private BigDecimal yearlyCopayCumulative;
    
    // Constructors
    public CreateBillingRequest() {}
    
    // Getters y setters
    public long getPatientDocument() {
        return patientDocument;
    }
    
    public void setPatientDocument(long patientDocument) {
        this.patientDocument = patientDocument;
    }
    
    public long getDoctorId() {
        return doctorId;
    }
    
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }
    
    public MedicalInsuranceRequest getMedicalInsurance() {
        return medicalInsurance;
    }
    
    public void setMedicalInsurance(MedicalInsuranceRequest medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }
    
    public BigDecimal getYearlyCopayCumulative() {
        return yearlyCopayCumulative;
    }
    
    public void setYearlyCopayCumulative(BigDecimal yearlyCopayCumulative) {
        this.yearlyCopayCumulative = yearlyCopayCumulative;
    }
    
    /**
     * DTO anidado para el seguro médico
     */
    public static class MedicalInsuranceRequest {
        @JsonProperty("companyName")
        private String companyName;
        
        @JsonProperty("policyNumber")
        private long policyNumber;
        
        @JsonProperty("policyStatus")
        private boolean policyStatus;
        
        @JsonProperty("policyEndDate")
        private String policyEndDate; // Format: YYYY-MM-DD
        
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
}
