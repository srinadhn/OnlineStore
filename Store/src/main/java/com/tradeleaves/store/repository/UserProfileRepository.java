/**
 * 
 */
package com.tradeleaves.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeleaves.store.domain.UserProfile;

/**
 * @author Srinadh
 *
 */
public interface UserProfileRepository extends JpaRepository<UserProfile,String>{

}
