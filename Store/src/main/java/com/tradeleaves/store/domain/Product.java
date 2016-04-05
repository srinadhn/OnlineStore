package com.tradeleaves.store.domain;
// Generated 29 Mar, 2016 5:34:06 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
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

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {


	private String productId;
	private Category category;
	private String productName;
	private String productDescription;
	private BigDecimal productCost;
	private String freeShippingEligible;
	private String cashOnDeliveryEligible;
	private String imageUrl;
	private String status;
	private String supplierName;
	private String productFeatures;

	public Product() {
	}

	public Product(String productId) {
		this.productId = productId;
	}

	public Product(String productId, Category category, String productName, String productDescription,
			BigDecimal productCost, String freeShippingEligible, String cashOnDeliveryEligible, String imageUrl,
			String status, String supplierName, String productFeatures) {
		this.productId = productId;
		this.category = category;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productCost = productCost;
		this.freeShippingEligible = freeShippingEligible;
		this.cashOnDeliveryEligible = cashOnDeliveryEligible;
		this.imageUrl = imageUrl;
		this.status = status;
		this.supplierName = supplierName;
		this.productFeatures = productFeatures;
	}

	@Id

	@Column(name = "PRODUCT_ID", unique = true, nullable = false, length = 50)
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "PRODUCT_NAME", length = 45)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "PRODUCT_DESCRIPTION")
	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Column(name = "PRODUCT_COST", precision = 18, scale = 6)
	public BigDecimal getProductCost() {
		return this.productCost;
	}

	public void setProductCost(BigDecimal productCost) {
		this.productCost = productCost;
	}

	@Column(name = "FREE_SHIPPING_ELIGIBLE", length = 1)
	public String getFreeShippingEligible() {
		return this.freeShippingEligible;
	}

	public void setFreeShippingEligible(String freeShippingEligible) {
		this.freeShippingEligible = freeShippingEligible;
	}

	@Column(name = "CASH_ON_DELIVERY_ELIGIBLE", length = 1)
	public String getCashOnDeliveryEligible() {
		return this.cashOnDeliveryEligible;
	}

	public void setCashOnDeliveryEligible(String cashOnDeliveryEligible) {
		this.cashOnDeliveryEligible = cashOnDeliveryEligible;
	}

	@Column(name = "IMAGE_URL")
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "STATUS", length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "SUPPLIER_NAME", length = 50)
	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Column(name = "PRODUCT_FEATURES")
	public String getProductFeatures() {
		return this.productFeatures;
	}

	public void setProductFeatures(String productFeatures) {
		this.productFeatures = productFeatures;
	}


}
