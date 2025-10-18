package app.domain.services;


import app.domain.entities.DiagnosticAid;
import app.domain.ports.DiagnosticAidPort;


public class CreateDiagnosticAid {
	
	private DiagnosticAidPort diagnosticAidPort;
	
	public void createDiagnosticAid(DiagnosticAid  diagnosticAid)throws Exception{
		
		if(diagnosticAidPort.findByOrderNumber(diagnosticAid)!=null) {
			throw new Exception("No pueden haber dos facturas con el mismo nuemero de orden");
		}
		diagnosticAidPort.save(diagnosticAid);
		
	}
	
	
}
	
	
	
	