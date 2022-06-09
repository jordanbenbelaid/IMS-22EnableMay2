package com.qa.ims.Items;
import java.util.List;



package com.qa.ims.Items;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.CrudController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class ItemsController implements CrudController<Customer> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO ItemsDAO;
	private Utils utils;

	public ItemsController(ItemsDAO ItemsDAO, Utils utils) {
		super();
		this.ItemsDAO = ItemsDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Items> readAll() {
		List<Items> items = ItemsDAO.readAll();
		for (Items items : items) {
			LOGGER.info(Items);
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
		Items items = ItemsDAO.create(new Items(itemsName, price));
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
		Items items = itemsDAO.update(new Items(id, ItemsName, price));
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
		return ItemsDAO.delete(id);
	}

}

