package com.tradeleaves.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.tradeleaves.store.dao.StoreDAO;
import com.tradeleaves.store.domain.Cart;
import com.tradeleaves.store.domain.OrderDetails;
import com.tradeleaves.store.domain.PaymentStatus;
import com.tradeleaves.store.domain.Product;
import com.tradeleaves.store.domain.ProductAttribute;
import com.tradeleaves.store.domain.ProductTerms;
import com.tradeleaves.store.domain.Return;
import com.tradeleaves.store.helper.OrderAndAddress;
import com.tradeleaves.store.helper.ProductAndAttributes;
import com.tradeleaves.store.helper.ProductAndCart;
import com.tradeleaves.store.helper.ReturnAndRefund;

@Component


public class StoreService {
	
//	@Inject
//	ProductRepository productRepository;
	
	@Inject
	StoreDAO storeDao;
	
	/*@PersistenceContext 
	EntityManager entityManager;*/
	
	public List<Product> getProducts(String searchCriteria)
	{
		System.out.println("Get Products Service method ");
		/*List<Product> productList =  new ArrayList<>();
		System.out.println("List Size::"+productList.size());
		return productList;*/
		return storeDao.getProducts(searchCriteria);
	}
	
	public Product findProduct(String productId)
	{
		return storeDao.findProduct(productId);
	}
	
	public ProductAndAttributes productDetails(String productId){
		return storeDao.productDetails(productId);
	}
	
	public List<ProductAttribute> getProductAttributes(String productId)
	{
		return storeDao.getProductAttributes(productId);
	}
	public List<ProductTerms> getProductTerms(String productId)
	{
		return storeDao.getProductTerms(productId);
	}
	
	public List<Cart> addCart(List<Cart> cartList)
	{
		return storeDao.addCart(cartList);
	}
	
	public List<ProductAndCart> viewCart(String userId)
	{
		List<ProductAndCart> productCartList = new ArrayList<>();
		ProductAndCart productAndCart = null;
		List<Cart> cartList = storeDao.viewCart(userId);
		for(Cart cart : cartList)
		{
			productAndCart = new ProductAndCart();
			productAndCart.setProduct(storeDao.findProduct(cart.getProductId()));
			productAndCart.setCart(cart);
			productCartList.add(productAndCart);
			productAndCart = null;
		}
		return productCartList;
	}
	
	public Boolean removeCart(String userId)
	{
		return storeDao.removeCart(userId);
	}
	
	public Boolean removeCartItem(String cartId)
	{
		return storeDao.removeCartItem(cartId);
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
	
	public List<OrderDetails> listOrders(String userId)
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
	}
}
