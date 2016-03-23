package com.tradeleaves.store.resource;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tradeleaves.store.domain.Product;
import com.tradeleaves.store.service.StoreService;

@RestController
public class StoreController {
	
	
	@RequestMapping(value="/request",method = RequestMethod.GET)
	String testGet()
	{
		System.out.println("testGet");
		return "Success";
	}
	
	@RequestMapping(value="/products/{searchCriteria}",method = RequestMethod.GET)
	public String getProducts(@PathVariable(value="searchCriteria") String searchCriteria)
	{
		System.out.println("Search Param::"+searchCriteria);
		List<Product> productList = StoreService.getProducts(searchCriteria);
		Gson gson = new Gson();
		return gson.toJson(productList);
	}
}
