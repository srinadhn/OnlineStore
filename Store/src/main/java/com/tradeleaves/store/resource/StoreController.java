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
	
	
}
