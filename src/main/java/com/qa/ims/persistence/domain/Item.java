package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long itemsId;
	private String itemsName;
	private double price;

	public Item(String itemsName, double price) {
		this.setItemsName(itemsName);
		this.setPrice(price);
		
	}
	
	public Item(Long itemsId, String itemsName, double price) {
		this.setItemsId(itemsId);
		this.setItemsName(itemsName);
		this.setPrice(price);
	}

	public Long getItemsId() {
		return itemsId;
	}

	public void setItemsId(Long itemsId) {
		this.itemsId = itemsId;
	}

	public String getItemsName() {
		return itemsName;
	}

	public void setItemsName(String itemsName) {
		this.itemsName = itemsName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemsId=" + itemsId + ", itemsName=" + itemsName + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemsId, itemsName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(itemsId, other.itemsId) && Objects.equals(itemsName, other.itemsName)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

		
			
	}
