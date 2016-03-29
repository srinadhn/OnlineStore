/**
 * 
 */
package com.tradeleaves.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeleaves.store.domain.Order;
import com.tradeleaves.store.domain.UserProfile;

/**
 * @author Srinadh
 *
 */
public interface OrderRepository extends JpaRepository<Order,String>{
	
	List<Order> findByUserProfile(UserProfile userProfile);

}
