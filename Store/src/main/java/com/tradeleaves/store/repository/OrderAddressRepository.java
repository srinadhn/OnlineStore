/**
 * 
 */
package com.tradeleaves.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeleaves.store.domain.OrderAddress;

/**
 * @author Srinadh
 *
 */
public interface OrderAddressRepository extends JpaRepository<OrderAddress,String>{

}
