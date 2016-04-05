package com.tradeleaves.store.helper;

import com.tradeleaves.store.domain.OrderAddress;
import com.tradeleaves.store.domain.OrderDetails;
import com.tradeleaves.store.domain.PaymentStatus;

public class OrderAndAddress {
	
	OrderDetails order;
	
	OrderAddress orderAddress;
	
	PaymentStatus paymentStatus;

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
	}

	public OrderAddress getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(OrderAddress orderAddress) {
		this.orderAddress = orderAddress;
	}
	
	
}
