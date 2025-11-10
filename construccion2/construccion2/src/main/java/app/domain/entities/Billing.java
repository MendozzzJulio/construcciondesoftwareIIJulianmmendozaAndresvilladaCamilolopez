package app.domain.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

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
	
	// Campos adicionales para la facturación completa
	private Date date;
	private List<MedicalOrder> medicalOrders; // órdenes médicas del paciente
	private BigDecimal totalAmount; // monto total de los servicios
	private BigDecimal copayAmount; // monto del copago
	private BigDecimal insuranceAmount; // monto a cargo de la aseguradora
	private BigDecimal patientAmount; // monto a cargo del paciente
	private String billingDetails; // detalles de la facturación
	private BigDecimal yearlyCopayCumulative; // copago acumulado en el año
	
	
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
	
	public Date getBillingDate() {
		return date;
	}
	public void seDate(Date date) {
		this.date = date;
	}
	public List<MedicalOrder> getMedicalOrders() {
		return medicalOrders;
	}
	public void setMedicalOrders(List<MedicalOrder> medicalOrders) {
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
	public String getBillingDetails() {
		return billingDetails;
	}
	public void setBillingDetails(String billingDetails) {
		this.billingDetails = billingDetails;
	}
	public BigDecimal getYearlyCopayCumulative() {
		return yearlyCopayCumulative;
	}
	public void setYearlyCopayCumulative(BigDecimal yearlyCopayCumulative) {
		this.yearlyCopayCumulative = yearlyCopayCumulative;
	}

}
