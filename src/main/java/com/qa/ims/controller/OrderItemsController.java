package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.OrderItemsDAO;

import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;

public class OrderItemsController implements CrudController<OrderItems> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private OrderItemsDAO orderItemsDAO;
	private Utils utils;
	
	public OrderItemsController(OrderItemsDAO orderItemsDAO, Utils utils) {
		super();
		this.orderItemsDAO = orderItemsDAO;
		this.utils = utils;
	}
	
	/**
	* Reads all information in order items to the logger
	*/
	@Override
	public List<OrderItems> readAll() {
		List<OrderItems> orderItems = orderItemsDAO.readAll();
		for (OrderItems orderitem : orderItems) {
		LOGGER.info(orderitem);
	}
	return orderItems;
	}
	
	/**
	* Creates an order by taking in user input
	*/
	@Override
	public OrderItems create() {
		LOGGER.info("Please enter Item Id");
		Long ItemsId = utils.getLong();
		LOGGER.info("Please enter Order Id");
		Long OrderId = utils.getLong();
		LOGGER.info("Please enter Quantity Id");
		Long itemQuantity = utils.getLong();
//		LOGGER.info("Please enter Total cost");
//		double orderCost = utils.getDouble();
		OrderItems orderItems = orderItemsDAO.create(new OrderItems(ItemsId, OrderId, itemQuantity));
		LOGGER.info("Order created");
		return orderItems;
	}
	
	/**
	* Cannot update by taking in user input
	*/
	@Override
	public OrderItems update() {
		
		LOGGER.info("OrderItems cannot be Updated");
		return null;
	}
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderItemsId = utils.getLong();
		return orderItemsDAO.delete(orderItemsId);
	}


}
