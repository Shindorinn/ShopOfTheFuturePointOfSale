package org.futureworks.shopofthefuture.pointofsale.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JOptionPane;

import org.futureworks.shopofthefuture.pointofsale.api.APIConnector;
import org.futureworks.shopofthefuture.pointofsale.domain.ShoppingList;
import org.futureworks.shopofthefuture.pointofsale.domain.ShoppingListItem;
import org.futureworks.shopofthefuture.pointofsale.gui.GUI;

public class PointOfSale {

	private APIConnector apiConnector;
	private GUI gui;
	
	private ShoppingList currentShoppingList;
	private String[] currentShoppingItems;
	private double currentPrice;
	
	private Random random;
	
	private static PointOfSale instance;
	
	private PointOfSale(){
		this.apiConnector = APIConnector.getInstance();
		this.gui = new GUI(this);
		
		this.clearCurrentShoppingList();
		try {
			this.currentShoppingList = apiConnector.getShoppingCart("1");
			this.updateView();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static PointOfSale getInstance(){
		if(PointOfSale.instance == null){
			PointOfSale.instance = new PointOfSale();
		}
		return PointOfSale.instance;
	}
	
	public void clearCurrentShoppingList(){
		this.currentShoppingList = null;
	}
	
	public boolean retrieveShoppingList(String id){
		this.clearCurrentShoppingList();
		try {
			this.currentShoppingList = this.apiConnector.getShoppingCart(id);
		} catch (IOException e) {
			System.err.println("PointOfSale -> retrieveShoppingList");
			e.printStackTrace();
		}
		
		if(this.currentShoppingList != null){
			return true;
		}
		
		return false;
	}
	
	public void setNewShoppingList(ShoppingList shoppingList){
		this.clearCurrentShoppingList();
		this.currentShoppingList = shoppingList;
	}
	
	public void updateView(){
		this.gui.updateGUI();
	}
	
	public String[] getShoppingList(){
		this.currentPrice = 0;
		
		this.currentShoppingItems = new String[this.currentShoppingList.getAmountOfShoppingItems()];
		ArrayList<ShoppingListItem> shoppingList = this.currentShoppingList.getItems();
		
		for(int index = 0; index < shoppingList.size();index++){
			ShoppingListItem item = shoppingList.get(index);
			this.currentShoppingItems[index] = new String(	item.getBarcode() + " " +
												item.getName() + " " + 
												item.getPrice() + " " +
												item.getAmount());
			
			this.currentPrice += (item.getPrice() * item.getAmount());
			
			System.out.println("getShoppingList() index : " + index + " -> " + this.currentShoppingItems[index]);
			
		}
		return this.currentShoppingItems;
	}

	public void nfcMessage() {
		this.gui.createDialog("NFC to be implemented", "IMPORANT", JOptionPane.WARNING_MESSAGE);
	}

	public void pinMessage() {
		this.gui.createDialog("PIN Payment : " + this.currentPrice, "PIN Payment", JOptionPane.INFORMATION_MESSAGE);
	}

	public void cashMessage() {
		this.gui.createDialog("Cash Payment : " + this.currentPrice, "Cash Payment", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void randomItemCheckMessage(){
		this.gui.createDialog("Please check the items : \n" + getRandomItems(), "Random Item Check", JOptionPane.WARNING_MESSAGE);
	}
	
	public String[] getRandomItems(){
		ArrayList<String> buffer = new ArrayList<String>();
		int amount = 0;
		
		while(amount < 3 && amount < this.currentShoppingItems.length){
			buffer.add(this.currentShoppingItems[random.nextInt(this.currentShoppingItems.length -1)]);
		}
		return (String[]) buffer.toArray();
	}
}
