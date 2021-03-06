package com.tradeleaves.store.domain;
// Generated 1 Apr, 2016 3:00:44 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PaymentStatus generated by hbm2java
 */
@Entity
@Table(name = "payment_status", catalog = "store")
public class PaymentStatus implements java.io.Serializable {

	private String paymentId;
	private String userId;
	private String productId;
	private Integer productQuantity;
	private String paymentMode;
	private String paymentStatus;
	private Date paymentDate;
	private String paymentReferenceId;
	private Set<OrderHistory> orderHistories = new HashSet<OrderHistory>(0);

	public PaymentStatus() {
	}

	public PaymentStatus(String paymentId, String userId, String productId) {
		this.paymentId = paymentId;
		this.userId = userId;
		this.productId = productId;
	}

	public PaymentStatus(String paymentId, String userId, String productId, Integer productQuantity, String paymentMode,
			String paymentStatus, Date paymentDate, String paymentReferenceId, Set<OrderHistory> orderHistories) {
		this.paymentId = paymentId;
		this.userId = userId;
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.paymentReferenceId = paymentReferenceId;
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

	@Column(name = "USER_ID", nullable = false)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "PRODUCT_ID", nullable = false, length = 50)
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	@Column(name = "PAYMENT_REFERENCE_ID", length = 45)
	public String getPaymentReferenceId() {
		return this.paymentReferenceId;
	}

	public void setPaymentReferenceId(String paymentReferenceId) {
		this.paymentReferenceId = paymentReferenceId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentStatus")
	public Set<OrderHistory> getOrderHistories() {
		return this.orderHistories;
	}

	public void setOrderHistories(Set<OrderHistory> orderHistories) {
		this.orderHistories = orderHistories;
	}

}
