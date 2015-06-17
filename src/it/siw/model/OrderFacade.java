package it.siw.model;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class OrderFacade {

	private EntityManagerFactory emf;
	private EntityManager em;

	public OrderFacade(){
		this.emf = Persistence.createEntityManagerFactory("siw-unit");
		this.em = emf.createEntityManager();
	}

	public Order createOrder(Customer customer){
		Order order = new Order();
		order.setCreationTime(new GregorianCalendar());
		order.setCustomer(customer);
		EntityTransaction tx = em.getTransaction();
		tx.begin();			
		em.persist(order);
		tx.commit();
		em.close();
		emf.close();
		return order;
	}

	public void closeOrder(Long orderId){
		Query q = em.createQuery("UPDATE Order o SET o.closedTime =:closedTime WHERE o.id=:orderId");
		q.setParameter("closedTime", new GregorianCalendar());
		q.setParameter("orderId", orderId);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		q.executeUpdate();
		tx.commit();
		em.close();
		emf.close();
		return;
	}

	public Order getOrder(Long orderId){
		Order order = em.find(Order.class, orderId);
		em.close();
		emf.close();
		return order;
	}

	public void removeOrder(Long orderId){
		Order order = em.find(Order.class, orderId);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(order);
		tx.commit();
		em.close();
		emf.close();
		return;
	}

	public List<Order> getOrders() {
		Query q = em.createQuery("SELECT o FROM Order o WHERE o.closedTime is not null");
		List<Order> orders = q.getResultList();
		em.close();
		emf.close();
		return orders;
	}

	public List<Order> getOrdersByCustomerId(Long customerId){
		Query q = em.createQuery("SELECT o FROM Order o");
		List<Order> orders = q.getResultList();
		em.close();
		emf.close();
		List<Order> customerOrders = new LinkedList<Order>();
		for(Order o : orders)
			if(o.getCustomer().getId().equals(customerId))
				customerOrders.add(o);
		return customerOrders;
	}

	public OrderLine createOrderLine(String item, int quantity, Float unitPrice, Long orderId){
		OrderLine orderLine = new OrderLine(item, quantity, unitPrice);
		Order order = em.find(Order.class, orderId);
		order.addOrderLine(orderLine);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(orderLine);
		tx.commit();
		em.close();
		emf.close();
		return orderLine;
	}

	public void updateOrderLine(Long id, int quantity){
		Query q = em.createQuery("UPDATE OrderLine o SET o.quantity =:quantity WHERE o.id=:id");
		q.setParameter("quantity", quantity);
		q.setParameter("id", id);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		q.executeUpdate();		
		tx.commit();
		em.close();
		emf.close();
		return;
	}

	public List<OrderLine> getOrderLines(Long orderId){
		Order order = em.find(Order.class, orderId);
		List<OrderLine> orderLines= (List<OrderLine>) order.getOrderLines();
		return orderLines;
	}

	public void removeOrderLine(Long orderLineId){
		OrderLine orderLine = em.find(OrderLine.class, orderLineId);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(orderLine);
		tx.commit();
		em.close();
		emf.close();
		return;
	}
}