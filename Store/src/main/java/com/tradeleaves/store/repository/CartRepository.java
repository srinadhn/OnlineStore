package com.tradeleaves.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeleaves.store.domain.Cart;
import com.tradeleaves.store.domain.UserProfile;

public interface CartRepository extends JpaRepository<Cart, String>{
	
	List<Cart> findByUserProfile(UserProfile userProfile);
}
