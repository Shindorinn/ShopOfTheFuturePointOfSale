package org.futureworks.shopofthefuture.pointofsale.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI extends JFrame{

	private static final String TITLE = "Shop of the Future - Point of Sale representation";
	private static final Dimension SIZE = new Dimension(1024, 768);
	
	private static final boolean RESIZABILITY = false;
	private static final boolean VISIBILITY = true;
	
	private PointOfSaleView pointOfSaleView;
	
	public GUI(){
		
		this.pointOfSaleView = new PointOfSaleView();
		
		super.add(this.pointOfSaleView);
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setTitle(GUI.TITLE);
		super.setSize(GUI.SIZE);
		super.setPreferredSize(GUI.SIZE);
		super.pack();
		super.setResizable(GUI.RESIZABILITY);
		super.setVisible(GUI.VISIBILITY);
	}
	
	
}
