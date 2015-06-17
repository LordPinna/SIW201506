package it.siw.model;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"firstname","lastname"}))
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(unique=true)
	private String email;

	@Column(nullable=false)
	private String password;

	@Temporal (TemporalType.DATE)
	private GregorianCalendar dateOfBirth;

	@OneToOne
	private Address address;

	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	public Customer(){
	}

	public Customer(String firstName, String lastName, String email, String password){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName(){
		return this.firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getLastName(){
		return this.lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getDateOfBirth(){
		if(this.dateOfBirth!=null){
			return this.dateOfBirth.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(this.dateOfBirth.get(GregorianCalendar.MONTH)+1)+
					"/"+this.dateOfBirth.get(GregorianCalendar.YEAR);
		}
		return null;
	}

	public void setDateOfBirth(GregorianCalendar dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress(){
		return this.address;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public List<Order> getOrders(){
		return this.orders;
	}

	public void addOrder(Order order){
		this.orders.add(order);
	}






}
