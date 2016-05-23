package com.gam.thing.inventory;

import com.gam.thing.inventory.Inventoriable.type;

public abstract class Potions extends Item {
	
	public Potions(String s) {
		super(s);
		my_type = type.POTIONS;
	}
	

	
	
}
