package app.adapter.in.validators;

public abstract class SimpleValidator {
	
	
	public String stringValidator(String element, String value) throws Exception {
		if (value == null || value.equals("")) {
			throw new Exception("El campo " + element + " no puede estar vacio.");
		}
		return value;
	}
	
	public String integerValidator(String element, String value) throws Exception {
		stringValidator(element, value);
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new Exception("El campo " + element + " debe ser un numero entero.");
		}
	}

}
