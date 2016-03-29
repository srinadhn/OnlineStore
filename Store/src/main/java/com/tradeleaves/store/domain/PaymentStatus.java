package com.tradeleaves.store.domain;
// Generated 27 Mar, 2016 3:29:16 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PaymentStatus generated by hbm2java
 */
@Entity
@Table(name = "payment_status")
public class PaymentStatus implements java.io.Serializable {

	private String paymentId;
	private Product product;
	private UserProfile userProfile;
	private Integer productQuantity;
	private String paymentMode;
	private String paymentStatus;
	private Date paymentDate;
	private Set<Order> orders = new HashSet<Order>(0);
	private Set<OrderHistory> orderHistories = new HashSet<OrderHistory>(0);

	public PaymentStatus() {
	}

	public PaymentStatus(String paymentId, Product product, UserProfile userProfile) {
		this.paymentId = paymentId;
		this.product = product;
		this.userProfile = userProfile;
	}

	public PaymentStatus(String paymentId, Product product, UserProfile userProfile, Integer productQuantity,
			String paymentMode, String paymentStatus, Date paymentDate, Set<Order> orders,
			Set<OrderHistory> orderHistories) {
		this.paymentId = paymentId;
		this.product = product;
		this.userProfile = userProfile;
		this.productQuantity = productQuantity;
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.orders = orders;
		this.orderHistories = orderHistories;
	}

	@Id

	@Column(name = "PAYMENT_ID", unique = true, nullable = false, length = 50)
	public String getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Column(name = "PRODUCT_QUANTITY")
	public Integer getProductQuantity() {
		return this.productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Column(name = "PAYMENT_MODE", length = 50)
	public String getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Column(name = "PAYMENT_STATUS", length = 45)
	public String getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PAYMENT_DATE", length = 19)
	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentStatus")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentStatus")
	public Set<OrderHistory> getOrderHistories() {
		return this.orderHistories;
	}

	public void setOrderHistories(Set<OrderHistory> orderHistories) {
		this.orderHistories = orderHistories;
	}

}