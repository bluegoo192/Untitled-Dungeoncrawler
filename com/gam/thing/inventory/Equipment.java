package com.gam.thing.inventory;

public abstract class Equipment extends Item {
	public type2 my_type2;
	public type my_type;
	public boolean equipped;

	public Equipment(String s, type2 types, boolean e) {
		super(s);
		my_type = type.EQUIPMENT;
		my_type2 = types;
		equipped = e;
	}

	public type2 getType2() {
		return my_type2;
	}

	public boolean isEquipped() {
		return equipped;
	}
}
