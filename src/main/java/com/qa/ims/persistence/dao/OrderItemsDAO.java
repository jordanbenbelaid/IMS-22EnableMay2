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


import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;
public class OrderItemsDAO implements Dao<OrderItems> { 

	public static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * Reads all order Order items from the database
	 */

	@Override
	public OrderItems modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderItemsId = resultSet.getLong("orderitems_Id");
		Long fkItemsId = resultSet.getLong("fk_items_id");
		Long fkOrderId = resultSet.getLong("fk_order_id");
		Long itemQuantity = resultSet.getLong("item_quantity");
//		double orderCost = resultSet.getDouble("order_cost");
		return new OrderItems(orderItemsId, fkItemsId, fkOrderId, itemQuantity);
		
	}
	
	/**
	 * Reads all Order items from the database
	 */
	@Override
	public List<OrderItems> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items");) {
			List<OrderItems> orderItems = new ArrayList<>();
			while (resultSet.next()) {
				orderItems.add(modelFromResultSet(resultSet));
			}
			return orderItems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();	
	}
	
	public OrderItems readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items ORDER BY orderitems_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	/**
	 * Creates an order item in the database
	
	 */
	
	@Override
	public OrderItems create(OrderItems orderItems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders_items(fk_order_id, fk_items_id, item_quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, orderItems.getFkItemsId());
			statement.setLong(2, orderItems.getFkOrderId());
			statement.setLong(3, orderItems.getItemQuantity());
//			statement.setDouble(4, orderItems.getOrderCost());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public OrderItems read(Long orderItemsId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders_items WHERE orderitems_id = ?");) {
			statement.setLong(1, orderItemsId);
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

	/**
	 * Updates an item in the database
	 * 
	 */
	
	@Override
	public OrderItems update(OrderItems orderItems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders_items SET fk_order_ide = ?, fk_items_id = ?, item_quantity = ?  WHERE orderitems_id = ?");) {
			statement.setLong(1, orderItems.getFkItemsId());
			statement.setLong(2, orderItems.getFkOrderId());
			statement.setLong(3, orderItems.getItemQuantity());
//			statement.setDouble(4, orderItems.getOrderCost());
			statement.executeUpdate();
			return read(orderItems.getOrderItemsId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return orderItems;
	}
		/**
		 * Deletes an item in the database
		 * 
		 * @param item_id - id of the items
		 */
		
		@Override
		public int delete(long orderItemsId) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection.prepareStatement("DELETE FROM orders_items WHERE orderitems_id = ?");) {
				statement.setLong(1, orderItemsId);
				return statement.executeUpdate();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return 0;
		}

	}



