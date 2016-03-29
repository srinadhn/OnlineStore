package com.tradeleaves.store.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tradeleaves.store.domain.Cart;
import com.tradeleaves.store.domain.Order;
import com.tradeleaves.store.domain.OrderAddress;
import com.tradeleaves.store.domain.PaymentStatus;
import com.tradeleaves.store.domain.Product;
import com.tradeleaves.store.domain.ProductAttribute;
import com.tradeleaves.store.domain.ProductTerms;
import com.tradeleaves.store.domain.Return;
import com.tradeleaves.store.domain.ReturnRefund;
import com.tradeleaves.store.domain.UserProfile;
import com.tradeleaves.store.helper.OrderAndAddress;
import com.tradeleaves.store.helper.ReturnAndRefund;
import com.tradeleaves.store.repository.CartRepository;
import com.tradeleaves.store.repository.OrderAddressRepository;
import com.tradeleaves.store.repository.OrderRepository;
import com.tradeleaves.store.repository.PaymentStatusRepository;
import com.tradeleaves.store.repository.ProductAttributeRepository;
import com.tradeleaves.store.repository.ProductRepository;
import com.tradeleaves.store.repository.ProductTermsRepository;
import com.tradeleaves.store.repository.ReturnRefundRepository;
import com.tradeleaves.store.repository.ReturnRepository;
import com.tradeleaves.store.repository.UserProfileRepository;

@Component
public class StoreDAO {/*
	
	@Inject
	ProductRepository productRepository;
	
	@Inject
	ProductAttributeRepository productAttributeRepository;
	
	@Inject
	ProductTermsRepository productTermsRepository;
	
	@Inject
	CartRepository cartRepository;
	
	@Inject
	PaymentStatusRepository paymentStatusRepository;
	
	@Inject
	OrderRepository orderRepository;
	
	@Inject
	OrderAddressRepository orderAddressRepository;
	
	@Inject
	ReturnRepository returnRepository;
	
	@Inject
	ReturnRefundRepository returnRefundRepository;
	
	@Inject
	UserProfileRepository userProfileRepository;
	
	public List<Product> getProducts(String searchCriteria)
	{
		System.out.println("Get Products DAO method "+productRepository);
		List<Product> productList =  productRepository.findAll();
		System.out.println("List Size::"+productList.size());
		return productList;
	}
	
	public List<ProductAttribute> getProductAttributes(String productId)
	{
		System.out.println("getProductAttributes DAO method "+productId);
		return productAttributeRepository.findByProductId(productId);
	}
	
	public List<ProductTerms> getProductTerms(String productId)
	{
		return productTermsRepository.findByProductId(productId);
	}
	
	public Cart addCart(Cart cart)
	{
		return cartRepository.save(cart);
	}
	
	public List<Cart> viewCart(String userId)
	{
		UserProfile userProfile = userProfileRepository.findOne(userId);
		return cartRepository.findByUserProfile(userProfile);
	}
	
	public Boolean removeCart(String userId)
	{
		try
		{
			cartRepository.delete(new Cart());
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public PaymentStatus createPaymentStatus(PaymentStatus paymentStatus)
	{
		return paymentStatusRepository.save(paymentStatus);
	}
	
	public OrderAndAddress createOrder(OrderAndAddress orderAndAddress)
	{
		Order order = orderRepository.save(orderAndAddress.getOrder());
		
		OrderAddress orderAddress = orderAddressRepository.save(orderAndAddress.getOrderAddress());
		
		orderAndAddress.setOrder(order);
		orderAndAddress.setOrderAddress(orderAddress);
		
		return orderAndAddress;
	}
	
	public OrderAndAddress orderDetails(String orderId)
	{
		Order order = orderRepository.findOne(orderId);
		
		OrderAddress orderAddress = orderAddressRepository.findOne(orderId);
		OrderAndAddress orderAndAddress = new OrderAndAddress();
		orderAndAddress.setOrder(order);
		orderAndAddress.setOrderAddress(orderAddress);
		
		return orderAndAddress;
	}
	
	public List<Order> listOrders(String userId)
	{
		UserProfile userProfile = userProfileRepository.findOne(userId);
		return orderRepository.findByUserProfile(userProfile);
	}
	
	public Return saveReturn(Return returnObj)
	{
		return returnRepository.save(returnObj);
	}
		
	public ReturnAndRefund refundDetails(String returnId)
	{
		Return returnObj = returnRepository.findOne(returnId);
		ReturnRefund refund = returnRefundRepository.findOne(returnId);
		
		ReturnAndRefund returnAndRefund = new ReturnAndRefund();
		returnAndRefund.setReturnObj(returnObj);
		returnAndRefund.setReturnRefund(refund);
		
		return returnAndRefund;
	}
	public List<Return> listReturns(String userId)
	{
		UserProfile userProfile = userProfileRepository.findOne(userId);
		return returnRepository.findByUserProfile(userProfile);
	}
*/}
