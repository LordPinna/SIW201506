package it.siw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String vat;

	private String email;

	private String phoneNumber;

	@OneToOne
	private Address address;

	@ManyToMany
	private List<Product> products;

	public Provider() {
	}

	public Provider(String name, String vat, Address address) {
		this.name = name;
		this.vat = vat;
		this.address = address;
	}

	//Getters & Setters        

	public Long getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVAT() {
		return this.vat;
	}

	public void setVAT(String vat) {
		this.vat = vat;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Product> getProduct(){
		return this.products;
	}

	public void addProduct(Product product){
		this.products.add(product);
	}

	public boolean equals(Object obj) {
		Provider provider = (Provider)obj;
		return this.getName().equals(provider.getName());
	}

	public int hashCode() {
		return this.name.hashCode();
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Provider"); 
		sb.append("{id=").append(id); 
		sb.append(", name='").append(name); 
		sb.append(", vat=").append(vat); 
		sb.append(", email='").append(email); 
		sb.append(", phone number='").append(phoneNumber);
		sb.append(this.getAddress().toString());
		sb.append("}\n");
		return sb.toString();
	}


}
