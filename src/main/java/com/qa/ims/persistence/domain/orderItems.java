package com.qa.ims.persistence.domain;

import java.util.Objects;

public class orderItems {
	private Long orderItemsID;
	private Items items;
	private Orders orders;
	private Long itemQuantity;
	
	
	public orderItems(Items items, Orders orders, Long itemQuantity) {
		this.setItems(items);
		this.setOrders(orders);
		this.setItemQuantity(itemQuantity);
		
	}
	public orderItems(Long orderItemsID, Items items, Orders orders, Long itemQuantity) {
		this.setOrderItemsID(orderItemsID);
		this.setItems(items);
		this.setOrders(orders);
		this.setItemQuantity(itemQuantity);
	}
	public Long getOrderItemsID() {
		return orderItemsID;
	}
	public void setOrderItemsID(Long orderItemsID) {
		this.orderItemsID = orderItemsID;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Long getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(Long ItemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	@Override
	public String toString() {
		return "orderItems [orderItemsID=" + orderItemsID+ ", items=" + items + ", orders=" + orders + ", itemQuantity="
				+ itemQuantity + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemQuantity, items, orderItemsID, orders);
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
		return Objects.equals(itemQuantity, other.itemQuantity) && Objects.equals(items, other.items)
				&& Objects.equals(orderItemsID, other.orderItemsID) && Objects.equals(orders, other.orders);
	}
	public long getOrderID() {
		// TODO Auto-generated method stub
		return (Long) null;
	}

	
	
	
}