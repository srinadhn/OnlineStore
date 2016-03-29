/**
 * 
 */
package com.tradeleaves.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeleaves.store.domain.PaymentStatus;

/**
 * @author Srinadh
 *
 */
public interface PaymentStatusRepository extends JpaRepository<PaymentStatus,String>{

}
