package com.tradeleaves.store.service;

public class StoreService {
  public static List<Product> getProducts(String searchCriteria)
	{
		return StoreDAO.getProducts(searchCriteria);
	}
}
