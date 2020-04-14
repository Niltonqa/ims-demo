package com.qa.ims.persistence.domain;

public class Inventory {

	private Long inventoryid;
	private String inventoryname;
	private Long inventorycost;
	private Long inventorytot;

	public Inventory(String inventoryname, Long inventorycost, Long inventorytot) {
		this.inventoryname = inventoryname;
		this.inventorycost = inventorycost;
	}

	public Inventory(Long inventoryid, String inventoryname, Long inventorycost) {

	}

	public Long getInventoryid() {
		return inventoryid;
	}

	public void setInventoryid(Long inventoryid) {
		this.inventoryid = inventoryid;
	}

	public String getInventoryname() {
		return inventoryname;
	}

	public void setInventoryname(String inventoryname) {
		this.inventoryname = inventoryname;
	}

	public Long getInventorycost() {
		return inventorycost;
	}

	public void setInventorycost(Long inventorycost) {
		this.inventorycost = inventorycost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventorycost == null) ? 0 : inventorycost.hashCode());
		result = prime * result + ((inventoryid == null) ? 0 : inventoryid.hashCode());
		result = prime * result + ((inventoryname == null) ? 0 : inventoryname.hashCode());
		result = prime * result + ((inventorytot == null) ? 0 : inventorytot.hashCode());
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
		if (inventoryid == null) {
			if (other.inventoryid != null)
				return false;
		} else if (!inventoryid.equals(other.inventoryid))
			return false;
		if (inventoryname == null) {
			if (other.inventoryname != null)
				return false;
		} else if (!inventoryname.equals(other.inventoryname))
			return false;
		if (inventorytot == null) {
			if (other.inventorytot != null)
				return false;
		} else if (!inventorytot.equals(other.inventorytot))
			return false;
		return true;
	}

}