/**
 * 
 */
package com.microservices.hamburger.ServiceInterface;

import java.util.List;

import com.microservices.hamburger.Model.HamBurgerResponse;

/**
 * @author 33000006
 *
 */
public interface HamBurgerServiceInterface {
	
	public List<HamBurgerResponse> getProductDetails(int productId);

}
