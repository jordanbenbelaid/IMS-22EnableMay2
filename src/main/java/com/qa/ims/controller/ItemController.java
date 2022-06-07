package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item>  {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private ItemDAO itemDAO;
	private Utils utils;
	
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	
	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}
	/**
	 * Creates a items by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter the item name");
		String itemsName = utils.getString();
		LOGGER.info("Please enter the item price");
		double price = utils.getDouble();
		Item item = itemDAO.create(new Item(itemsName, price));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Updates an existing item by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the items_id of the Item you would like to update");
		Long itemsId = utils.getLong();
		LOGGER.info("Please enter the items name");
		String itemsName = utils.getString();
		LOGGER.info("Please enter the price");
		double price = utils.getDouble();
		Item item = itemDAO.update(new Item(itemsId, itemsName, price));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing item by the items id in the item inventory
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the item_id of the item you would like to delete");
		Long itemsId = utils.getLong();
		return itemDAO.delete(itemsId);
	}

}



