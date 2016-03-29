package com.tradeleaves.store.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.tradeleaves.store.dao.StoreDAO;
import com.tradeleaves.store.domain.Product;
import com.tradeleaves.store.repository.ProductRepository;

@Component


public class StoreService {
	
	@Inject
	ProductRepository productRepository;
	
	@Inject
	StoreDAO storeDao;
	
	@PersistenceContext 
	EntityManager entityManager;
	
	public List<Product> getProducts(String searchCriteria)
	{
		System.out.println("Get Products DAO method "+productRepository);
		List<Product> productList =  productRepository.findAll();
		System.out.println("List Size::"+productList.size());
		return productList;
//		return storeDao.getProducts(searchCriteria);
	}
	
	/*public List<ProductAttribute> getProductAttributes(String productId)
	{
		return storeDao.getProductAttributes(productId);
	}
	public List<ProductTerms> getProductTerms(String productId)
	{
		return storeDao.getProductTerms(productId);
	}
	
	public Cart addCart(Cart cart)
	{
		return storeDao.addCart(cart);
	}
	
	public List<Cart> viewCart(String userId)
	{
		return storeDao.viewCart(userId);
	}
	
	public Boolean removeCart(String userId)
	{
		return storeDao.removeCart(userId);
	}
	
	public PaymentStatus createPaymentStatus(PaymentStatus paymentStatus)
	{
		return storeDao.createPaymentStatus(paymentStatus);
	}
	
	public OrderAndAddress createOrder(OrderAndAddress orderAndAddress)
	{
		return storeDao.createOrder(orderAndAddress);
	}
	
	public OrderAndAddress orderDetails(String orderId)
	{
		return storeDao.orderDetails(orderId);
	}
	
	public List<Order> listOrders(String userId)
	{
		return storeDao.listOrders(userId);
	}
	public Return saveReturn(Return returnObj)
	{
		return storeDao.saveReturn(returnObj);
	}
	
	public ReturnAndRefund refundDetails(String returnId)
	{
		return storeDao.refundDetails(returnId);
	}
	
	public List<Return> listReturns(String userId)
	{
		return storeDao.listReturns(userId);
	}*/
}
