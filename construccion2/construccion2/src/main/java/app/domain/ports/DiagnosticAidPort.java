package app.domain.ports;

import app.domain.entities.DiagnosticAid;

public interface DiagnosticAidPort {
	
	public DiagnosticAid findByOrderNumber(DiagnosticAid diagnosticAid) throws Exception;
	
	public void save(DiagnosticAid diagnosticAid) throws Exception;
	

}
