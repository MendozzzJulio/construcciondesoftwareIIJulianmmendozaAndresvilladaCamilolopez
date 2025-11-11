package app.domain.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Billing;
import app.domain.entities.MedicalOrder;
import app.domain.entities.MedicalOrderType;
import app.domain.entities.User;
import app.domain.entities.enums.MedicalItemType;
import app.domain.entities.enums.Role;
import app.domain.ports.BillingPort;
import app.domain.ports.MedicalOrderPort;


@Service
public class CreateBilling {
	
	@Autowired
	private BillingPort billingPort;
	
	@Autowired
	private MedicalOrderPort medicalOrderPort;
	@Autowired 
	private AuthenticationService authenticationService;
	
	public void create(Billing billing) throws Exception {
		
		// Validar que solo usuarios con rol ADMINISTRATIVE pueden crear facturas
		authenticationService.validateUserRoles(Role.ADMINISTRATIVE);
		
		// Validar que el paciente existe
		if (billing.getPatient() == null) {
			throw new Exception("El paciente es requerido para crear la factura");
		}

		// Establecer fecha de facturación

		
		// Obtener órdenes médicas del paciente
		List<MedicalOrder> patientOrders = medicalOrderPort.findByPatient(billing.getPatient());
		
		// Calcular costos y generar detalles de facturación
		calculateBillingAmounts(billing);
		generateBillingDetails(billing);
		
		// Guardar la factura
		billingPort.save(billing);
	}
	
	/**
	 * Calcula los montos de la facturación basado en las reglas de copago y póliza
	 */
	private void calculateBillingAmounts(Billing billing) {
		BigDecimal totalServiceCost = calculateTotalServiceCost(billing.getMedicalOrders());
		billing.setTotalAmount(totalServiceCost);
		
		// Verificar si tiene póliza activa
		boolean hasActivePolicy = billing.getMedicalInsurance() != null && 
								  billing.getMedicalInsurance().isPolicyStatus();
		if (!hasActivePolicy) {
			// Sin póliza activa: paciente paga todo
			billing.setPatientAmount(totalServiceCost);
			billing.setInsuranceAmount(BigDecimal.ZERO);
			billing.setCopayAmount(BigDecimal.ZERO);
		} else {
			// Con póliza activa: aplicar reglas de copago
			BigDecimal copayLimit = new BigDecimal("1000000"); // 1 millón de pesos
			BigDecimal standardCopay = new BigDecimal("50000"); // 50,000 pesos
			
			// Obtener copago acumulado del año (esto debería venir de la base de datos)
			BigDecimal yearlyAccumulated = billing.getYearlyCopayCumulative() != null ? 
									   billing.getYearlyCopayCumulative() : BigDecimal.ZERO;
			
			if (yearlyAccumulated.compareTo(copayLimit) >= 0) {
				// Ya superó el límite anual: aseguradora paga todo
				billing.setPatientAmount(BigDecimal.ZERO);
				billing.setInsuranceAmount(totalServiceCost);
				billing.setCopayAmount(BigDecimal.ZERO);
			} else {
				// Aplicar copago estándar
				BigDecimal remainingCopayCapacity = copayLimit.subtract(yearlyAccumulated);
				BigDecimal actualCopay = standardCopay.min(remainingCopayCapacity).min(totalServiceCost);
				
				billing.setCopayAmount(actualCopay);
				billing.setPatientAmount(actualCopay);
				billing.setInsuranceAmount(totalServiceCost.subtract(actualCopay));
				
				// Actualizar copago acumulado
				billing.setYearlyCopayCumulative(yearlyAccumulated.add(actualCopay));
			}
		}
	}
	
	/**
	 * Calcula el costo total de los servicios basado en las órdenes médicas
	 */
	private BigDecimal calculateTotalServiceCost(List<MedicalOrder> orders) {
		BigDecimal total = BigDecimal.ZERO;
		
		if (orders != null) {
			for (MedicalOrder order : orders) {
				if (order.getItems() != null) {
					for (MedicalOrderType item : order.getItems()) {
						// Costos base por tipo de servicio (estos deberían venir de una tabla de precios)
						BigDecimal itemCost = getItemCost(item.getItem());
						total = total.add(itemCost.multiply(new BigDecimal(item.getItemNumber())));
					}
				}
			}
		}
		
		return total;
	}
	
