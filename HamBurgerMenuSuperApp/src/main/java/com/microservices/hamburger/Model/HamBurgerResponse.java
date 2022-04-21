/**
 * 
 */
package com.microservices.hamburger.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 33000006
 *
 */
public class HamBurgerResponse {
	private int productId;
	private String productName;
	private String productIconPath;
	private int parentId;
	private Boolean hasLayer;
	private Boolean requireRedirection;
	private List<HamBurgerMenuEntity> child;
	
	public List<HamBurgerMenuEntity> getChild() {
		return child;
	}
	public void setChild(List<HamBurgerMenuEntity> child) {
		this.child = child;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductIconPath() {
		return productIconPath;
	}
	public void setProductIconPath(String productIconPath) {
		this.productIconPath = productIconPath;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public Boolean getHasLayer() {
		return hasLayer;
	}
	public void setHasLayer(Boolean hasLayer) {
		this.hasLayer = hasLayer;
	}
	public Boolean getRequireRedirection() {
		return requireRedirection;
	}
	public void setRequireRedirection(Boolean requireRedirection) {
		this.requireRedirection = requireRedirection;
	}
	@JsonCreator
	public HamBurgerResponse(@JsonProperty("ProductId") int productId,@JsonProperty("ProductName") String productName,@JsonProperty("ProductIconPath") String productIconPath,@JsonProperty("ProductParentId") int parentId,
		@JsonProperty("HasLayer")	Boolean hasLayer,@JsonProperty("RequireRedirection") Boolean requireRedirection,@JsonProperty("ChildProducts") List<HamBurgerMenuEntity> child) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productIconPath = productIconPath;
		this.parentId = parentId;
		this.hasLayer = hasLayer;
		this.requireRedirection = requireRedirection;
		this.child = child;
	}
	
	
	public HamBurgerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "HamBurgerResponse [productId=" + productId + ", productName=" + productName + ", productIconPath="
				+ productIconPath + ", parentId=" + parentId + ", hasLayer=" + hasLayer + ", requireRedirection="
				+ requireRedirection + ", child=" + child + "]";
	}
}
