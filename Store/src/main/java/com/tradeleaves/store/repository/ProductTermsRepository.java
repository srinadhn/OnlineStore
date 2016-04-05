/**
 * 
 */
package com.tradeleaves.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeleaves.store.domain.Product;
import com.tradeleaves.store.domain.ProductTerms;

/**
 * @author Srinadh
 *
 */
public interface ProductTermsRepository extends JpaRepository<ProductTerms,String>{
	
	List<ProductTerms> findByProductId(String productId);
	
}
