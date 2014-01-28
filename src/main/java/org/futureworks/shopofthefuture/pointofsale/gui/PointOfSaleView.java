package org.futureworks.shopofthefuture.pointofsale.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.futureworks.shopofthefuture.pointofsale.domain.ShoppingListItem;

public class PointOfSaleView extends JPanel {

	private JPanel leftContainer;
	private JPanel rightContainer;
	
	private JLabel searchFieldLabel;
	private JTextField searchField;
	private JButton searchButton;
	
	private JList<ShoppingListItem> shoppingListView;
	
	private JButton nfcButton;
	private JButton pinButton;
	private JButton cashButton;
	
	private JButton randomCheckButton;
	
	public PointOfSaleView(){
		super.add(this.createLeftContainer());
		super.add(this.createRightContainer());
	}
	
	private JPanel createLeftContainer(){
		this.leftContainer = new JPanel();
		
		this.searchFieldLabel = new JLabel("Shopping List Search");

		this.searchField = new JTextField();
		this.searchButton = new JButton("Search");
		
		this.shoppingListView = new JList<ShoppingListItem>();
		
		this.leftContainer.add(this.searchFieldLabel);
		this.leftContainer.add(this.searchField);
		this.leftContainer.add(this.searchButton);
		this.leftContainer.add(this.shoppingListView);
		
		return this.leftContainer;
	}
	
	private JPanel createRightContainer(){
		this.rightContainer = new JPanel();
		
		this.nfcButton = new JButton("NFC");
		this.pinButton = new JButton("PIN");
		this.cashButton = new JButton("Cash");
		
		this.randomCheckButton = new JButton("Random Item Check");
		
		this.rightContainer.add(this.nfcButton);
		this.rightContainer.add(this.pinButton);
		this.rightContainer.add(this.cashButton);
		
		this.rightContainer.add(this.randomCheckButton);
		
		return this.rightContainer;
	}
}
