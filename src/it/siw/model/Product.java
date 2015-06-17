package it.siw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String code;

	private String description;

	@Column(nullable = false)
	private Float price;

	@Column(nullable = false)
	private int stockQuantity;

	@ManyToMany(mappedBy = "products")
	private List<Provider> providers;

	public Product() {
	}

	public Product(String name, Float price, int stockQuantity , String code) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public boolean equals(Object obj) {
		Product product = (Product)obj;
		return this.getCode().equals(product.getCode());
	}

	public int hashCode() {
		return this.code.hashCode();
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Product"); 
		sb.append("{id=").append(id); 
		sb.append(", name='").append(name); 
		sb.append(", price=").append(price); 
		sb.append(", description='").append(description); 
		sb.append(", code='").append(code);
		sb.append(", quantity in stock='").append(stockQuantity);
		sb.append("}\n");
		return sb.toString();
	}
}