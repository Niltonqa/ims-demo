package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Inventory;

public class InventoryDaoMysql implements Dao<Inventory> {

	public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public InventoryDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.228.16.91/ims";
		this.username = username;
		this.password = password;
	}

	public InventoryDaoMysql(String jdbcConnectionurl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionurl;
		this.username = username;
		this.password = password;
	}

	Inventory inventoryFromResultsSet(ResultSet resultSet) throws SQLException {
		Long inventoryid = resultSet.getLong("inventoryid");
		String inventoryname = resultSet.getString("inventoryname");
		Long inventorycost = resultSet.getLong("inventorycost");
		Long inventorytot = resultSet.getLong("inventorytot");
		return inventory(inventoryid, inventoryname, inventorycost, inventorytot);
	}

	private Inventory inventory(Long inventoryid, String inventoryname, Long inventorycost, Long inventorytot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM inventory");) {
			ArrayList<Inventory> inventorys = new ArrayList<>();
			while (resultSet.next()) {
				inventorys.add(inventoryFromResultsSet(resultSet));
			}
			return inventorys;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Inventory readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM inventory ORDER BY ID DESC LIMIT 1");) {
			resultSet.next();
			return inventoryFromResultsSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

		return null;

	}

	@Override
	public Inventory create(Inventory inventory) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into inventory(inventoryname, inventorycost, inventorytot) values( "
					+ inventory.getInventoryname() + "','" + inventory.getInventorycost() + "','"
					+ inventory.getInventorytot() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Inventory readInventory(Long inventoryid) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM inventory where id = " + inventoryid);) {
			resultSet.next();
			return inventoryFromResultsSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Inventory update(Inventory inventory) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(
					"update customers set inventoryname ='" + inventory.getInventoryname() + ", inventory cost = "
							+ inventory.getInventorycost() + "'where id =" + inventory.getInventoryid());
			return readInventory(inventory.getInventoryid());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(long inventoryid) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from inventory where id =" + inventoryid);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

	}

}
