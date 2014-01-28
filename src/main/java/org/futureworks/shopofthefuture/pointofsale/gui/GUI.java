package org.futureworks.shopofthefuture.pointofsale.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.futureworks.shopofthefuture.pointofsale.logic.PointOfSale;

@SuppressWarnings("serial")
public class GUI extends JFrame{

	private static final String TITLE = "Shop of the Future - Point of Sale representation";
	private static final Dimension SIZE = new Dimension(400, 400);
	
	private static final boolean RESIZABILITY = false;
	private static final boolean VISIBILITY = true;
	
	private PointOfSaleView pointOfSaleView;
	
	public GUI(PointOfSale logic){
		
		this.pointOfSaleView = new PointOfSaleView(logic);
		
		super.add(this.pointOfSaleView);
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setTitle(GUI.TITLE);
		super.setSize(GUI.SIZE);
		super.setPreferredSize(GUI.SIZE);
		super.pack();
		super.setResizable(GUI.RESIZABILITY);
		super.setVisible(GUI.VISIBILITY);
	}
	
	public void updateGUI(){
		this.pointOfSaleView.update();
	}
	
	public void createDialog(String message, String title, int messageType){
		JOptionPane.showInternalMessageDialog(this.getContentPane(), message, title, messageType);
	}
}
