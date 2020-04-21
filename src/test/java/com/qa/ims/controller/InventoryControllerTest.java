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

import com.qa.ims.persistence.domain.Inventory;
import com.qa.ims.services.InventoryServices;

@RunWith(MockitoJUnitRunner.class)
public class InventoryControllerTest {

	@Mock
	private InventoryServices inventoryServices;

	@Spy
	@InjectMocks
	private InventoryController inventoryController;

	@Test
	public void readAllTest() {
		InventoryController inventoryController = new InventoryController(inventoryServices);
		List<Inventory> inventorys = new ArrayList<>();
		inventorys.add(new Inventory(1, "ef", 14.99, 5));
		Mockito.when(inventoryServices.readAll()).thenReturn(inventorys);
		assertEquals(inventorys, inventoryController.readAll());
	}

	@Test
	public void createTest() {
		Inventory inventory = new Inventory("Bucci", 48.99, 5);
		Mockito.doReturn(inventory).when(inventoryController).getClass();
		Inventory savedInventory = new Inventory(0, "Bucci", 48.99, 5);
		Mockito.when(inventoryServices.create(inventory)).thenReturn(savedInventory);
		assertEquals(savedInventory, inventoryController.create());
	}

	public void updateTest() {
		Inventory inventory = new Inventory(1, "Deve", 45.99, 5);
		Mockito.doReturn(inventory).when(inventoryController).getClass();
		Inventory inventorys = new Inventory(1, "Deve", 45.99, 5);
		Mockito.when(inventoryServices.update(inventory)).thenReturn(inventorys);
		assertEquals(inventorys, inventoryController.update());
	}

	public void deleteTest() {
		int inventid = 1;
		Mockito.doReturn(inventid).when(inventoryController).getInput();
		inventoryController.delete();
		Mockito.verify(inventoryServices, Mockito.times(1)).delete(1);

	}
}
