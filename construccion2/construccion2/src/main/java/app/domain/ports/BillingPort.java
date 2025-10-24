	package app.domain.ports;

import app.domain.entities.Billing;

public interface BillingPort {
	
	public Billing findbyDocument(Billing billing) throws Exception;
	
	public void save(Billing billing) throws Exception;


}
