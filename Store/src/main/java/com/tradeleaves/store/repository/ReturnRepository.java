/**
 * 
 */
package com.tradeleaves.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeleaves.store.domain.Return;
import com.tradeleaves.store.domain.UserProfile;

/**
 * @author Srinadh
 *
 */
public interface ReturnRepository extends JpaRepository<Return, String>{
	
	List<Return> findByUserId(String userId);
}
