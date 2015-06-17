package it.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;


	public Administrator() {
	}

	public Administrator(String username, String password) {
		this.username = username;
		this.password = password;
	}

	//Getters & Setters  

	public Long getId(){
		return this.id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equals(Object obj) {
		Administrator administrator = (Administrator)obj;
		return this.username.equals(administrator.getUsername());
	}

	public int hashCode() {
		return this.username.hashCode();
	}

}