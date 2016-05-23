package com.gam.backend;

import java.util.ArrayList;

import com.gam.thing.Actor;

public class AIManager {
	
	private ArrayList<Actor> Actors = new ArrayList<Actor>();
	
	private static AIManager instance = null;
	
	private AIManager() {}
	
	public static AIManager getAIM() {
		if (instance == null) {
			instance = new AIManager();
		}
		return instance;
	}
	
	public void addActor(Actor a) {
		Actors.add(a);
	}
	
	public void nextTurn() {
		for (Actor a : Actors) {
			a.go();
		}
	}

}
