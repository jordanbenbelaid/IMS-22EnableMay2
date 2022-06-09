package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItems {
	
	private Long orderItemsId;
	private Long fkItemsId;
	private Long fkOrderId;
	private Long itemQuantity; 
//	private double orderCost;
	
	public OrderItems(Long fkitemsId, Long fkorderId, Long itemQuantity) {
		this.setFkItemsId(fkitemsId);
		this.setFkOrderId(fkorderId);
		this.setItemQuantity(itemQuantity);
//		this.setOrderCost(orderCost);
	}

	public OrderItems(Long orderItemsId, Long fkitemsId, Long fkorderId, Long itemQuantity ) {
		this.setOrderItemsId(orderItemsId);
		this.setFkItemsId(fkitemsId);
		this.setFkOrderId(fkorderId);
		this.setItemQuantity(itemQuantity);
//		this.setOrderCost(orderCost);		
	
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

	public Long getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "OrderItems [orderItemsId=" + orderItemsId + ", fkItemsId=" + fkItemsId + ", fkOrderId=" + fkOrderId
				+ ", itemQuantity=" + itemQuantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkItemsId, fkOrderId, itemQuantity, orderItemsId);
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
				&& Objects.equals(itemQuantity, other.itemQuantity) && Objects.equals(orderItemsId, other.orderItemsId);
	}
}
//	public double getOrderCost() {
//		return orderCost;
//	}
//
//	public void setOrderCost(double orderCost) {
//		this.orderCost = orderCost;
//	}
	
//	public double orderCost() {
//	Item item = new Item();
	
//	double orderCost = getItemQuantity() * Item.getPrice();
//	return orderCost;
//	
//}
	