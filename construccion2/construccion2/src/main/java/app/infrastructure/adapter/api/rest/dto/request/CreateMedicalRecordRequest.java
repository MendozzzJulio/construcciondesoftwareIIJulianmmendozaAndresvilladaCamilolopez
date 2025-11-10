package app.infrastructure.adapter.api.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para la creación de registros médicos
 */
public class CreateMedicalRecordRequest {
    
    @JsonProperty("patientDocument")
    private long patientDocument;
    
    @JsonProperty("doctorId")
    private long doctorId;
    
    @JsonProperty("date")
    private String date; // Format: YYYY-MM-DD
    
    @JsonProperty("diagnosis")
    private String diagnosis;
    
    @JsonProperty("treatment")
    private String treatment;
    
    @JsonProperty("observations")
    private String observations;
    
    @JsonProperty("vitalSigns")
    private VitalSignsRequest vitalSigns;
    
    // Constructors
    public CreateMedicalRecordRequest() {}
    
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
    
    public String getDiagnosis() {
        return diagnosis;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public String getTreatment() {
        return treatment;
    }
    
    public void setTreatment(String treatment) {
        this.treatment = treatment;
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
        
        @JsonProperty("weight")
        private double weight;
        
        @JsonProperty("height")
        private double height;
        
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
    }
}
