package it.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_line")
public class OrderLine {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String item;

	@Column(nullable = false)
	private int quantity;

	@Column(nullable = false)
	private Float unitPrice;

	public OrderLine() {
	}

	public OrderLine(String item, int quantity, Float unitPrice){
		this.item = item;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public Long getId() {
		return id;
	}

	public String getItem(){
		return this.item;
	}

	public void setItem(String item){
		this.item = item;
	}

	public int getQuantity(){
		return this.quantity;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public Float getUnitPrice(){
		return this.unitPrice;
	}

	public void setUnitPrice(Float unitPrice){
		this.unitPrice = unitPrice;
	}

}