	/**
	 * Obtiene el costo base por tipo de item médico
	 */
	private BigDecimal getItemCost(MedicalItemType itemType) {
		switch (itemType) {
			case MEDICATION:
				return new BigDecimal("25000"); // Costo base medicamento
			case PROCEDURE:
				return new BigDecimal("150000"); // Costo base procedimiento
			case DIAGNOSTIC_AID:
				return new BigDecimal("80000"); // Costo base ayuda diagnóstica
			case RECOMMENDATION:
				return new BigDecimal("0"); // Las recomendaciones no tienen costo
			default:
				return new BigDecimal("50000"); // Costo por defecto
		}
	}
	
	/**
	 * Genera los detalles de la facturación incluyendo información clínica
	 */
	private void generateBillingDetails(Billing billing) {
		StringBuilder details = new StringBuilder();
		
		// Información del paciente
		details.append("=== FACTURA MÉDICA ===\n");
		details.append("Fecha: ").append(billing.getBillingDate()).append("\n\n");
		
		details.append("INFORMACIÓN DEL PACIENTE:\n");
		details.append("Nombre: ").append(billing.getPatient().getName())
			   .append(" ").append(billing.getPatient().getLastName()).append("\n");
		details.append("Edad: ").append(billing.getPatient().getAge()).append(" años\n");
		details.append("Cédula: ").append(billing.getPatient().getDocument()).append("\n\n");
		
		// Información del médico
		if (billing.getUser() != null) {
			details.append("MÉDICO TRATANTE:\n");
			details.append("Dr(a). ").append(billing.getUser().getName())
				   .append(" ").append(billing.getUser().getLastName()).append("\n\n");
		}
		
		// Información del seguro
		if (billing.getMedicalInsurance() != null) {
			details.append("INFORMACIÓN DEL SEGURO:\n");
			details.append("Compañía: ").append(billing.getMedicalInsurance().getCompanyName()).append("\n");
			details.append("Número de Póliza: ").append(billing.getMedicalInsurance().getPolicyNumber()).append("\n");
			details.append("Estado: ").append(billing.getMedicalInsurance().isPolicyStatus() ? "ACTIVA" : "INACTIVA").append("\n");
			details.append("Fecha de Finalización: ").append(billing.getMedicalInsurance().getPolicyEndDate()).append("\n\n");
		}
		
		// Detalles de servicios médicos
		details.append("SERVICIOS PRESTADOS:\n");
		if (billing.getMedicalOrders() != null && !billing.getMedicalOrders().isEmpty()) {
			for (MedicalOrder order : billing.getMedicalOrders()) {
				details.append("Orden #").append(order.getId()).append(" - Fecha: ").append(order.getDate()).append("\n");
				
				if (order.getItems() != null) {
					for (MedicalOrderType item : order.getItems()) {
						switch (item.getItem()) {
							case MEDICATION:
								details.append("  • MEDICAMENTO: ").append(item.getDescription())
									   .append(" - Cantidad: ").append(item.getItemNumber())
									   .append(" - Costo: $").append(getItemCost(item.getItem()).multiply(new BigDecimal(item.getItemNumber()))).append("\n");
								break;
							case PROCEDURE:
								details.append("  • PROCEDIMIENTO: ").append(item.getDescription())
									   .append(" - Costo: $").append(getItemCost(item.getItem()).multiply(new BigDecimal(item.getItemNumber()))).append("\n");
								break;
							case DIAGNOSTIC_AID:
								details.append("  • AYUDA DIAGNÓSTICA: ").append(item.getDescription())
									   .append(" - Costo: $").append(getItemCost(item.getItem()).multiply(new BigDecimal(item.getItemNumber()))).append("\n");
								break;
							case RECOMMENDATION:
								details.append("  • RECOMENDACIÓN: ").append(item.getDescription()).append("\n");
								break;
						}
					}
				}
			}
		} else {
			details.append("No se encontraron órdenes médicas para este paciente.\n");
		}
		
		// Resumen financiero
		details.append("\n=== RESUMEN FINANCIERO ===\n");
		details.append("Costo Total de Servicios: $").append(billing.getTotalAmount()).append("\n");
		
		if (billing.getMedicalInsurance() != null && billing.getMedicalInsurance().isPolicyStatus()) {
			details.append("Copago del Paciente: $").append(billing.getPatientAmount()).append("\n");
			details.append("A cargo de la Aseguradora: $").append(billing.getInsuranceAmount()).append("\n");
			if (billing.getYearlyCopayCumulative() != null) {
				details.append("Copago Acumulado en el Año: $").append(billing.getYearlyCopayCumulative()).append("\n");
			}
		} else {
			details.append("Póliza: INACTIVA o NO POSEE\n");
			details.append("Total a Pagar por el Paciente: $").append(billing.getPatientAmount()).append("\n");
		}
		
		billing.setBillingDetails(details.toString());
	}

}
