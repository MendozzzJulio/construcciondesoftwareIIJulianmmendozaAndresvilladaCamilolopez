package app.adapter.in.validators;

import java.sql.Date;

public class MedicalInsuranceValidator  extends SimpleValidator {
	
	public long policyNumberValidator(String value) throws Exception {
		return longValidator("Numero de poliza del paciente", value);
	}

	public String companyNameValidator(String value) throws Exception {
		return stringValidator("Nombre de la compañia de seguros", value);
	}

	public Date policyValidityValidator(String value) throws Exception {
		stringValidator("Vigencia de la poliza", value);
		return Date.valueOf(value);
	}
	

	public Date policyEndDateValidator(String value) throws Exception {
		stringValidator("Fecha de finalizacion de la poliza", value);
		return Date.valueOf(value);
	}
	

}
