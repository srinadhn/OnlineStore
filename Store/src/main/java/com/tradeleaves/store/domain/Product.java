package com.tradeleaves.store.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.tradeleaves.store.domain.audit.AuditEntiry;

@Entity
@Table(name = "product")
public class Product extends AuditEntiry implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productId;
	
	private String productName;
	
	private String productDescription;
	
	private BigDecimal productCost;
	
	private String categoryId;
	
	private String freeShippingEligible;
	
	private String cashOnDevliveryEligible;
	
	private String productImageUrl;
	
	private String status;
	
	private String supplierName;
	
	private String productFeatures;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public BigDecimal getProductCost() {
		return productCost;
	}

	public void setProductCost(BigDecimal productCost) {
		this.productCost = productCost;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getFreeShippingEligible() {
		return freeShippingEligible;
	}

	public void setFreeShippingEligible(String freeShippingEligible) {
		this.freeShippingEligible = freeShippingEligible;
	}

	public String getCashOnDevliveryEligible() {
		return cashOnDevliveryEligible;
	}

	public void setCashOnDevliveryEligible(String cashOnDevliveryEligible) {
		this.cashOnDevliveryEligible = cashOnDevliveryEligible;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getProductFeatures() {
		return productFeatures;
	}

	public void setProductFeatures(String productFeatures) {
		this.productFeatures = productFeatures;
	}
	
	
	
}
