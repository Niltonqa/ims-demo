package com.qa.ims.persistence.dao;

import java.sql.DriverManager;
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

	@Override
	public List<Inventory> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password){
		
	}

	@Override
	public Inventory create(Inventory t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory update(Inventory t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
