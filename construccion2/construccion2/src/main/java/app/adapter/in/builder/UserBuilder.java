package app.adapter.in.builder;

import app.adapter.in.validators.UserValidator;
import app.domain.entities.User;

public class UserBuilder {
	
	private UserValidator userValidator;

	public User build(String name, String lastName, String document, String email, String phoneNumber, String address, String dateOfBirth, String username, String password, String role) 
		throws Exception {
		User user = new User();
		user.setName(userValidator.nameValidator(name));
		user.setLastName(userValidator.lastNameValidator(lastName));
		user.setDocument(userValidator.documentValidator(document));
		user.setEmail(userValidator.emailValidator(email));
		user.setPhoneNumber(userValidator.phoneValidator(phoneNumber));
		user.setAddress(userValidator.addressValidator(address));
		user.setDateOfBirth(userValidator.dateOfBirthValidator(dateOfBirth));
		user.setUsername(username);
		user.setPassword(userValidator.passwordValidator(password));
		user.setRole(userValidator.roleValidator(role));
		
		return user;
	}
}
