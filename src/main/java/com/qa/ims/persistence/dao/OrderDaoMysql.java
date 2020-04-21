package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;

public class OrderDaoMysql implements Dao<Orders> {

	public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrderDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.228.16.91/ims";
		this.username = username;
		this.password = password;
	}

	public OrderDaoMysql(String jdbcConnectionurl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionurl;
		this.username = username;
		this.password = password;

	}

	Orders ordersFromResultsSet(ResultSet resultSet) throws SQLException {
		int orderid = resultSet.getInt("orderid");
		int customerId = resultSet.getInt("customerid");
		int orderamount = resultSet.getInt("orderAmount");
		Double ordercost = resultSet.getDouble("OrderCost");
		return Orders(new Orders(orderid, customerId, ordercost, orderamount));
	}

	private Orders Orders(Orders orders) {
		return null;
	}

	@Override
	public List<Orders> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			ArrayList<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(ordersFromResultsSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orders readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return ordersFromResultsSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	public Orders create(Orders order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orders(customer_id, quantity, total) values('" + order.getCustomerId()
					+ "','" + order.getOrderAmount() + "','" + order.getOrderCost() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders update(Orders order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(
					"update orders set customer_id =" + order.getCustomerId() + ", quantity =" + order.getOrderAmount()
							+ ", total=" + order.getOrderCost() + " where order_id =" + order.getOrderId());
			return readOrders(order.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	private Orders readOrders(int i) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where orderid = " + i)) {
			resultSet.next();
			return ordersFromResultsSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public void delete(Orders orderid) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from orders where orderid = " + orderid);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

	}

}
