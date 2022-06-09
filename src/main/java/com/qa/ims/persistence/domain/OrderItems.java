package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItems {
	
	private Long orderItemsId;
	private Long fkItemsId;
	private Long fkOrderId;
	private int itemQuantity; 
	private double orderCost;
	
	public OrderItems(int itemQuantity, double orderCost) {
		this.setItemQuantity(itemQuantity);
		this.setOrderCost(orderCost);
	}

	public OrderItems(Long orderItemsId, Long fkitemsId, Long fkorderId, int itemQuantity, double orderCost ) {
		this.setOrderItemsId(orderItemsId);
		this.setFkItemsId(fkitemsId);
		this.setFkOrderId(fkorderId);
		this.setItemQuantity(itemQuantity);
		this.setOrderCost(orderCost);		
	}

	public Long getOrderItemsId() {
		return orderItemsId;
	}

	public void setOrderItemsId(Long orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public Long getFkItemsId() {
		return fkItemsId;
	}

	public void setFkItemsId(Long fkItemsId) {
		this.fkItemsId = fkItemsId;
	}

	public Long getFkOrderId() {
		return fkOrderId;
	}

	public void setFkOrderId(Long fkOrderId) {
		this.fkOrderId = fkOrderId;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}

//	public double orderCost() {
//		double orderCost = getItemQuantity() * Item.getPrice();
//		return orderCost;
//		
//	}
	@Override
	public String toString() {
		return "OrderItems [orderItemsId=" + orderItemsId + ", fkItemsId=" + fkItemsId + ", fkOrderId=" + fkOrderId
				+ ", itemQuantity=" + itemQuantity + ", orderCost=" + orderCost + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkItemsId, fkOrderId, itemQuantity, orderCost, orderItemsId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		return Objects.equals(fkItemsId, other.fkItemsId) && Objects.equals(fkOrderId, other.fkOrderId)
				&& itemQuantity == other.itemQuantity
				&& Double.doubleToLongBits(orderCost) == Double.doubleToLongBits(other.orderCost)
				&& Objects.equals(orderItemsId, other.orderItemsId);
	}
	
}
	