/**
 * 
 */
package com.tradeleaves.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeleaves.store.domain.UserLogin;

/**
 * @author Srinadh
 *
 */
public interface UserLoginRepository extends JpaRepository<UserLogin,String>{

}
