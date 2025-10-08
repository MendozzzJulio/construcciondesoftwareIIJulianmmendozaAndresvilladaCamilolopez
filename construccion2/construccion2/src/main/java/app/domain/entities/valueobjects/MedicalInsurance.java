package app.domain.entities.valueobjects;

public class MedicalInsurance {
	private final String value;

	public MedicalInsurance(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
