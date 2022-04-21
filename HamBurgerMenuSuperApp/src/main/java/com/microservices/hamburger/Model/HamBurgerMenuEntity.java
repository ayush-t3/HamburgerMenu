/**
 * 
 */
package com.microservices.hamburger.Model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 33000006
 *
 */
@Entity
@Table(name = "HamBurgerMenu")
@SqlResultSetMapping(name = "HamBurgerMenuClass", classes = @ConstructorResult(targetClass = HamBurgerMenuEntity.class,
                     columns = {
                    		 @ColumnResult(name = "ProductId", type = int.class),
                    		 @ColumnResult(name = "ProductName", type= String.class),
                    		 @ColumnResult(name = "ProductIconPath", type = String.class),
                    		 @ColumnResult(name = "ParentId", type = int.class),
                    		 @ColumnResult(name = "HasLayer", type = Boolean.class),
                    		 @ColumnResult(name = "RequireRedirection", type = Boolean.class)
                     }))
public class HamBurgerMenuEntity {
	@Id
	private int productId;
	private String productName;
	private String productIconPath;
	private int parentId;
	private Boolean hasLayer;
	private Boolean requireRedirection;
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
	public HamBurgerMenuEntity(@JsonProperty("ProductId") int productId,@JsonProperty("ProductName") String productName,@JsonProperty("ProductIconPath") String productIconPath,@JsonProperty("ProductParentId") int parentId,
		@JsonProperty("HasLayer")	Boolean hasLayer,@JsonProperty("RequireRedirection") Boolean requireRedirection) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productIconPath = productIconPath;
		this.parentId = parentId;
		this.hasLayer = hasLayer;
		this.requireRedirection = requireRedirection;
	}
	
	
	public HamBurgerMenuEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HamBurgerMenuEntity [productId=" + productId + ", productName=" + productName + ", productIconPath="
				+ productIconPath + ", parentId=" + parentId + ", hasLayer=" + hasLayer + ", requireRedirection="
				+ requireRedirection + "]";
	}
	
	
	
}
