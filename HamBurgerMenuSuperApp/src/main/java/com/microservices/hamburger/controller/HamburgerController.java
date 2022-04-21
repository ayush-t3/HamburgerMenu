/**
 * 
 */
package com.microservices.hamburger.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.hamburger.Model.HamBurgerResponse;
import com.microservices.hamburger.Model.OriginalHamBurgerResponse;
import com.microservices.hamburger.ServiceInterface.HamBurgerServiceInterface;

/**
 * @author 33000006
 *
 */
@RestController
@RequestMapping("api/v1/Engagement")
@CrossOrigin("*")
public class HamburgerController {
	
	@Autowired
	private HamBurgerServiceInterface hamBurgerServiceInterface;

	@SuppressWarnings({ "unchecked" })
	@PostMapping("/getProducts")
	public OriginalHamBurgerResponse getProductsDetails(@RequestBody String requestBody) throws ParseException {
		JSONParser parser = new JSONParser(requestBody);
		HashMap<String, String> requestBodyHashMap = (HashMap<String, String>) parser.parse();
		
		List<HamBurgerResponse> response = hamBurgerServiceInterface.getProductDetails(Integer.parseInt(requestBodyHashMap.get("ParentProductId")));
//		System.out.println(response);
		if(response.isEmpty()) {
			OriginalHamBurgerResponse finalResponse = new OriginalHamBurgerResponse(0, 1, "", "Failure", response);
			return finalResponse;
		}
		OriginalHamBurgerResponse finalResponse = new OriginalHamBurgerResponse(1, 0, "", "Success", response);
		
		return finalResponse;
	}
}
