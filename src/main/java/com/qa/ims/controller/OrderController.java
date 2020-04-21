package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Orders> OrderServices;

	public OrderController(CrudServices<Orders> OrderServices) {
		this.OrderServices = OrderServices;
	}

	String getInput() {
		return Utils.getInput();
	}

	int getIntFromInput() {
		return Utils.getIntFromInput();
	}

	Long getLongFromInput() {
		return Utils.getLongFromInput();
	}

	Double getDoubleFromInput() {
		return Utils.getDoubleFromInput();
	}

	@Override
	public List<Orders> readAll() {
		List<Orders> orderf = OrderServices.readAll();
		for (Orders Orders : orderf) {
			LOGGER.info(Orders.toString());
		}
		return orderf;
	}

	@Override
	public Orders create() {
		LOGGER.info("Please enter the customer id");
		int customerId = getIntFromInput();
		LOGGER.info("Please enter the order amount");
		int orderAmount = getIntFromInput();
		LOGGER.info("Please enter the order cost");
		Double orderCost = getDoubleFromInput();
		Orders orderf = OrderServices.create(new Orders(customerId, orderAmount, orderCost));
		LOGGER.info("order Created");
		return orderf;

	}

	@Override
	public Orders update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		int orderId = getIntFromInput();
		LOGGER.info("Please enter a customer");
		int customerId = getIntFromInput();
		LOGGER.info("Please enter a surname");
		Double orderCost = getDoubleFromInput();
		LOGGER.info("Please enter a order amount");
		int orderAmount = getIntFromInput();
		Orders orderf = OrderServices.update(new Orders(orderId, customerId, orderCost, orderAmount));
		LOGGER.info("Customer Updated");
		return orderf;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order youd like to delete");
		int orderId = getIntFromInput();
		OrderServices.delete(orderId);
		LOGGER.info("order deleted");

	}

}
