package com.tradeleaves.store.resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tradeleaves.store.domain.Cart;
import com.tradeleaves.store.domain.OrderDetails;
import com.tradeleaves.store.domain.PaymentStatus;
import com.tradeleaves.store.domain.Product;
import com.tradeleaves.store.domain.ProductTerms;
import com.tradeleaves.store.domain.Return;
import com.tradeleaves.store.helper.OrderAndAddress;
import com.tradeleaves.store.helper.ProductAndAttributes;
import com.tradeleaves.store.helper.ProductAndCart;
import com.tradeleaves.store.helper.ReturnAndRefund;
import com.tradeleaves.store.service.StoreService;

@RestController
@RequestMapping("/store")
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
	public @ResponseBody ResponseEntity<Object> getProducts(@PathVariable(value="searchCriteria") String searchCriteria)
	{
		System.out.println("Search Param::"+searchCriteria);
		List<Product> productList = storeService.getProducts(searchCriteria);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<Object>(productList,headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/productDetails/{productId}",method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> productDetails(@PathVariable(value="productId") String productId)
	{
		/*List<ProductAttribute> productAttributeList = storeService.getProductAttributes(productId);
		List<ProductTerms> productTermsList = storeService.getProductTerms(productId);
		Product product = storeService.findProduct(productId);
		ProductAndAttributes productAndAttributes = new ProductAndAttributes();
		productAndAttributes.setProduct(product);
		productAndAttributes.setAttributeList(productAttributeList);
		productAndAttributes.setTermsList(productTermsList);*/
		
		ProductAndAttributes productAndAttributes = storeService.productDetails(productId);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<Object>(productAndAttributes, HttpStatus.OK);
	}
	
	@RequestMapping(value="/productTerms/{productId}",method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> productTerms(@PathVariable(value="productId") String productId)
	{
		List<ProductTerms> productTermsList = storeService.getProductTerms(productId);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<Object>(productTermsList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cart",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> addCart(@RequestBody String cartString)
	{
		
		System.out.println("CartString"+cartString);
		List<Cart> cartList = gson.fromJson(cartString, new TypeToken<ArrayList<Cart>>() { }.getType());
		cartList = storeService.addCart(cartList);
		return new ResponseEntity<Object>(cartList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cart/{userId}",method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> viewCart(@PathVariable(value="userId") String userId)
	{
		List<ProductAndCart> cartList = storeService.viewCart(userId);
		return new ResponseEntity<Object>(cartList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cart/{userId}",method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> removeCart(@PathVariable(value="userId") String userId)
	{
		Boolean status = storeService.removeCart(userId);
		return new ResponseEntity<Object>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cartItem",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> removeCartItem(@RequestBody String cartString)
	{
		Cart cart = gson.fromJson(cartString, Cart.class);
		Boolean status = storeService.removeCartItem(cart.getCartId());
		return new ResponseEntity<Object>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value="/payment",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> payment(@RequestBody String paymentString)
	{
		PaymentStatus payment = gson.fromJson(paymentString, PaymentStatus.class);
		payment = storeService.createPaymentStatus(payment);
		return new ResponseEntity<Object>(payment, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/order", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> createOrder(@RequestBody String orderString)
	{
		System.out.println("orderString:: "+orderString);
		OrderAndAddress orderAndAddress = gson.fromJson(orderString, OrderAndAddress.class);
		orderAndAddress = storeService.createOrder(orderAndAddress);
		return new ResponseEntity<Object>(orderAndAddress, HttpStatus.OK);
	}
	
	@RequestMapping(value="/order/{orderId}", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> orderDetails(@PathVariable(value="orderId") String orderId)
	{
		OrderAndAddress orderAndAddress = storeService.orderDetails(orderId);
		return new ResponseEntity<Object>(orderAndAddress, HttpStatus.OK);
	}
	
	@RequestMapping(value="/orderList/{userId}", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> listOrders(@PathVariable(value="userId") String userId)
	{
		List<OrderDetails> orderList = storeService.listOrders(userId);
		return new ResponseEntity<Object>(orderList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/return", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> initiateReturn(@RequestBody String returnString)
	{
		Return returnObj = gson.fromJson(returnString, Return.class);
		
		
		returnObj = storeService.saveReturn(returnObj);
		return new ResponseEntity<Object>(returnObj, HttpStatus.OK);
	}
	@RequestMapping(value="/return/{returnId}", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> returnDetails(@PathVariable(value="returnId") String returnId)
	{
		ReturnAndRefund returnAndRefund = storeService.refundDetails(returnId);
		return new ResponseEntity<Object>(returnAndRefund, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/returnList/{userId}", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> listReturns(@PathVariable(value="userId") String userId)
	{
		List<Return> returnList = storeService.listReturns(userId);
		return new ResponseEntity<Object>(returnList, HttpStatus.OK);
	}	
}
