package com.gam.backend;

import com.gam.grid.MapParser;
import com.gam.thing.Actor;
import com.gam.thing.Player;

public class CombatManager {
	
	/**
	 * The CombatManager controls combat at a low level.
	 * The IO system will have one instance of it.
	 * Whenever something attacks something else the combatants and the attack should be fed into this class
	 */
	
	private static CombatManager instance = null;
	
	private CombatManager() {}
	
	public static CombatManager getInstance() {
		if (instance == null) {
			instance = new CombatManager();
		}
		return instance;
	}
	
	public String Melee(Actor one, Actor two) {
		Actor winner = one;
		Actor loser = two;
		if (two.strength > one.strength) { winner = two; loser = one; }
		loser.removeFromLevel(MapParser.getLevel());
		loser.dead = true;
		if (winner instanceof Player) return ("You destroy the " + loser.getName());
		if (loser instanceof Player) return ("The " + winner.getName() + " destroys you.");
		return ("The " + winner.getName() + " destroys the " + loser.getName());
	}

}
