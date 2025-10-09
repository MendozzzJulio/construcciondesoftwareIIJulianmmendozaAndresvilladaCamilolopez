package app.domain.entities;

import java.sql.Date;

/**
 * Clase que representa la facturación.
 * debe de mostrar:
 * -----------------------------------
 * nombre del paciente //
 * edad 
 * cedula //
 * ---------------------------
 * nombre del medico tratante.
 * nombre de la compañia de seguro.
 * numero de la poliza.
 * dias de vigencia de la poliza.
 * fecha de finalizacion de la poliza.
 * -----------------------------------
 */

public class Billing {
	
	private Long patientDocument;
	private Patient patientName;
	private Date policyValidity;
	private Date policyEndDate;
	

}
