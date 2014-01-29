package org.futureworks.shopofthefuture.pointofsale.api;

import org.futureworks.shopofthefuture.pointofsale.domain.ShoppingList;

public class APIConnector {

	private static final String API_URL = "http://localhost:80/"; //TODO : Double-check
	
	private static APIConnector instance;
	
	private JSONParser jsonParser;
	
	private APIConnector(){
		this.jsonParser = JSONParser.getInstance();
	}
	
	public static APIConnector getInstance(){
		if(APIConnector.instance == null){
			APIConnector.instance = new APIConnector();
		}
		
		return APIConnector.instance;
	}
	
	public ShoppingList getShoppingList(String id){
		return null;
	}
}
