package app.domain.ports;

import app.domain.entities.Visit;

public interface VisitPort {
	
	public void save(Visit visit) throws Exception;

}
