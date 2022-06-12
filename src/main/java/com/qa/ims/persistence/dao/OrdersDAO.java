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

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.persistence.domain.orderItems;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.persistence.domain.Customer;

public class OrdersDAO implements Dao<Orders>{
	public static final Logger LOGGER = LogManager.getLogger();
	
	
	
	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderID = resultSet.getLong("order_ID");
		Long customerId = resultSet.getLong("fk_customers_id");
		
		Customer customer = new Customer(null);
		
		Long totalCost = resultSet.getLong("totalCost");
		return new Orders(orderID, customer, totalCost);
	}

	//Reads all orders
	
	@Override
	public List<Orders> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT o.order_ID,oi.fk_items_id, fk_customers_id, sum(oi.itemQuantity*i.`price`) AS totalCost, FROM orders o LEFT JOIN customers c ON c.customers_id = o.fk_customers_id LEFT JOIN order_items oi ON oi.fk_orders_id = o.order_ID LEFT JOIN items i ON oi.fk_items_id=i.items_id GROUP BY o.order_ID");) {
			List<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT o.orders_id, fk_customers_id, sum(itemQuantity*`price`) AS totalCost, JOIN customers c ON c.customers_id = o.fk_customers_id JOIN order_items oi ON oi.fk_order_ID = o.order_ID JOIN items i ON oi.fk_items_id=i.items_id GROUP BY o.orders_id ORDER BY o.order_ID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	// Creates an order in the database
	
	@Override
	public Orders create(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(fk_customers_id) VALUES (?)");) {
			statement.setLong(1, order.getCustomer().getId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders read(Long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT o.order_ID, fk_customers_id, sum(itemQuantity*`price`) AS totalCost,JOIN customers c ON c.customers_id = o.fk_customers_id JOIN order_items oi ON oi.fk_order_ID = o.orders_id JOIN items i ON oi.fk_items_id=i.items_ID  WHERE order_ID = ? GROUP BY o.order_ID ORDER BY o.order_ID");) {
			statement.setLong(1, orderID);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
// Updates an order in the database
	
	@Override
	public Orders update(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders SET fk_customers_id = ? WHERE order_ID = ?");) {
			statement.setLong(1, orders.getCustomer().getId());
			statement.setLong(2, orders.getOrderID());
			statement.executeUpdate();
			return read(orders.getOrderID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	//Deletes an order in the database
	
	@Override
	public int delete(long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE orders_id= ?");) {
			statement.setLong(1, orderID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public orderItems modelFromResultSet(ResultSet resultSet, double price) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public orderItems create(long OrderItems) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public orderItems read(long orderItemsID) {
		// TODO Auto-generated method stub
		return null;
	}
}