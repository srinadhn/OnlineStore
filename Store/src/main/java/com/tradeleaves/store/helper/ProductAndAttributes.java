/**
 * 
 */
package com.tradeleaves.store.helper;

import java.util.ArrayList;
import java.util.List;

import com.tradeleaves.store.domain.Product;
import com.tradeleaves.store.domain.ProductAttribute;
import com.tradeleaves.store.domain.ProductTerms;

/**
 * @author Srinadh
 *
 */
public class ProductAndAttributes {
	
		Product product;
		
		List<ProductAttribute> attributeList = new ArrayList<>();
		
		List<ProductTerms> termsList = new ArrayList<>();

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public List<ProductAttribute> getAttributeList() {
			return attributeList;
		}

		public void setAttributeList(List<ProductAttribute> attributeList) {
			this.attributeList = attributeList;
		}

		public List<ProductTerms> getTermsList() {
			return termsList;
		}

		public void setTermsList(List<ProductTerms> termsList) {
			this.termsList = termsList;
		}
		
		
}
