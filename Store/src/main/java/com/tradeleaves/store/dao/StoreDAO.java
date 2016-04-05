package com.tradeleaves.store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.tradeleaves.store.domain.Cart;
import com.tradeleaves.store.domain.OrderAddress;
import com.tradeleaves.store.domain.OrderDetails;
import com.tradeleaves.store.domain.PaymentStatus;
import com.tradeleaves.store.domain.Product;
import com.tradeleaves.store.domain.ProductAttribute;
import com.tradeleaves.store.domain.ProductTerms;
import com.tradeleaves.store.domain.Return;
import com.tradeleaves.store.domain.ReturnRefund;
import com.tradeleaves.store.helper.OrderAndAddress;
import com.tradeleaves.store.helper.ProductAndAttributes;
import com.tradeleaves.store.helper.ReturnAndRefund;
import com.tradeleaves.store.repository.CartRepository;
import com.tradeleaves.store.repository.OrderAddressRepository;
import com.tradeleaves.store.repository.OrderDetailsRepository;
import com.tradeleaves.store.repository.PaymentStatusRepository;
import com.tradeleaves.store.repository.ProductAttributeRepository;
import com.tradeleaves.store.repository.ProductRepository;
import com.tradeleaves.store.repository.ProductTermsRepository;
import com.tradeleaves.store.repository.ReturnRefundRepository;
import com.tradeleaves.store.repository.ReturnRepository;
import com.tradeleaves.store.repository.UserProfileRepository;

@Component
public class StoreDAO {
	
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
	OrderDetailsRepository orderRepository;
	
	@Inject
	OrderAddressRepository orderAddressRepository;
	
	@Inject
	ReturnRepository returnRepository;
	
	@Inject
	ReturnRefundRepository returnRefundRepository;
	
	@Inject
	UserProfileRepository userProfileRepository;
	
	public static Connection connection;
	
	public static Connection getConnection()
	{
		Connection con;
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.
	            getConnection("jdbc:mysql://localhost:3306/store"
	                ,"root","root");
	        System.out.println("Created DB Connection....");
	        return con;
	    } catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		return null;
	}
	
	public List<Product> getProducts(String searchCriteria)
	{
		System.out.println("Get Products Service method ");
		System.out.println("Get Products DAO method "+productRepository);
		List<Product> productList =  productRepository.findByProductDescriptionContaining(searchCriteria);
		System.out.println("List Size::"+productList.size());
		return productList;
	}
	
	public Product findProduct(String productId)
	{
		return productRepository.findOne(productId);
	}
	
	public ProductAndAttributes productDetails(String productId){
		ProductAndAttributes productAndAttributes = new ProductAndAttributes();
		productAndAttributes.setProduct(findProduct(productId));
		productAndAttributes.setAttributeList(getProductAttributes(productId));
		productAndAttributes.setTermsList(getProductTerms(productId));
		
		return productAndAttributes;
	}
	
	public List<ProductAttribute> getProductAttributes(String productId)
	{
		System.out.println("getProductAttributes DAO method "+productId);
		Product product = productRepository.findOne(productId);
		return productAttributeRepository.findByProductId(productId);
	}
	
	public List<ProductTerms> getProductTerms(String productId)
	{
		Product product = productRepository.findOne(productId);
		return productTermsRepository.findByProductId(productId);
	}
	
	public List<Cart> addCart(List<Cart> cartList)
	{
		Cart savedCart = null;;
		List<Cart> savedList = new ArrayList<>();
//		List<Cart> totalList = cartRepository.findAll();
		String maxCartId = cartRepository.selectMaxCartId();
		Integer cartID = null;
		if(null != maxCartId)
		{
			cartID = Integer.parseInt(maxCartId);
			cartID++;
		}
		else
		{
			cartID = 1;
		}
		for(Cart cart:cartList)
		{
			if(cart.getCartId() == null)
				cart.setCartId(cartID.toString());
			savedCart = cartRepository.save(cart);
			savedList.add(savedCart);
			cartID++;
			savedCart = null;
		}
		return savedList;
	}
	
	public List<Cart> viewCart(String userId)
	{
		return cartRepository.findByUserId(userId);
	}
	
	public Boolean removeCart(String userId)
	{
		List<Cart> cartList = viewCart(userId);
		if(cartList.size() > 0)
		{
			try
			{
				cartRepository.delete(cartList);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		return false;
	}
	
	public Boolean removeCartItem(String cartId)
	{
		try
		{
			cartRepository.delete(cartId);
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
		String maxPaymentStatusID = paymentStatusRepository.selectMaxPaymentId();
		Integer paymentStatusID = null;
		if(null != maxPaymentStatusID)
		{
			paymentStatusID = Integer.parseInt(maxPaymentStatusID);
			paymentStatusID++;
		}
		else
		{
			paymentStatusID = 1;
		}
		PaymentStatus paymentStatus = orderAndAddress.getPaymentStatus();
		List<Cart> cartList = viewCart(paymentStatus.getUserId());
		for(Cart cart : cartList)
		{
			paymentStatus.setPaymentId(paymentStatusID.toString());
			
			paymentStatus.setProductId(cart.getProductId());
			paymentStatus.setProductQuantity(cart.getQuantity());
			paymentStatus.setPaymentMode("COD");
			paymentStatus.setPaymentStatus("Success");
			paymentStatusRepository.save(paymentStatus);
			paymentStatusID++;
		}
		cartRepository.delete(cartList);
		OrderDetails order = new OrderDetails();
		String maxOrderId = orderRepository.selectMaxOrderId();
		Integer orderId = null;
		if(null != maxOrderId)
		{
			orderId = Integer.parseInt(maxOrderId);
			orderId++;
		}
		else
		{
			orderId = 1;
		}
		order.setOrderId(orderId.toString());
		order.setPaymentId(paymentStatus.getPaymentReferenceId());
		order.setUserId(paymentStatus.getUserId());
		order.setOrderStatus("Shipped");
		order.setOrderTrackingId("987654321");
//		order.setOrderDate(new Date());
		order = orderRepository.save(order);
		OrderAddress orderAddress = orderAndAddress.getOrderAddress();
		orderAddress.setOrderId(order.getOrderId());
		orderAddress = orderAddressRepository.save(orderAndAddress.getOrderAddress());
		
		orderAndAddress.setOrder(order);
		orderAndAddress.setOrderAddress(orderAddress);
		
		return orderAndAddress;
	}
	
	public OrderAndAddress orderDetails(String orderId)
	{
		OrderDetails order = orderRepository.findOne(orderId);
		
		OrderAddress orderAddress = orderAddressRepository.findOne(orderId);
		OrderAndAddress orderAndAddress = new OrderAndAddress();
		orderAndAddress.setOrder(order);
		orderAndAddress.setOrderAddress(orderAddress);
		
		return orderAndAddress;
	}
	
	public List<OrderDetails> listOrders(String userId)
	{
		List<OrderDetails> orderList = orderRepository.findAll();
		return orderList;
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
//		UserProfile userProfile = userProfileRepository.findOne(userId);
		return returnRepository.findByUserId(userId);
	}
}
