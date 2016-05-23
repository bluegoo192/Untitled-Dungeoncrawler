package com.gam.thing;

import java.awt.Graphics2D;

public abstract class StaticMesh extends ViewableObject {

	/**
	 * A StaticMesh is an object with the following properties
	 * 		- Viewable on the map
	 * 		- Purely reactionary: can respond to events but never does things on it's own
	 * 		- Can be collided with
	 */
	
	public StaticMesh() {
		setCollisions(true);
	}
	
	@Override
	public void paint(Graphics2D g, int size, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	

}
