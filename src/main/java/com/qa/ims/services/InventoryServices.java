package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Inventory;

public class InventoryServices implements CrudServices<Inventory> {

	private Dao<Inventory> InventoryDao;

	public InventoryServices(Dao<Inventory> InventoryDao) {
		this.InventoryDao = InventoryDao;
	}

	@Override
	public List<Inventory> readAll() {
		return InventoryDao.readAll();
	}

	@Override
	public Inventory create(Inventory inventory) {
		return InventoryDao.create(inventory);
	}

	@Override
	public Inventory update(Inventory inventory) {
		return InventoryDao.update(inventory);
	}

	@Override
	public void delete(Long id) {

	}

}
