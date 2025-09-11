package app.domain.services;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.ports.InvoicePort;
import app.domain.ports.MedicalOrderPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class Createinvoice {
	
	private PatientPort patientPort;
	private UserPort userport;
	private MedicalOrderPort medicalOrderPort;
	private InvoicePort invoicePort;
	
	
	public void createInvoice(Invoice invoice) throws Exception {
        Patient patient = patientPort.findById(invoice.getPatient());
		if (patient == null) {
			throw new Exception("La factura debe de estar asociada a un paciente");
		}
		if (invoice.isMedicine()) { 
			MedicalOrder medicalOrder = medicalOrderPort.findById(invoice.getorderNumber());
        
		}
           
	}

}
