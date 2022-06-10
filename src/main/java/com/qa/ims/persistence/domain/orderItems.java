package com.qa.ims.persistence.domain;

import java.util.Objects;

public class orderItems {
	private static Long id;
	private static int itemQuantity;
	private int orderCost;
	

	public orderItems(int itemQuantity, int orderCost) {
		this.setItemQuantity(itemQuantity);
		this.setOrderCost(orderCost);
	}

	private void setItemQuantity(int itemQuantity2) {
		// TODO Auto-generated method stub
		
	}

	private void setOrderCost(int orderCost2) {
		// TODO Auto-generated method stub
		
	}

	public orderItems(Long id, int itemQuantity, int orderCost) {
		this.setId(id);
		this.setItemQuantity(itemQuantity);
		this.setOrderCost(orderCost);
	}

	public static Long getId() {
		return id;
	}

	public void setId(Long id) {
		orderItems.id = id;
	}

	public static int getItemQuantity() {
		return itemQuantity;
	}

	public void setitemQuantity(int itemQuantity) {
		orderItems.itemQuantity = itemQuantity;
	}

	public int getorderCost() {
		return orderCost;
	}

	public void setorderCost(int orderCost) {
		this.orderCost = orderCost;
	}

	@Override
	public String toString() {
		return "id:" + id + " item quantity:" + itemQuantity + " order Cost:" + orderCost;
	}

	


	@Override
	public int hashCode() {
		return Objects.hash(orderCost);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		orderItems other = (orderItems) obj;
		return orderCost == other.orderCost;
	}

	public static int getOrderCost() {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
