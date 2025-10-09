package app.domain.entities;


/** lo hace camilinPimguin 
 * Clase que representa la facturación.
 * debe de mostrar:
 * -----------------------------------
 * nombre del paciente //
 * edad //
 * cedula //
 * ---------------------------
 * nombre del medico tratante. //
 * nombre de la compañia de seguro. //
 * numero de la poliza.//
 * dias de vigencia de la poliza. //
 * fecha de finalizacion de la poliza. //
 * -----------------------------------
 */

public class Billing {
	
	private User user; // accedo al nombre del medico tratante
	private Patient patient; // accedo al nombre del paciente, edad y cedula
	private MedicalInsurance medicalInsurance; // accedo a los datos del seguro medico
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public MedicalInsurance getMedicalInsurance() {
		return medicalInsurance;
	}
	public void setMedicalInsurance(MedicalInsurance medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}


}
