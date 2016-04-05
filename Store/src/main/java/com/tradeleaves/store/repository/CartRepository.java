package com.tradeleaves.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tradeleaves.store.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, String>{
	
	List<Cart> findByUserId(String userId);
	
	@Query("SELECT max(cartId) FROM Cart")
	String selectMaxCartId();
}
