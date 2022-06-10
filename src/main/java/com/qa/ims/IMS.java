package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemsController;
import com.qa.ims.controller.OrdersController;
import com.qa.ims.controller.orderItemsController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.dao.orderItemsDAO;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class IMS {

	public static final Logger LOGGER = LogManager.getLogger();

	private final CrudController<?> Orders = null;

	private final CustomerController customers;
	private final ItemsController items;
	private Utils utils;

	private CrudController<?> orderItems;

	public IMS() {
		this.utils = new Utils();
		final CustomerDAO custDAO = new CustomerDAO();
		this.customers = new CustomerController(custDAO, utils);
		
		
		this.utils = new Utils();
		final ItemsDAO itemsDAO = new ItemsDAO();
		this.items = new ItemsController(itemsDAO, utils);
		

		this.utils = new Utils();
		final OrdersDAO ordersDAO = new OrdersDAO();
		new OrdersController(ordersDAO, utils);
		
		
		this.utils = new Utils();
		final orderItemsDAO orderItemsDAO = new orderItemsDAO();
		this.orderItems = new orderItemsController(orderItemsDAO, utils);
	}

	public void imsSystem() {
		LOGGER.info("Welcome to the Inventory Management System!");
		DBUtils.connect();

		Domain domain = null;
		do {
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			domain = Domain.getDomain(utils);

			domainAction(domain);

		} while (domain != Domain.STOP);
	}

	private void domainAction(Domain domain) {
		boolean changeDomain = false;
		do {

			CrudController<?> active = null;
			switch (domain) {
			case CUSTOMER:
				active = this.customers;
				break;
			case ITEM:
				active = this.items;
				break;
			case ORDERS:
				active = this.Orders;
				break;
			case ORDER_ITEMS:
				active = this.orderItems;
			case STOP:
				return;
			default:
				break;
			}

			LOGGER.info(() -> "What would you like to do with " + domain.name().toLowerCase() + ":");

			Action.printActions();
			Action action = Action.getAction(utils);

			if (action == Action.RETURN) {
				changeDomain = true;
			} else {
				doAction(active, action);
			}
		} while (!changeDomain);
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
