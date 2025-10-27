package app.domain.entities;

// Entidad que va representar una visita médica, que puede incluir múltiples procedimientos médicos realizados durante la visita.

public class Visit {
	
	 private Patient patient;
	 private double bloodPressure;
	 private double temperature;
	 private int pulse;
	 private int oxygenLevel;
	 private Medicine medicine;
	 private Procedure procedure;
	 private DiagnosticAid diagnosticAid;
	 
	 
	
	 public double getBloodPressure() {
		 return bloodPressure;
	 }
	 public void setBloodPressure(double bloodPressure) {
		 this.bloodPressure = bloodPressure;
	 }
	 public double getTemperature() {
		 return temperature;
	 }
	 public void setTemperature(double temperature) {
		 this.temperature = temperature;
	 }
	 public int getPulse() {
		 return pulse;
	 }
	 public void setPulse(int pulse) {
		 this.pulse = pulse;
	 }
	 public int getOxygenLevel() {
		 return oxygenLevel;
	 }
	 public void setOxygenLevel(int oxygenLevel) {
		 this.oxygenLevel = oxygenLevel;
	 }
	 public Medicine getMedicine() {
		 return medicine;
	 }
	 public void setMedicine(Medicine medicine) {
		 this.medicine = medicine;
	 }
	 public Procedure getProcedure() {
		 return procedure;
	 }
	 public void setProcedure(Procedure procedure) {
		 this.procedure = procedure;
	 }
	 public DiagnosticAid getDiagnosticAid() {
		 return diagnosticAid;
	 }
	 public void setDiagnosticAid(DiagnosticAid diagnosticAid) {
		 this.diagnosticAid = diagnosticAid;
	 }
	 public Patient getPatient() {
		return patient;
	 }
	 public void setPatient(Patient patient) {
		this.patient = patient;
	 }
	
	 }
	 
	 

