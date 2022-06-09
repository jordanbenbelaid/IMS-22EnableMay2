package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Items {
//Attributes
	private Long id;
	private String itemsName;
	private int price;
//Default Constructor
	public Items(String itemsName, int price) {
		this.setItemsName(itemsName);
		this.setPrice(price);
	}

	public Items(Long id, String itemsName, int price) {
		this.setId(id);
		this.setItemsName(itemsName);
		this.setPrice(price);
	}
	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemsName() {
		return itemsName;
	}

	public void setItemsName(String itemsName) {
		this.itemsName = itemsName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "id:" + id + " items name:" + itemsName + " price:" + price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemsName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemsName, other.itemsName) && price == other.price;
	}

	
	
	

}