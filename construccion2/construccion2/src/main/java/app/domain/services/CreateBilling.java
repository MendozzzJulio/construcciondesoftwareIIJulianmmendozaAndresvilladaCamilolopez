package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Billing;
import app.domain.ports.BillingPort;


@Service
public class CreateBilling {
	
	@Autowired
	private BillingPort billingPort;
	
	public void createBilling(Billing billing) throws Exception {
		
		if (billingPort.findbyDocument(billing) == null) {
			throw new Exception("El paciente no existe");
		}
		
		

		billingPort.save(billing);

	}

}
