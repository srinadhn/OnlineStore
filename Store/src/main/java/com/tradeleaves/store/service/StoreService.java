package com.tradeleaves.store.service;

import java.util.List;

import com.tradeleaves.store.dao.StoreDAO;
import com.tradeleaves.store.domain.Product;

public class StoreService {
	
	
	public static List<Product> getProducts(String searchCriteria)
	{
		return StoreDAO.getProducts(searchCriteria);
	}
}
