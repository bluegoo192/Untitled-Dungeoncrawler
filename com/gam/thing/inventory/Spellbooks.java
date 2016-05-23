package com.gam.thing.inventory;

import com.gam.thing.inventory.Inventoriable.type;

public abstract class Spellbooks extends Item {
	
	public Spellbooks(String s) {
		super(s);
		my_type = type.SPELLBOOKS;
	}


	
}