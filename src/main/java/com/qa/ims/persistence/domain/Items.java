package com.qa.ims.persistence.domain;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;

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
	//getters and setters for price
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemsName == null) ? 0 : itemsName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
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
		if (getItemsName() == null) {
			if (other.getItemsName() != null)
				return false;
		} else if (!getItemsName().equals(other.getItemsName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	public static void add(Items modelFromResultSet) {
		// TODO Auto-generated method stub
		
	}
	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}
	

}