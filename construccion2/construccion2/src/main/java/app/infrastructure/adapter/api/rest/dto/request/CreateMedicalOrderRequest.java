package app.infrastructure.adapter.api.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * DTO para la creación de órdenes médicas
 */
public class CreateMedicalOrderRequest {
    
    @JsonProperty("patientDocument")
    private long patientDocument;
    
    @JsonProperty("doctorId")
    private long doctorId;
    
    @JsonProperty("date")
    private String date; // Format: YYYY-MM-DD
    
    @JsonProperty("items")
    private List<MedicalOrderItemRequest> items;
    
    // Constructors
    public CreateMedicalOrderRequest() {}
    
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
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public List<MedicalOrderItemRequest> getItems() {
        return items;
    }
    
    public void setItems(List<MedicalOrderItemRequest> items) {
        this.items = items;
    }
    
    /**
     * DTO anidado para los items de la orden médica
     */
    public static class MedicalOrderItemRequest {
        @JsonProperty("type")
        private String type; // MEDICATION, PROCEDURE, DIAGNOSTIC_AID, RECOMMENDATION
        
        @JsonProperty("description")
        private String description;
        
        @JsonProperty("quantity")
        private int quantity;
        
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
    }
}
