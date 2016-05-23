package com.gam.thing;

import java.awt.Graphics2D;

import com.gam.backend.AIManager;
import com.gam.backend.Direction;
import com.gam.grid.Level;

public abstract class Actor extends ViewableObject {
	
	/**
	 * An actor is anything that meets the following conditions:
	 * 		- Viewable on the map
	 * 		- Performs actions on it's own.  An actor has volition and does more than react to actions
	 */
	
	public Actor() {
		this.setCollisions(true);
		AIManager.getAIM().addActor(this);
	}
	
	public enum shape {
		HUMANOID, QUADRUPED, WINGED, INCORPOREAL, ROUND, SHAPELESS, SERPENTINE, OTHER
	}
	
	public enum material {
		ORGANIC, MECH, ARCANE, PRIMAL, DIVINE
	}
	
	public enum sentience {
		SENTIENT, SUBHUMAN, ANIMALISTIC, SIMPLE, REACTIONARY, VEGETABLE
	}
	
	public shape my_shape;
	public material my_material;
	public sentience my_sentience;
	
	public int strength;
	public int intelligence;//this is for magic
	public int agility;
	public int stamina;
	public int dexterity;
	public int spirit;
	
	public int speed;
	public int health;
	
	public boolean dead = false;
	
	public int dodge_rating;
	public int parry_rating;
	public int block_rating;
	public int hit_rating;
	public int attack_rating;
	public int spellpower_rating;
	public int luck_rating;
	public int haste_rating;//when under x% health, speed increases by a factor of this
	
	public abstract void go();
	
	public Direction plotPathTo(int x, int y, Level v) {
		boolean axis = (!((Math.abs(x) - Math.abs(y))>0));//if closer to y-axis
		//if (axis) System.out.println("axis");
		if (axis && (y > yc)) return Direction.SOUTH;
		if (axis && (y < yc)) return Direction.NORTH;
		if (x >= xc) return Direction.EAST;
		if (x <= xc) return Direction.WEST;
		return Direction.SOUTH;
	}
	
	public Direction randomDirection() {
		int i = (int) (Math.random()*4);
		switch (i) {
			case (0) : return Direction.NORTH;	
			case (1) : return Direction.EAST;	
			case (2) : return Direction.WEST;	
			case (3) : return Direction.SOUTH;	
		}
		return Direction.SOUTH;
	}

}
