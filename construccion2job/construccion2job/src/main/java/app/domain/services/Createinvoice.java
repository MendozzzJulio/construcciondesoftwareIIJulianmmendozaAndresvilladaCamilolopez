package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.Invoice;
import app.domain.model.MedicalOrder;
import app.domain.model.PatientPort;
import app.domain.model.InvoicePort;
import app.domain.model.MedicalOrderPort;

public class Createinvoice {
    private PatientPort patientPort;
    private InvoicePort invoicePort;
    private MedicalOrderPort medicalOrderPort;

    public Createinvoice(PatientPort patientPort, InvoicePort invoicePort, MedicalOrderPort medicalOrderPort) {
        this.patientPort = patientPort;
        this.invoicePort = invoicePort;
        this.medicalOrderPort = medicalOrderPort;
    }

    public Invoice createInvoice(String tinNumber, String patientId, String medicalOrderId) {
        Patient patient = patientPort.getPatientById(patientId);
        if (patient == null) {
            throw new IllegalArgumentException("Patient not found");
        }

        MedicalOrder medicalOrder = medicalOrderPort.getMedicalOrderById(medicalOrderId);
        if (medicalOrder == null) {
            throw new IllegalArgumentException("Medical Order not found");
        }

        Invoice invoice = new Invoice(tinNumber, patient, medicalOrder);
        invoicePort.saveInvoice(invoice);
        return invoice;
    }
}
