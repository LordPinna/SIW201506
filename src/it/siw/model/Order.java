package it.siw.model;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "orders")
public class Order {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	

	@Temporal (TemporalType.TIMESTAMP)
	private GregorianCalendar creationTime;

	@Temporal (TemporalType.TIMESTAMP)
	private GregorianCalendar closedTime;

	@Temporal (TemporalType.DATE)
	private GregorianCalendar deliveryDate;

	@ManyToOne
	private Customer customer;

	@OneToMany
	@JoinColumn(name = "orders_id")
	private List<OrderLine> orderLines;

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public String getCreationTime(){
		return this.creationTime.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(this.creationTime.get(GregorianCalendar.MONTH)+1)+
				"/"+this.creationTime.get(GregorianCalendar.YEAR)+" "+this.creationTime.get(GregorianCalendar.HOUR_OF_DAY)+
				":"+this.creationTime.get(GregorianCalendar.MINUTE);
	}

	public void setCreationTime(GregorianCalendar creationTime){
		this.creationTime = creationTime;
	}

	public String getClosedTime(){
		if(this.closedTime!=null){
			return this.closedTime.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(this.closedTime.get(GregorianCalendar.MONTH)+1)+
					"/"+this.closedTime.get(GregorianCalendar.YEAR)+" "+this.closedTime.get(GregorianCalendar.HOUR_OF_DAY)+
					":"+this.closedTime.get(GregorianCalendar.MINUTE);
		}
		return null;
	}

	public void setClosedTime(GregorianCalendar closedTime){
		this.closedTime = closedTime;
	}

	public String getDeliveryDate(){
		if(this.deliveryDate!=null){
			return this.deliveryDate.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(this.deliveryDate.get(GregorianCalendar.MONTH)+1)+
					"/"+this.deliveryDate.get(GregorianCalendar.YEAR);
		}
		return null;
	}

	public void setDeliveryDate(GregorianCalendar deliveryDate){
		this.deliveryDate = deliveryDate;
	}

	public Customer getCustomer(){
		return this.customer;
	}

	public void setCustomer(Customer customer){
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines(){
		return this.orderLines;
	}

	public OrderLine getOrderLine(String item){
		for (OrderLine o : this.orderLines)
			if (o.getItem().equals(item))
				return o;
		return null;
	}

	public void addOrderLine(OrderLine orderLine){
		this.orderLines.add(orderLine);
	}

	public void removeOrderLine(Long orderLineId){
		for (OrderLine o : this.orderLines){
			if (o.getId().equals(orderLineId))
				this.orderLines.remove(o);
		}
	}
}
