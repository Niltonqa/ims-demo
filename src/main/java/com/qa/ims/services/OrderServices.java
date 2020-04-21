package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orders;

public class OrderServices implements CrudServices<Orders> {

	private Dao<Orders> ordersDao;

	public OrderServices(Dao<Orders> ordersDao) {
		this.ordersDao = ordersDao;

	}

	public List<Orders> readAll() {
		return ordersDao.readAll();
	}

	public Orders create(Orders order) {
		return ordersDao.create(order);
	}

	public Orders update(Orders order) {
		return ordersDao.update(order);
	}

	@Override
	public void delete(Object t) {
		// TODO Auto-generated method stub

	}

}