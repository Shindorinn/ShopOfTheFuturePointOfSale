package org.futureworks.shopofthefuture.pointofsale.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.futureworks.shopofthefuture.pointofsale.gui.controller.CashButtonListener;
import org.futureworks.shopofthefuture.pointofsale.gui.controller.NFCButtonListener;
import org.futureworks.shopofthefuture.pointofsale.gui.controller.PINButtonListener;
import org.futureworks.shopofthefuture.pointofsale.gui.controller.SearchButtonListener;
import org.futureworks.shopofthefuture.pointofsale.logic.PointOfSale;

public class PointOfSaleView extends JPanel {

	private PointOfSale logic;
	
	private JPanel leftContainer;
	private JPanel rightContainer;
	
	private JLabel searchFieldLabel;
	private JTextField searchField;
	private JButton searchButton;
	
	private JList<String> shoppingListView;
	
	private JButton nfcButton;
	private JButton pinButton;
	private JButton cashButton;
	
	private JButton randomCheckButton;
	
	public PointOfSaleView(PointOfSale logic){
		// TODO : Layout management
		super.add(this.createLeftContainer());
		super.add(this.createRightContainer());
		
		this.createActionListeners(logic);
	}
	
	public void update(){
		this.createJList(this.logic.getShoppingList());
		this.repaint();
	}
	
	private void createJList(String[] data){
		if(data == null){
			this.shoppingListView = new JList<String>();
		}else{
			this.shoppingListView = new JList<String>(data);
		}
		this.leftContainer.add(this.shoppingListView);
	}
	
	private JPanel createLeftContainer(){
		this.leftContainer = new JPanel();
		
		this.searchFieldLabel = new JLabel("Shopping List Search");

		this.searchField = new JTextField();
		this.searchButton = new JButton("Search");
		
		this.leftContainer.add(this.searchFieldLabel);
		this.leftContainer.add(this.searchField);
		this.leftContainer.add(this.searchButton);

		this.createJList(null);
		
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
	
	private void createActionListeners(PointOfSale logic){
		
		this.searchButton.addActionListener(new SearchButtonListener(logic, this.searchField));
		
		this.nfcButton.addActionListener(new NFCButtonListener(logic));
		
		this.pinButton.addActionListener(new PINButtonListener(logic));
		
		this.cashButton.addActionListener(new CashButtonListener(logic));
	}
}
