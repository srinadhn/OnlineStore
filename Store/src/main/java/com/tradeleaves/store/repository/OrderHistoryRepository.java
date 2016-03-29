/**
 * 
 */
package com.tradeleaves.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeleaves.store.domain.OrderHistory;

/**
 * @author Srinadh
 *
 */
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, String>{

}
