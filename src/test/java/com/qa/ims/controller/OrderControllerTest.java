package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private OrderServices orderServices;

	@Spy
	@InjectMocks
	private OrderController orderController;

	@Test
	public void readAllTest() {
		OrderController orderController = new OrderController(orderServices);
		List<Orders> orderfs = new ArrayList<>();
		orderfs.add(new Orders(0, 0, 49.99));
		Mockito.when(orderServices.readAll()).thenReturn(orderfs);
		assertEquals(orderfs, orderController.readAll());

	}

	@Test
	public void createTest() {
		Orders orderfs = new Orders(0, 0, 00.99);
		Mockito.doReturn(orderfs).when(orderController).getClass();
		Orders orderws = new Orders(0, 0, 00.99);
		Mockito.when(orderServices.create(orderfs)).thenReturn(orderfs);
		assertEquals(orderws, orderController.create());

	}

}
