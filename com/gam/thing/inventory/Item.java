package com.gam.thing.inventory;

import com.gam.thing.ViewableObject;

public abstract class Item extends ViewableObject implements Inventoriable {

	String name;

	type my_type = type.EQUIPMENT;

	public type getType() {
		return my_type;
	}

	public Item(String s) {
		setTransparent(true);
		name = s;
	}

	public String toString() {
		return name;
	}

}
