package com.qa.ims.controller;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;
/**
 * Takes in customer details for CRUD functionality
 * @param <ItemsDAO>
 *
 */
public class ItemsController implements CrudController<Items> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO itemsDAO;
	private Utils utils;

	public ItemsController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Items> readAll() {
		List<Items> items = itemsDAO.readAll();
		for (Items i : items) {
			LOGGER.info(i);
		}
		return items;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Items create() {
		LOGGER.info("Please enter an item name");
		String itemsName = utils.getString();
		LOGGER.info("Please enter a price");
		int price = utils.getInt();
		Items items = itemsDAO.create(new Items(itemsName, price));
		LOGGER.info("item created");
		return items;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter an item name");
		String itemsName = utils.getString();
		LOGGER.info("Please enter a price");
		int price = utils.getInt();
		Items items = itemsDAO.update(new Items(id, itemsName, price));
		LOGGER.info("item Updated");
		return items;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemsDAO.delete(id);
	}

}

