package com.gam.thing.inventory;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Banana extends Comestibles {
	String str = "C";
	
	public Banana() {
		super("Banana");
	}

	public void paint(Graphics2D g, int size, int x, int y) {
		g.setColor(Color.YELLOW);
		Font CharFont = new Font("Test",Font.PLAIN , 30);
		g.setFont(CharFont);
		g.drawString(str, x+(size/3) - 8, y+(size/2)+ 8);
	}
}
