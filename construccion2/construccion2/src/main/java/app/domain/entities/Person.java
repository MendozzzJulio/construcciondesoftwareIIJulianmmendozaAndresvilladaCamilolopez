package app.domain.entities;

import java.time.LocalDate;

import app.domain.entities.valueobjects.Address;
import app.domain.entities.valueobjects.Email;
import app.domain.entities.valueobjects.PhoneNumber;

public abstract class Person {
	
	private long id;
	private long document; // Cedula de ciudadania
	private String name;
	private String lastName; 
	private Email email;
	private Address address;
	private PhoneNumber phoneNumber;
	private LocalDate dateOfBirth;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getDocument() {
		return document;
	}
	public void setDocument(long document) {
		this.document = document;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	
	
}
