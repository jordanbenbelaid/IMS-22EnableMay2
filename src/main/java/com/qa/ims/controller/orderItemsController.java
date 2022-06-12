package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;


import com.qa.ims.persistence.domain.Customer;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.dao.orderItemsDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.persistence.domain.orderItems;
import com.qa.ims.utils.Utils;

public class orderItemsController implements CrudController<orderItems> {
	public static final Logger LOGGER = LogManager.getLogger();
	private orderItemsDAO ordersItemsDAO;
	private Utils utils;
	Customer customer = new Customer();
	Items items = new Items();
	Orders orders = new Orders();
	private orderItemsDAO orderItemsDAO;
	private Long ItemsID;

	public orderItemsController(orderItemsDAO orderItemsDAO, Utils utils) {
		super();
		this.orderItemsDAO = orderItemsDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orderItems records to the logger
	 */
	@Override
	public List<orderItems> readAll() {
		List<orderItems> orderItems = orderItemsDAO.readAll();
		for (orderItems order : orderItems) {
			LOGGER.info(order);
		}
		return orderItems;
	}

	/**
	 * Creates an orderoItems by taking in user input
	 */
	@Override
	public orderItems create() {
		LOGGER.info("Please enter a customer ID");
		Long customersID = utils.getLong();
		LOGGER.info("Please enter an Items ID");
		Long orderItemsID = utils.getLong();
		LOGGER.info("Please enter an Order ID");
		Long ordersID = utils.getLong();
		LOGGER.info("Please enter the itemQuantity");
		Long itemQuantity = utils.getLong();
		// customer.setId(customerId);
		orderItems OrderItemsDAO = new orderItems(itemQuantity, items, orders, itemQuantity);
		ItemsDAO itemsDAO = new ItemsDAO();
		CustomerDAO customerDAO = new CustomerDAO();
		
		Customer customer = customerDAO.read(customersID);
		Items items = itemsDAO.read(ItemsID);
		
		
		Orders orders = new Orders(ordersID, customer);
		
		orderItems orderItems = (com.qa.ims.persistence.domain.orderItems) orderItemsDAO.create(new orderItems(items,orders,itemQuantity));
		LOGGER.info("Added an item to an order");
		return orderItems;
	}
	
	@Override
	public orderItems update() {
		LOGGER.info("Update not possible");
		return null;
	}

	/**
	 * Deletes an existing Order by the id of the Order
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderItemsId = utils.getLong();
		return orderItemsDAO.delete(orderItemsId);
	}
}