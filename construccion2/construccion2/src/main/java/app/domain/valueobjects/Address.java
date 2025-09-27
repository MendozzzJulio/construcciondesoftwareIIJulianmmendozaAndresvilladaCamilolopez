package app.domain.valueobjects;

public class Address {
	
	private final String value;
	
	public Address(String value) {
		
		if(!isValid(value)) {
			throw new IllegalArgumentException("Dirección no válida");
		}
		
		
     }
}


