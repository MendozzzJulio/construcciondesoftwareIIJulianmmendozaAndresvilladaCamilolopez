package app.domain.entities.valueobjects;

public class Address {

	private final String value;

	public Address(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
