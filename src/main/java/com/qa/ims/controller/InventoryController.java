package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Inventory;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class InventoryController implements CrudController<Inventory> {

	public static final Logger LOGGER = Logger.getLogger(InventoryController.class);

	private CrudServices<Inventory> InventoryServices;

	public InventoryController(CrudServices<Inventory> InventoryServices) {
		this.InventoryServices = InventoryServices;

	}

	String getInput() {
		return Utils.getInput();
	}

	Long getLongFromInput() {
		return Utils.getLongFromInput();
	}

	Double getDoubleFromInput() {
		return Utils.getDoubleFromInput();
	}

	Integer getIntFromInput() {
		return Utils.getIntFromInput();
	}

	@Override
	public List<Inventory> readAll() {
		List<Inventory> inventorys = InventoryServices.readAll();
		for (Inventory Inventory : inventorys) {
			LOGGER.info(Inventory.toString());
		}
		return inventorys;
	}

	@Override
	public Inventory create() {
		LOGGER.info("Please enter the name of the inventory youd like to create");
		String inventoryName = getInput();
		LOGGER.info("please enter the the cost of the inventory");
		Double inventoryCost = getDoubleFromInput();
		LOGGER.info("Please enter the total number of items in the inventory");
		int inventoryTot = getIntFromInput();
		LOGGER.info("a New item in the inventory has been made");
		Inventory inventory = InventoryServices.create(new Inventory(inventoryName, inventoryCost, inventoryTot));
		return inventory;
	}

	@Override
	public Inventory update() {
		LOGGER.info("Please enter the inventid of the items you'd like to update");
		int inventid = getIntFromInput();
		LOGGER.info("Please eneter the name of the inventory youd like to update");
		String InventoryName = getInput();
		LOGGER.info("Please enter the new cost of the inventory or current");
		Double inventoryCost = getDoubleFromInput();
		LOGGER.info("Please enter the new total amount of inventory or current");
		int inventorytot = getIntFromInput();
		Inventory inventorys = InventoryServices
				.update(new Inventory(inventid, InventoryName, inventoryCost, inventorytot));
		return inventorys;
	}

	@Override
	public void delete() {
		LOGGER.info("please enter the id of the inventory item youd like to delete");
		int inventid = getIntFromInput();
		InventoryServices.delete(inventid);
	}

}
