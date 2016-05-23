package com.gam.thing.actors.mobs;

import java.awt.Font;
import java.awt.Graphics2D;

import com.gam.grid.MapParser;
import com.gam.thing.Actor;
import com.gam.thing.Actor.material;
import com.gam.thing.Actor.sentience;
import com.gam.thing.Actor.shape;
import com.gam.thing.Player;

public class Couatl extends Actor implements Mob {
int si = 0;
	
	public Couatl() {
		
		setTransparent(true);
		strength = 4;
		intelligence = 0;
		agility = 2;
		stamina  = 6;
		dexterity = 0;
		spirit = 0;
		
		speed = 5;
		health = 25;
		setName("Couatl");
		
		my_shape = shape.WINGED;
		my_material = material.ORGANIC;
		my_sentience = sentience.ANIMALISTIC;
	}

	@Override
	public void paint(Graphics2D g, int size, int x, int y) {
		g.setColor(gra_couatl);
		Font CharFont = new Font("Test",Font.ITALIC , 30);
		g.setFont(CharFont);
		g.drawString(sym_bird, x+(size/3)-5, y+(size/2)+10);
	}

	@Override
	public void go() {
		if (dead) return;
		si++;
		if ((si%speed != 0) && (si%2 == 0))
			this.move((plotPathTo(Player.getPlayer().xc, Player.getPlayer().yc, MapParser.getLevel())), MapParser.getLevel());
		if (si%speed != 0)
			this.move(randomDirection(), MapParser.getLevel());
		
	}

}
