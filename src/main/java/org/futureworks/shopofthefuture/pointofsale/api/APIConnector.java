package org.futureworks.shopofthefuture.pointofsale.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.futureworks.shopofthefuture.pointofsale.domain.ShoppingList;
import org.futureworks.shopofthefuture.pointofsale.domain.ShoppingListItem;
import org.json.JSONArray;
import org.json.JSONObject;

public class APIConnector {

	private static final String API_URL = "http://127.0.0.1:80/phpAPI/"; 
	
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
	
	public ShoppingList getShoppingCart(String id) throws IOException{ // TODO
		URL url = new URL(API_URL+"shoppingCart/items?id="+id);

		System.out.println(url.toString());
		
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = input.readLine()) != null) {
			response.append(inputLine);
		}
		input.close();
 
		//print result
		System.out.println(response.toString());
		
		JSONArray jsonResponse = new JSONArray(response.toString());
		
		ArrayList<ShoppingListItem> items = new ArrayList<ShoppingListItem>();
		
		for(int index=0;index <jsonResponse.length();index++){
			JSONObject nextObject = new JSONObject(jsonResponse.get(index).toString());
			System.out.print(index);
			System.out.println(nextObject);
			items.add(new ShoppingListItem(new Integer(nextObject.getInt("barcode")).toString(), nextObject.getString("name"),
					nextObject.getDouble("price"), nextObject.getInt("amount"), nextObject.getInt("category")));
		}
		
		System.out.println(jsonResponse.get(0));  //barcode
		return new ShoppingList(0, 0, "unknown", items);
	}
	
	public ShoppingList getShoppingList(String id) throws IOException{ // TODO
		URL url = new URL(API_URL+"shoppingcart?id="+id);
		
		System.out.println(url.toString());
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = input.readLine()) != null) {
			response.append(inputLine);
		}
		input.close();
 
		//print result
		System.out.println(response.toString());
		
		JSONObject jsonResponse = new JSONObject(response.toString());
		return null;
	}
	
	public String getUserName(String userid) throws IOException{
		URL url = new URL(API_URL+"user?id=37");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = input.readLine()) != null) {
			response.append(inputLine);
		}
		input.close();
 
		//print result
		System.out.println(response.toString());
		
		JSONObject jsonResponse = new JSONObject(response.toString());
		return (String) jsonResponse.get("name");
	}
}
