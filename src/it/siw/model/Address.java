package it.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String street;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String zipcode;

	@Column(nullable = false)
	private String country;

	public Address(){
	}
	
	public Address(String street, String city, String zipcode, String country){
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
	}
	
	public Long getId(){
		return this.id;
	}

	public String getStreet(){
		return this.street;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getCity(){
		return this.city;
	}

	public void setCity(String city){
		this.city = city;
	}
	public String getZipcode(){
		return this.zipcode;
	}

	public void setZipcode(String zipcode){
		this.zipcode = zipcode;
	}

	public String getCountry(){
		return this.country;
	}

	public void setCountry(String country){
		this.country = country;
	}
	
	public boolean equals(Object obj) {
		Address address = (Address)obj;
		return this.street.equals(address.getStreet()) && this.city.equals(address.getCity());
	}

	public int hashCode() {
		return this.street.hashCode() + this.city.hashCode();
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Address"); 
		sb.append("{id=").append(id); 
		sb.append(", street='").append(street); 
		sb.append(", city=").append(city); 
		sb.append(", zipcode='").append(zipcode); 
		sb.append(", country='").append(country);
		sb.append("}\n");
		return sb.toString();
	}

}
