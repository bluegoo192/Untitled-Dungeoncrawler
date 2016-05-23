package com.gam.thing.inventory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class HealingPotion extends Potions {

	public HealingPotion() {
		super("Healing Potion");
	}

	@Override
	public void paint(Graphics2D g, int size, int x, int y) {
		g.setColor(Color.blue);
		Font CharFont = new Font("Test",Font.PLAIN , 30);
		g.setFont(CharFont);
		g.drawString("h", x+(size/3) - 8, y+(size/2)+ 8);
		
	}

}
