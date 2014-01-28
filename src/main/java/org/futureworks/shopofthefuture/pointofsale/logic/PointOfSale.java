package org.futureworks.shopofthefuture.pointofsale.logic;

import java.util.Collection;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.futureworks.shopofthefuture.pointofsale.api.APIConnector;
import org.futureworks.shopofthefuture.pointofsale.domain.ShoppingList;
import org.futureworks.shopofthefuture.pointofsale.domain.ShoppingListItem;
import org.futureworks.shopofthefuture.pointofsale.gui.GUI;

public class PointOfSale {

	private APIConnector apiConnector;
	private GUI gui;
	
	private ShoppingList currentShoppingList;
	
	public PointOfSale(){
		this.apiConnector = APIConnector.getInstance();
		this.gui = new GUI(this);
		
		this.clearCurrentShoppingList();
	}
	
	public void clearCurrentShoppingList(){
		this.currentShoppingList = null;
	}
	
	public boolean retrieveShoppingList(String id){
		this.clearCurrentShoppingList();
		this.currentShoppingList = this.apiConnector.getShoppingList(id);
		
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
		String[] shoppingItems = new String[this.currentShoppingList.getAmountOfShoppingItems()];
		HashMap<ShoppingListItem, Integer> shoppingList = this.currentShoppingList.getItems();
		Collection<ShoppingListItem> keys = shoppingList.keySet();
		int index = 0;
		for(ShoppingListItem item : keys){
			shoppingItems[index] = new String(	item.getBarcode() + " " +
												item.getName() + " " + 
												item.getPrice() + " " +
												shoppingList.get(item));
			index++;
		}
		return shoppingItems;
	}

	public void nfcMessage() {
		this.gui.createDialog("NFC to be implemented", "IMPORANT", JOptionPane.WARNING_MESSAGE);
	}

	public void pinMessage() {
		this.gui.createDialog("PIN Payment", "PIN Payment", JOptionPane.INFORMATION_MESSAGE);
	}
	

	public void cashMessage() {
		this.gui.createDialog("Cash Payment", "Cash Payment", JOptionPane.INFORMATION_MESSAGE);
	}
}
