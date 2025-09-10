package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.Invoice;
import app.domain.model.MedicalOrder;
import app.domain.ports.PatientPort;
import app.domain.ports.InvoicePort;
import app.domain.ports.MedicalOrderPort;

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
        Patient patient = patientPort.findPatientById(patientId);
        if (patient == null) {
            throw new IllegalArgumentException("Patient not found");
        }

        MedicalOrder medicalOrder = medicalOrderPort.findMedicalOrderById(medicalOrder);
        if (medicalOrder == null) {
            throw new IllegalArgumentException("Medical Order not found");
        }

        Invoice invoice = new Invoice(String tinNumber, String patientId, String medicalOrderId);
        invoicePort.saveInvoice(invoice);
        return invoice;
    }
}
