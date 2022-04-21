/**
 * 
 */
package com.microservices.hamburger.ServiceLayerImplementation;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.hamburger.DaoLayer.HamBurgerDaoLayer;
import com.microservices.hamburger.Model.HamBurgerMenuEntity;
import com.microservices.hamburger.Model.HamBurgerResponse;
import com.microservices.hamburger.ServiceInterface.HamBurgerServiceInterface;

/**
 * @author 33000006
 *
 */
@Service
public class HamBurgerServiceLayerImplementation implements HamBurgerServiceInterface {
	
	@Autowired
	private HamBurgerDaoLayer hamBurgerDaoLayer;

	@Override
	public List<HamBurgerResponse> getProductDetails(int productId) {
		
		List<HamBurgerMenuEntity> menuDb = hamBurgerDaoLayer.getProductDetails(productId);
		if(menuDb == null) {
			return null;
		}
		System.out.println(menuDb.toString());
		List<HamBurgerResponse> menu = new ArrayList<HamBurgerResponse>();
		
		for(int i = 0; i < menuDb.size(); i++) {
			HamBurgerMenuEntity entity = menuDb.get(i);
			Boolean flag = false;
			if(entity.getHasLayer()) {
				List<HamBurgerMenuEntity> child = hamBurgerDaoLayer.getProductDetails(entity.getProductId());
				HamBurgerResponse menuItem = new HamBurgerResponse(entity.getProductId(), entity.getProductName(), entity.getProductIconPath(), entity.getParentId(), entity.getHasLayer(), entity.getRequireRedirection(), child);
			    menu.add(menuItem);
			    flag = true;
			}
			if(!flag) {
				HamBurgerResponse menuItem = new HamBurgerResponse(entity.getProductId(), entity.getProductName(), entity.getProductIconPath(), entity.getParentId(), entity.getHasLayer(), entity.getRequireRedirection(), null);
			    menu.add(menuItem);
			}
		}
		return menu;
	}

}
