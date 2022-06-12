package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class orderItemsDAO<orderItems> implements Dao<orderItems> {
	public static final Logger LOGGER = LogManager.getLogger();
	private String customersId;

	
	@Override
	public orderItems modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderItemsId = resultSet.getLong("orders_itemsID");
		Long itemsId = resultSet.getLong("fk_items_id");
		Long ordersId = resultSet.getLong("fk_orders_id");
		Long quantity = resultSet.getLong("itemQuantity");
				
		double value = resultSet.getDouble("price");
		String itemName = resultSet.getString("itemsName");
	
		
		double price = 0;
		Items items = new Items(itemsId, price, itemName);
		Customer customer = new Customer(customersId);		
		Orders orders = new Orders(ordersId, customer);
		return null;


	}
	
	// Reads all ordersItems records
	
	@Override
	public List<orderItems> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT oi.orders_items_id, oi.fk_order_ID, fk_items_id, oi.itemQuantity, i.`price`, i.itemsName, c.customers_id, FROM orders_items oi LEFT JOIN orders o ON oi.fk_order_ID = o.order_ID LEFT JOIN items i ON oi.fk_items_id = i.item_ID LEFT JOIN customers c ON o.fk_customers_id = c.customers_id");){
			List<orderItems> ordersItems = new ArrayList<>();
			while (resultSet.next()) {
				ordersItems.add(modelFromResultSet(resultSet));
			}
			return ordersItems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public orderItems readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY order_itemsID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	// Creates an orderItems record in the database
	
	@Override
	public orderItems create(orderItems OrderItems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders_items(fk_items_id, fk_orders_id, itemQuantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, orderItems.getOrderItemsId());
			statement.setLong(2, orderItems.getOrderID());
			statement.setLong(3, orderItems.getItemQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public com.qa.ims.persistence.domain.orderItems read(long orderItemsID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders_items WHERE orders_items_id= ?");) {
			statement.setLong(1, orderItemsID);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return (com.qa.ims.persistence.domain.orderItems) modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}



	//Deletes an orderItems record in the database

	@Override
	public int delete(long orderItemsId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE order_itemsID= ?");) {
			statement.setLong(1, orderItemsId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	

	@Override
	public orderItems update(orderItems t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.qa.ims.persistence.domain.orderItems modelFromResultSet(ResultSet resultSet, double price)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public orderItems read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public com.qa.ims.persistence.domain.orderItems create(long OrderItems) {
		// TODO Auto-generated method stub
		return null;
	}





	

	
}