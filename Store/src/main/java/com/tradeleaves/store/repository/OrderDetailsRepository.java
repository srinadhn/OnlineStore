/**
 * 
 */
package com.tradeleaves.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tradeleaves.store.domain.OrderDetails;

/**
 * @author Srinadh
 *
 */
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> {
	
	List<OrderDetails> findByUserId(String userId);
	
	@Query("SELECT max(orderId) FROM OrderDetails")
	String selectMaxOrderId();
}
