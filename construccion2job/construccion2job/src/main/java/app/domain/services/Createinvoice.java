package app.domain.services;

import app.domain.model.Invoice;
import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.ports.InvoicePort;
import app.domain.ports.MedicalOrderPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class Createinvoice {
	
	private PatientPort patientPort;
	private UserPort userPort;
	private MedicalOrderPort medicalOrderPort;
	private InvoicePort invoicePort;
	
	
	public void createInvoice(Invoice invoice) throws Exception {
        Patient patient = patientPort.findById(invoice.getPatient());
        User doctor = userPort.findById(invoice.getDoctor());
		if (patient == null) {

			throw new Exception("La factura debe de estar asociada a un paciente");
			}
		
		
		if(doctor == null) {
            throw new Exception("La factura debe de estar asociada a un doctor");
		
		}
		if (invoice.isMedicine()) { 
			MedicalOrder medicalOrder = medicalOrderPort.findById(invoice.getOrderNumber());
			if (medicalOrder == null || patient.getId() != medicalOrder.getPatientIdCard().getPatientIdCard()) {
				throw new Exception("La venta de un medicamento requiere de una orden medica asociada");
			}
			invoice.setOrderNumber(medicalOrder);
		}
		invoice.setPatient(patient);
		invoicePort.save(invoice);
           
		}

}

