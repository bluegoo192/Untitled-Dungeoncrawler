package com.gam.thing.meshes;

import java.awt.Color;
import java.awt.Graphics2D;

public class Stone extends Wall {
	
	/**
	 * Though the name doesn't imply it, this is basically Michael's Wall class.
	 */
	
	public void paint(Graphics2D g, int size, int x, int y) {
		g.setColor(gra_stone);
		g.fillRect(x, y, size, size);
		g.setColor(gra_basalt);
		g.drawRect(x, y, size-1, size-1);
	}
	
	public String toString() {
		return "stone";
	}

}
