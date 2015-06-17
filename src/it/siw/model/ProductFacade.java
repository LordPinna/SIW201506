package it.siw.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProductFacade {

	private EntityManagerFactory emf;
	private EntityManager em;

	public ProductFacade(){
		this.emf = Persistence.createEntityManagerFactory("siw-unit");
		this.em = emf.createEntityManager();
	}

	public Product getProductById(Long id){
		Product product = em.find(Product.class, id);
		em.close();
		emf.close();
		return product;
	}

	public void addProduct(Product product){
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(product);
		tx.commit();
		em.close();
		emf.close();
	}

	public List<Product> listProducts(){
		Query q = em.createQuery("SELECT p FROM Product p ORDER BY p.code");
		List<Product> products = q.getResultList();
		em.close();
		emf.close();
		return products;
	}

}
