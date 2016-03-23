package com.tradeleaves.store.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
