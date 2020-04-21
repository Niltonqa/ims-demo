package com.qa.ims.persistence.domain;

public class Inventory {

	private int inventoryid;
	private String inventoryname;
	private Double inventorycost;
	private int inventorytot;

	public Inventory(String inventoryname, Double inventoryCost, int inventoryTot) {
		this.inventoryname = inventoryname;
		this.inventorycost = inventoryCost;
		this.inventorytot = inventoryTot;
	}

	public Inventory(int inventid, String inventoryName, Double inventoryCost, int inventoryTot) {
		this.inventoryid = inventid;
		this.inventoryname = inventoryName;
		this.inventorycost = inventoryCost;
		this.inventorytot = inventoryTot;
	}

	public int getInventoryid() {
		return inventoryid;
	}

	public void setInventoryid(int inventoryid) {
		this.inventoryid = inventoryid;
	}

	public String getInventoryname() {
		return inventoryname;
	}

	public void setInventoryname(String inventoryname) {
		this.inventoryname = inventoryname;
	}

	public Double getInventorycost() {
		return inventorycost;
	}

	public void setInventorycost(Double inventorycost) {
		this.inventorycost = inventorycost;
	}

	public double getInventorytot() {
		return inventorytot;
	}

	public void setInventorytot(int inventorytot) {
		this.inventorytot = inventorytot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventorycost == null) ? 0 : inventorycost.hashCode());
		result = prime * result + inventoryid;
		result = prime * result + ((inventoryname == null) ? 0 : inventoryname.hashCode());
		result = prime * result + inventorytot;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		if (inventorycost == null) {
			if (other.inventorycost != null)
				return false;
		} else if (!inventorycost.equals(other.inventorycost))
			return false;
		if (inventoryid != other.inventoryid)
			return false;
		if (inventoryname == null) {
			if (other.inventoryname != null)
				return false;
		} else if (!inventoryname.equals(other.inventoryname))
			return false;
		if (inventorytot != other.inventorytot)
			return false;
		return true;
	}

}