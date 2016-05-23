package com.gam.thing;

import java.awt.Graphics2D;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.gam.backend.CombatManager;
import com.gam.backend.Direction;
import com.gam.graphics.Graphics;
import com.gam.grid.Level;
import com.gam.gui.MapView;
import com.gam.gui.StatusView;

public abstract class ViewableObject implements Graphics {
	
	/**
	 * Anything which can be seen on the map is a ViewableObject.
	 * This includes actors and droppable items
	 */
	
	JPopupMenu Pmenu = new JPopupMenu();
	JMenuItem menuItem, menuIt;
	public int xc;
	public int yc;
	private boolean transparent = false;
	private boolean collisions = false;
	private Level my_level;
	String name = null;
	
	public ViewableObject() {}
	
	public abstract void paint(Graphics2D g, int size, int x, int y);
	
	public void addToLevel(int x, int y, Level v) {
		v.addVO(this, y, x);
		xc = x;
		yc = y;
	}
	public void removeFromLevel(Level v) {
		v.getGridStack(xc, yc).removeVO(this);
	}
	
	public void forceMove(Direction d, Level v) {
		removeFromLevel(v);
		switch (d) {
			case NORTH:	v.addVO(this, xc, yc-1);	yc--;		break;
			case SOUTH:	v.addVO(this, xc, yc+1);	yc++;		break;
			case WEST:  v.addVO(this, xc-1, yc);	xc--;		break;
			case EAST:  v.addVO(this, xc+1, yc);	xc++;		break;
		}
	}
	
	public void move(Direction d, Level v) {
		GridStack next = null;
		try {
			switch (d) {                                                  
			case NORTH:	next = v.getGridStack(xc, yc-1);		break;
			case SOUTH:	next = v.getGridStack(xc, yc+1);		break;
			case WEST:  next = v.getGridStack(xc-1, yc);		break;
			case EAST:  next = v.getGridStack(xc+1, yc);		break;
			}
			if (!(next.top().canCollide())) {
				forceMove(d, v);
			} else if (next.top() instanceof Actor && ((this instanceof Player)||(next.top() instanceof Player))) {
				StatusView.getInstance().print(CombatManager.getInstance().Melee((Actor) this, (Actor) next.top()));
			}
		} catch (Exception e) {
			return;
		}
	}

	public boolean isTransparent() {
		return transparent;
	}

	public void setTransparent(boolean transparent) {
		this.transparent = transparent;
	}
	public void setCollisions(boolean b) {
		collisions = b;
	}
	public boolean canCollide() {
		return collisions;
	}
	public String getName() {
		return name;
	}
	public void setName(String s) {
		name = s;
	}

	public Level getMylevel() {
		return my_level;
	}

	public void setMylevel(Level my_level) {
		this.my_level = my_level;
	}
	

}
