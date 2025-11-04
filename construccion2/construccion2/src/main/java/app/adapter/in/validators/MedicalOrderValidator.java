package app.adapter.in.validators;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.MedicalOrderType;
import app.domain.entities.enums.MedicalItemType;

public class MedicalOrderValidator extends SimpleValidator {
	
	public Patient patientValidator(String patientId) throws Exception {
		long id = longValidator("id del paciente", patientId);
		Patient p = new Patient();
		p.setId(id);
		return p;
	}
	
	public User userValidator(String doctorId) throws Exception {
		long id = longValidator("id del doctor", doctorId);
		User u = new User();
		u.setId(id);
		return u;
	} 
	
	public Date dateValidator(String date) throws Exception {
		stringValidator("fecha de la orden (YYYY-MM-DD)", date);
		return Date.valueOf(date);
	}
	
	public List<MedicalOrderType> itemsValidator(String items) throws Exception {
		stringValidator("items de la orden", items);
		List<MedicalOrderType> list = new ArrayList<>();
		String[] tokens = items.split(";\\s*");
		int counter = 1;
		for (String token : tokens) {
			if (token == null || token.trim().isEmpty()) continue;
			String[] parts = token.split(":", 2);
			if (parts.length < 2) {
				throw new Exception("Formato de ítem inválido. Use TIPO:descripcion separado por ';'");
			}
			String typeStr = stringValidator("tipo de ítem", parts[0].trim());
			String desc = stringValidator("descripción de ítem", parts[1].trim());
			MedicalItemType type = MedicalItemType.valueOf(typeStr.toUpperCase());
			MedicalOrderType mot = new MedicalOrderType();
			mot.setItem(type);
			mot.setDescription(desc);
			mot.setItemNumber(counter++);
			list.add(mot);
		}
		return list;
	}

}
