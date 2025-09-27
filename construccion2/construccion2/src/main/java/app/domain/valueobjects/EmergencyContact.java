package app.domain.valueobjects;

public class EmergencyContact {
	private final String value;

	public EmergencyContact(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
