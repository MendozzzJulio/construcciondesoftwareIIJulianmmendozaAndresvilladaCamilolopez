package app.domain.ports;

import app.domain.entities.Billing;
import app.domain.entities.Patient;

public interface BillingPort {
	
	public Billing findbyDocument(Billing billing) throws Exception;
	
	public void save(Billing billing) throws Exception;


}
