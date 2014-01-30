package org.futureworks.shopofthefuture.pointofsale.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingList {
	
	private int id;
	private int userID;
	private String name;
	
	private ArrayList<ShoppingListItem> items;
	
	public ShoppingList(int id, int userID, String name, ArrayList<ShoppingListItem> items) {
		this.id = id;
		this.userID = userID;
		this.name = name;
		this.items = items;
	}

	/**
	 * Override of the toString() method for displaying ShoppingList 
	 * correctly in the ListView
	 */
	@Override
	public String toString(){
		return name;
	}
	
	/**
	 * Getter for id
	 * @return int, id
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Getter for userID
	 * @return int, userId
	 */
	public int getUserID() {
		return userID;
	}
	
	/**
	 * Getter for name
	 * @return String, name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the amount of ShoppingItem objects that are specified
	 * in the container.
	 * @return int, the amount ShoppingItem objects
	 */
	public int getAmountOfShoppingItems(){
		return items.size();
	}
	
	/**
	 * Getter for itemList
	 * @return HashMap<ShoppingListItem, Integer>, List of items ShoppingItem -> amount
	 */
	public ArrayList<ShoppingListItem> getItems() {
		return items;
	}

}