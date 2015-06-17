package it.siw.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

//@Stateless(name="cFacade")
public class CustomerFacade {

	//@PersistenceContext(unitName = "siw-unit")
	//private EntityManager em;

	private EntityManagerFactory emf;
	private EntityManager em;

	public CustomerFacade(){
		this.emf = Persistence.createEntityManagerFactory("siw-unit");
		this.em = emf.createEntityManager();
	}

	public void addCustomer(Customer customer, Address address){
		customer.setAddress(address);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(customer);
		em.persist(address);
		tx.commit();
		em.close();
		emf.close();
		return;
	}

	public Customer getCustomerById(Long id){
		Customer customer = em.find(Customer.class, id);
		em.close();
		emf.close();
		return customer;
	}

	public Customer getCustomer(String email, String password){
		Query q = em.createQuery("SELECT c FROM Customer c WHERE c.email=:email AND c.password=:password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		Customer customer;
		try{
			customer = (Customer) q.getSingleResult();
		} catch (Exception NoResult){
			customer = null;
		}
		em.close();
		emf.close();
		return customer;
	}

	public List<Customer> getCustomers(){
		Query q = em.createQuery("SELECT c FROM Customer c");
		List<Customer> customers = q.getResultList();
		em.close();
		emf.close();
		return customers;
	}
}
