/**
 * 
 */
package com.tradeleaves.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeleaves.store.domain.UserAddress;
import com.tradeleaves.store.domain.UserAddressId;

/**
 * @author Srinadh
 *
 */
public interface UserAddressRepository extends JpaRepository<UserAddress,UserAddressId>{

}
