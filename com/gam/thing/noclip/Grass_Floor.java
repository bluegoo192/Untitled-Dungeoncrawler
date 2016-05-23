package com.gam.thing.noclip;

import java.awt.Color;
import java.awt.Graphics2D;

public class Grass_Floor extends Floor {

	private Color my_green;//random shade of green
	
	public Grass_Floor() {
		int lum = (int) (Math.random()*10);
		my_green = new Color(gra_grass.getRed()-lum, gra_grass.getGreen()-lum, gra_grass.getBlue()-lum);
	}
	

	
	public void paint(Graphics2D g, int size, int x, int y) {
		if (useRColors) g.setColor(my_green); else g.setColor(gra_grass);
		g.fillRect(x, y, size, size);
		
	}

}
