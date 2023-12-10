package com.ls.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "person")
public class Person {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
	private UserType userType;

	public Person() {

	}

	public Person(String firstName, String lastName, String emailId, UserType userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userType = userType;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(id, person.id)
				&& Objects.equals(firstName, person.firstName)
				&& Objects.equals(lastName, person.lastName)
				&& Objects.equals(emailId, person.emailId)
				&& userType == person.userType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, emailId, userType);
	}
}
