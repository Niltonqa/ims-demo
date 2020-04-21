package com.qa.ims.persistence.domain;

public class Orders {
	private int orderId;
	private int customerId;
	private int orderAmount;
	private Double orderCost;

	public Orders(int customerId, int orderAmount, Double orderCost) {
		this.customerId = customerId;
		this.orderAmount = orderAmount;
		this.orderCost = orderCost;

	}

	public Orders(int orderId, int customerId, Double orderCost, int orderAmount) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderCost = orderCost;
		this.orderAmount = orderAmount;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Double getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(Double orderCost) {
		this.orderCost = orderCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + orderAmount;
		result = prime * result + ((orderCost == null) ? 0 : orderCost.hashCode());
		result = prime * result + orderId;
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
		Orders other = (Orders) obj;
		if (customerId != other.customerId)
			return false;
		if (orderAmount != other.orderAmount)
			return false;
		if (orderCost == null) {
			if (other.orderCost != null)
				return false;
		} else if (!orderCost.equals(other.orderCost))
			return false;
		if (orderId != other.orderId)
			return false;
		return true;
	}

}
