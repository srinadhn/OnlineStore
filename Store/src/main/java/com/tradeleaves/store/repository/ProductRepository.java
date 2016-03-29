package com.tradeleaves.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tradeleaves.store.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String>{

}
