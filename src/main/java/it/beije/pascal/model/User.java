package it.beije.pascal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "user")
//@JsonInclude(Include.NON_NULL)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email")	
	private String email;

	//@JsonIgnore
	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

//	@JsonProperty(value = "pass_word")
	@Column(name = "password")
	private String password;
	

	public User() {
		super();
	}
	
	public User(String email, String name, String surname, String password) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

//	@JsonGetter(value = "pass_word")
	public String getPassword() {
		return password;
	}
//	@JsonSetter(value = "date_time")
	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", surname=" + surname + ", password="
				+ password + "]";
	}
}
