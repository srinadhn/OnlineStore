/**
 * 
 */
package com.tradeleaves.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeleaves.store.domain.ProductAttribute;

/**
 * @author Srinadh
 *
 */
public interface ProductAttributeRepository extends JpaRepository<ProductAttribute,String>{

	List<ProductAttribute> findByProductId(String productId);
	
}
