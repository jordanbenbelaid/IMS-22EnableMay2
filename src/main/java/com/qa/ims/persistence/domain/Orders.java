package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Orders {
	private Long orderID;
	private Customer customer;
	private Long totalCost;
	
	public Customer getCustomerID() {
		return customer;
	}
	
	public Orders(Long orderID, Customer customer) {
		this.orderID = orderID;
		this.customer = customer;
	}
	
	public Orders(Long orderID, Customer customer, Long totalCost) {
		this.orderID = orderID;
		this.customer = customer;
		this.totalCost = totalCost;
	}
	public Orders(Customer customer) {
		this.customer = customer;
	}

	public Long getTotalCost() {
		return totalCost;
	}
	public void setCost(Long cost) {
		this.totalCost = cost;
	}

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Long getOrderID() {
		return orderID;
	}



	public void setOrderId(Long orderID) {
		this.orderID = orderID;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", customer=" + customer + ", totalCost= £" + totalCost + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(totalCost, customer, orderID);
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
		return Objects.equals(totalCost, other.totalCost) && Objects.equals(customer, other.customer)
				&& Objects.equals(orderID, other.orderID);
	}



	
	
	
}