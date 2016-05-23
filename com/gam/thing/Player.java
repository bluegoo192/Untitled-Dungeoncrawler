package com.gam.thing;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import com.gam.backend.Direction;
import com.gam.thing.inventory.Inventory;
import com.gam.graphics.Graphics;
import com.gam.grid.Level;
import com.gam.gui.Gui;
import com.gam.thing.inventory.Inventoriable;

public class Player extends Actor implements Gui, Graphics {
	
	/**
	 * This is the player.
	 */
	
	public Inventory myinv;
	
	private static Player instance = null;
	
	private Player() {
		myinv = new Inventory();
		strength = 10;
		health = 100;
		setTransparent(true);
	}
	
	public static Player getPlayer() {
		if (instance == null) {
			instance = new Player();
		}
		return instance;
	}

	

	@Override
	public void paint(Graphics2D g, int size, int x, int y) {
		g.setColor(gra_player);
		Font CharFont = new Font("Test",Font.PLAIN , 30);
		g.setFont(CharFont);
		g.drawString("@", x+(size/3) - 8, y+(size/2)+ 8);
	}

	@Override
	public void go() {
	}

	public Inventory getMy_inventory() {
		return myinv;
	}

	public void setMy_inventory(Inventory my_inventory) {
		this.myinv = my_inventory;
	}
	
	public void addMy_inventory(ArrayList<Inventoriable> it){
		for(Inventoriable itt: it){
			myinv.add(itt);
		}
	}
}
