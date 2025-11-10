package app.infrastructure.adapter.api.rest.mapper;

import org.springframework.stereotype.Component;

import app.domain.entities.Billing;
import app.domain.entities.MedicalInsurance;
import app.domain.entities.MedicalOrder;
import app.domain.entities.MedicalOrderType;
import app.domain.entities.Patient;
import app.domain.entities.User;
import app.infrastructure.adapter.api.rest.dto.request.CreateBillingRequest;
import app.infrastructure.adapter.api.rest.dto.response.BillingResponse;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapper para convertir entre entidades Billing y DTOs
 */
@Component
public class BillingMapper {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    /**
     * Convierte CreateBillingRequest a entidad Billing
     */
    public Billing toEntity(CreateBillingRequest request) {
        if (request == null) {
            return null;
        }
        
        Billing billing = new Billing();
        
        // Crear paciente con documento
        Patient patient = new Patient();
        patient.setDocument(request.getPatientDocument());
        billing.setPatient(patient);
        
        // Crear usuario/doctor
        User doctor = new User();
        doctor.setId(request.getDoctorId());
        billing.setUser(doctor);
        
        // Seguro médico
        if (request.getMedicalInsurance() != null) {
            MedicalInsurance insurance = new MedicalInsurance();
            insurance.setCompanyName(request.getMedicalInsurance().getCompanyName());
            insurance.setPolicyNumber(request.getMedicalInsurance().getPolicyNumber());
            insurance.setPolicyStatus(request.getMedicalInsurance().isPolicyStatus());
            
            if (request.getMedicalInsurance().getPolicyEndDate() != null) {
                insurance.setPolicyEndDate(Date.valueOf(request.getMedicalInsurance().getPolicyEndDate()));
            }
            
            billing.setMedicalInsurance(insurance);
        }
        
        // Copago acumulado del año
        billing.setYearlyCopayCumulative(request.getYearlyCopayCumulative());
        
        return billing;
    }
    
    /**
     * Convierte entidad Billing a BillingResponse
     */
    public BillingResponse toResponse(Billing billing) {
        if (billing == null) {
            return null;
        }
        
        BillingResponse response = new BillingResponse();
        
        // Fecha de facturación
        if (billing.getBillingDate() != null) {
            response.setBillingDate(billing.getBillingDate().format(DATE_FORMATTER));
        }
        
        // Información del paciente
        if (billing.getPatient() != null) {
            BillingResponse.PatientInfo patientInfo = new BillingResponse.PatientInfo();
            patientInfo.setName(billing.getPatient().getName());
            patientInfo.setLastName(billing.getPatient().getLastName());
            patientInfo.setDocument(billing.getPatient().getDocument());
            patientInfo.setAge(billing.getPatient().getAge());
            response.setPatient(patientInfo);
        }
        
        // Información del doctor
        if (billing.getUser() != null) {
            BillingResponse.DoctorInfo doctorInfo = new BillingResponse.DoctorInfo();
            doctorInfo.setName(billing.getUser().getName());
            doctorInfo.setLastName(billing.getUser().getLastName());
            response.setDoctor(doctorInfo);
        }
        
        // Información del seguro médico
        if (billing.getMedicalInsurance() != null) {
            BillingResponse.MedicalInsuranceInfo insuranceInfo = new BillingResponse.MedicalInsuranceInfo();
            insuranceInfo.setCompanyName(billing.getMedicalInsurance().getCompanyName());
            insuranceInfo.setPolicyNumber(billing.getMedicalInsurance().getPolicyNumber());
            insuranceInfo.setPolicyStatus(billing.getMedicalInsurance().isPolicyStatus());
            
            if (billing.getMedicalInsurance().getPolicyEndDate() != null) {
                insuranceInfo.setPolicyEndDate(billing.getMedicalInsurance().getPolicyEndDate().toString());
            }
            
            response.setMedicalInsurance(insuranceInfo);
        }
        
        // Órdenes médicas
        if (billing.getMedicalOrders() != null) {
            List<BillingResponse.MedicalOrderInfo> orderInfos = new ArrayList<>();
            
            for (MedicalOrder order : billing.getMedicalOrders()) {
                BillingResponse.MedicalOrderInfo orderInfo = new BillingResponse.MedicalOrderInfo();
                orderInfo.setId(order.getId());
                
                if (order.getDate() != null) {
                    orderInfo.setDate(order.getDate().toString());
                }
                
                // Items de la orden médica
                if (order.getItems() != null) {
                    List<BillingResponse.MedicalOrderItemInfo> itemInfos = new ArrayList<>();
                    
                    for (MedicalOrderType item : order.getItems()) {
                        BillingResponse.MedicalOrderItemInfo itemInfo = new BillingResponse.MedicalOrderItemInfo();
                        itemInfo.setType(item.getItem().toString());
                        itemInfo.setDescription(item.getDescription());
                        itemInfo.setQuantity(item.getItemNumber());
                        // El costo se calculará en el servicio
                        itemInfos.add(itemInfo);
                    }
                    
                    orderInfo.setItems(itemInfos);
                }
                
                orderInfos.add(orderInfo);
            }
            
            response.setMedicalOrders(orderInfos);
        }
        
        // Montos financieros
        response.setTotalAmount(billing.getTotalAmount());
        response.setCopayAmount(billing.getCopayAmount());
        response.setInsuranceAmount(billing.getInsuranceAmount());
        response.setPatientAmount(billing.getPatientAmount());
        response.setHasActivePolicy(billing.isHasActivePolicy());
        response.setYearlyCopayCumulative(billing.getYearlyCopayCumulative());
        
        // Detalles de facturación
        response.setBillingDetails(billing.getBillingDetails());
        
        return response;
    }
}
