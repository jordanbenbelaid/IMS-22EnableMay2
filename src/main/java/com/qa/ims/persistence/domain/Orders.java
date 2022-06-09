package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Orders {
	private Long id;
	private int OrderID;

	public Orders(int OrdersID) {
		this.setOrderID(OrdersID);
	}

	public Orders(Long id, int orderID) {
		this.setId(id);
		this.setOrderID(OrderID);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		this.OrderID = orderID;
	}

	@Override
	public String toString() {
		return "id:" + id + " orderID:" + OrderID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(OrderID, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return OrderID == other.OrderID && Objects.equals(id, other.id);
	}

}
