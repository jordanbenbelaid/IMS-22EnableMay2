package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.orderItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.orderItems;
import com.qa.ims.utils.Utils;

/**
 * Takes in orderItems details for CRUD functionality
 *
 */
public class orderItemsController implements CrudController<orderItems> {

	public static final Logger LOGGER = LogManager.getLogger();

	private orderItemsDAO OrderItemsDAO;
	private Utils utils;

	public orderItemsController(orderItemsDAO orderItemsDAO, Utils utils) {
		super();
		this.OrderItemsDAO = orderItemsDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orderItems to the logger
	 */
	@Override
	public List<orderItems> readAll() {
		List<orderItems> OrderItems = OrderItemsDAO.readAll();
		for (orderItems o : OrderItems) {
			LOGGER.info(o);
		}
		return OrderItems;
	}

	/**
	 * Creates a orderItems by taking in user input
	 */
	@Override
	public orderItems create() {
		LOGGER.info("Please enter an item Quantity");
		int itemQuantity = utils.getInt();
		LOGGER.info("Please enter an orderCost");
		int orderCost = utils.getInt();
		orderItems OrderItems = OrderItemsDAO.create(new orderItems(itemQuantity, orderCost));
		LOGGER.info("orderItems created");
		return OrderItems;
	}

	/**
	 * Updates an existing orderItems by taking in user input
	 */
	@Override
	public orderItems update() {
		LOGGER.info("Please enter the id of the orderItems you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter an item Quantity");
		int itemQuantity = utils.getInt();
		LOGGER.info("Please enter an orderCost");
		int orderCost = utils.getInt();
		orderItems OrderItems = OrderItemsDAO.update(new orderItems(id, itemQuantity, orderCost));
		LOGGER.info("orderItems Updated");
		return OrderItems;
	}

	/**
	 * Deletes an existing orderItems by the id of the orderItems
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the orderItems you would like to delete");
		Long id = utils.getLong();
		return OrderItemsDAO.delete(id);
	}



}
