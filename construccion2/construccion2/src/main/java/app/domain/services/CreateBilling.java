package app.domain.services;

import app.domain.entities.Billing;
import app.domain.ports.BillingPort;

public class CreateBilling {
	
	private BillingPort billingPort;
	
	public void createBilling(Billing billing) throws Exception {
		
		if (billingPort.findbyDocument(billing) == null) {
			throw new Exception("El paciente no existe");
		}
		
		Billing existingBilling = billingPort.findbyDocument(billing);
	
		if (existingBilling != null) {
			throw new Exception("Ya existe una factura con este documento");
		}

		billingPort.save(billing);

	}

}
