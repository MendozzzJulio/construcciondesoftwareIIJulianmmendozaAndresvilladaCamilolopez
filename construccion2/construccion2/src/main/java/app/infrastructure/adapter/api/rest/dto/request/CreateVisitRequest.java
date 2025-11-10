package app.infrastructure.adapter.api.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para la creación de visitas médicas
 */
public class CreateVisitRequest {
    
    @JsonProperty("patientDocument")
    private long patientDocument;
    
    @JsonProperty("nurseId")
    private long nurseId;
    
    @JsonProperty("date")
    private String date; // Format: YYYY-MM-DD
    
    @JsonProperty("time")
    private String time; // Format: HH:MM
    
    @JsonProperty("observations")
    private String observations;
    
    @JsonProperty("vitalSigns")
    private VitalSignsRequest vitalSigns;
    
    @JsonProperty("medicationsAdministered")
    private String medicationsAdministered;
    
    @JsonProperty("proceduresPerformed")
    private String proceduresPerformed;
    
    // Constructors
    public CreateVisitRequest() {}
    
    // Getters y setters
    public long getPatientDocument() {
        return patientDocument;
    }
    
    public void setPatientDocument(long patientDocument) {
        this.patientDocument = patientDocument;
    }
    
    public long getNurseId() {
        return nurseId;
    }
    
    public void setNurseId(long nurseId) {
        this.nurseId = nurseId;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public String getObservations() {
        return observations;
    }
    
    public void setObservations(String observations) {
        this.observations = observations;
    }
    
    public VitalSignsRequest getVitalSigns() {
        return vitalSigns;
    }
    
    public void setVitalSigns(VitalSignsRequest vitalSigns) {
        this.vitalSigns = vitalSigns;
    }
    
    public String getMedicationsAdministered() {
        return medicationsAdministered;
    }
    
    public void setMedicationsAdministered(String medicationsAdministered) {
        this.medicationsAdministered = medicationsAdministered;
    }
    
    public String getProceduresPerformed() {
        return proceduresPerformed;
    }
    
    public void setProceduresPerformed(String proceduresPerformed) {
        this.proceduresPerformed = proceduresPerformed;
    }
    
    /**
     * DTO anidado para signos vitales
     */
    public static class VitalSignsRequest {
        @JsonProperty("bloodPressure")
        private String bloodPressure;
        
        @JsonProperty("heartRate")
        private int heartRate;
        
        @JsonProperty("temperature")
        private double temperature;
        
        @JsonProperty("respiratoryRate")
        private int respiratoryRate;
        
        @JsonProperty("oxygenSaturation")
        private double oxygenSaturation;
        
        // Getters y setters
        public String getBloodPressure() {
            return bloodPressure;
        }
        
        public void setBloodPressure(String bloodPressure) {
            this.bloodPressure = bloodPressure;
        }
        
        public int getHeartRate() {
            return heartRate;
        }
        
        public void setHeartRate(int heartRate) {
            this.heartRate = heartRate;
        }
        
        public double getTemperature() {
            return temperature;
        }
        
        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }
        
        public int getRespiratoryRate() {
            return respiratoryRate;
        }
        
        public void setRespiratoryRate(int respiratoryRate) {
            this.respiratoryRate = respiratoryRate;
        }
        
        public double getOxygenSaturation() {
            return oxygenSaturation;
        }
        
        public void setOxygenSaturation(double oxygenSaturation) {
            this.oxygenSaturation = oxygenSaturation;
        }
    }
}
