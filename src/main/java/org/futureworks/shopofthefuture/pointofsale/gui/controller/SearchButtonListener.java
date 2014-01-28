package org.futureworks.shopofthefuture.pointofsale.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.futureworks.shopofthefuture.pointofsale.logic.PointOfSale;

public class SearchButtonListener implements ActionListener {

	private PointOfSale logic;
	private JTextField searchText;
	
	public SearchButtonListener(PointOfSale logic, JTextField searchText){
		this.logic = logic;
		this.searchText = searchText;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		this.logic.retrieveShoppingList(this.searchText.getText());
	}

}
