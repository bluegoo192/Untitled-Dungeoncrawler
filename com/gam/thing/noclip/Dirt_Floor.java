package com.gam.thing.noclip;

import java.awt.Color;
import java.awt.Graphics2D;
import com.gam.graphics.*;

public class Dirt_Floor extends Floor {
	
	private Color my_brown;//random shade of green
	
	public Dirt_Floor() {
		int lum = (int) (Math.random()*10);
		my_brown = new Color(gra_dirt.getRed()-lum, gra_dirt.getGreen()-lum, gra_dirt.getBlue()-lum);
	}
	
	public String toString() {
		return "dirt floor";
	}

	@Override
	public void paint(Graphics2D g, int size, int x, int y) {
		if (useRColors) g.setColor(my_brown); else g.setColor(gra_dirt);
		g.fillRect(x, y, size, size);
	}

}
