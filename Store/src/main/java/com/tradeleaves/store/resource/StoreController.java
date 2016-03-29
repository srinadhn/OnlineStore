package com.tradeleaves.store.resource;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tradeleaves.store.domain.Cart;
import com.tradeleaves.store.domain.Order;
import com.tradeleaves.store.domain.PaymentStatus;
import com.tradeleaves.store.domain.Product;
import com.tradeleaves.store.domain.ProductAttribute;
import com.tradeleaves.store.domain.ProductTerms;
import com.tradeleaves.store.domain.Return;
import com.tradeleaves.store.helper.OrderAndAddress;
import com.tradeleaves.store.helper.ReturnAndRefund;
import com.tradeleaves.store.service.StoreService;

@RestController
public class StoreController {
	
	@Inject
	Gson gson;
	
	@Inject
	StoreService storeService;
	
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
		List<Product> productList = storeService.getProducts(searchCriteria);
		return gson.toJson(productList);
	}
	
	/*@RequestMapping(value="/productDetails/{productId}",method = RequestMethod.GET)
	public String productDetails(@PathVariable(value="productId") String productId)
	{
		System.out.println("ProductID::"+productId);
		List<ProductAttribute> productAttributeList = storeService.getProductAttributes(productId);
		return gson.toJson(productAttributeList);
	}
	
	@RequestMapping(value="/productTerms/{productId}",method = RequestMethod.GET)
	public String productTerms(@PathVariable(value="productId") String productId)
	{
		List<ProductTerms> productTermsList = storeService.getProductTerms(productId);
		return gson.toJson(productTermsList);
	}
	
	@RequestMapping(value="/cart",method = RequestMethod.POST)
	public String addCart(@RequestBody String cartString)
	{
		Cart cart = gson.fromJson(cartString, Cart.class);
		cart = storeService.addCart(cart);
		return gson.toJson(cart);
	}
	
	@RequestMapping(value="/cart/{userId}",method = RequestMethod.GET)
	public String viewCart(@PathVariable(value="userId") String userId)
	{
		List<Cart> cartList = storeService.viewCart(userId);
		return gson.toJson(cartList);
	}
	
	@RequestMapping(value="/cart",method = RequestMethod.DELETE)
	public String removeCart(@PathVariable(value="cartId") String cartId)
	{
		Boolean status = storeService.removeCart(cartId);
		return gson.toJson(status);
	}
	
	@RequestMapping(value="/payment",method = RequestMethod.POST)
	public String payment(@RequestBody String paymentString)
	{
		PaymentStatus payment = gson.fromJson(paymentString, PaymentStatus.class);
		payment = storeService.createPaymentStatus(payment);
		return gson.toJson(payment);
	}
	
	
	@RequestMapping(value="/order", method=RequestMethod.POST)
	public String createOrder(@RequestBody String orderString)
	{
		OrderAndAddress orderAndAddress = gson.fromJson(orderString, OrderAndAddress.class);
		orderAndAddress = storeService.createOrder(orderAndAddress);
		return gson.toJson(orderAndAddress);
	}
	
	@RequestMapping(value="/order/{orderId}", method=RequestMethod.GET)
	public String orderDetails(@PathVariable(value="orderId") String orderId)
	{
		OrderAndAddress orderAndAddress = storeService.orderDetails(orderId);
		return gson.toJson(orderAndAddress);
	}
	
	@RequestMapping(value="/orderList/{userId}", method=RequestMethod.GET)
	public String listOrders(@PathVariable(value="userId") String userId)
	{
		List<Order> orderList = storeService.listOrders(userId);
		return gson.toJson(orderList);
	}
	
	@RequestMapping(value="/return", method = RequestMethod.POST)
	public String initiateReturn(@RequestBody String returnString)
	{
		Return returnObj = gson.fromJson(returnString, Return.class);
		
		
		returnObj = storeService.saveReturn(returnObj);
		return gson.toJson(returnObj);
	}
	@RequestMapping(value="/return/{returnId}", method=RequestMethod.GET)
	public String returnDetails(@PathVariable(value="returnId") String returnId)
	{
		ReturnAndRefund returnAndRefund = storeService.refundDetails(returnId);
		return gson.toJson(returnAndRefund);
	}	
	
	@RequestMapping(value="/returnList/{userId}", method=RequestMethod.GET)
	public String listReturns(@PathVariable(value="userId") String userId)
	{
		List<Return> returnList = storeService.listReturns(userId);
		return gson.toJson(returnList);
	}	*/
}
