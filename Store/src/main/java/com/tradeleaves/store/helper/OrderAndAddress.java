package com.tradeleaves.store.helper;

import com.tradeleaves.store.domain.Order;
import com.tradeleaves.store.domain.OrderAddress;

public class OrderAndAddress {
	
	Order order;
	
	OrderAddress orderAddress;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderAddress getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(OrderAddress orderAddress) {
		this.orderAddress = orderAddress;
	}
	
	
}
