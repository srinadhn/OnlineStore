package com.tradeleaves.store.helper;

import com.tradeleaves.store.domain.Cart;
import com.tradeleaves.store.domain.Product;

public class ProductAndCart {
	
	Product product;
	
	Cart cart;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
