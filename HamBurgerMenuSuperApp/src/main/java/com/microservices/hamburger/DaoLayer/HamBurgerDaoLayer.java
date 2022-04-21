/**
 * 
 */
package com.microservices.hamburger.DaoLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservices.hamburger.Model.HamBurgerMenuEntity;

/**
 * @author 33000006
 *
 */
@Repository
public class HamBurgerDaoLayer {
	
	@Autowired
	private EntityManager eManager;
	public HamBurgerDaoLayer() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public List<HamBurgerMenuEntity> getProductDetails(int productId){
		
		try {
			StoredProcedureQuery query = eManager.createStoredProcedureQuery("spHamBurgerMenu", "HamBurgerMenuClass")
					.registerStoredProcedureParameter("ParentId", int.class, ParameterMode.IN)
					.setParameter("ParentId", productId);
			query.execute();
			
			return query.getResultList();
		}
		catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
