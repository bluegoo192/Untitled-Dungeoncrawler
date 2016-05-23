package com.gam.thing.inventory;

public interface Inventoriable {
	
	/**
	 * Anything that can be picked up and stored in an inventory must implement Inventoriable.
	 */
	
	String i_name = null;
	
	public enum type{
		EQUIPMENT, POTIONS, COMESTIBLES, SPELLBOOKS
	}
	public enum type2{
		HEAD, CHEST, LEGGINGS, BOOTS
	}
	public type getType();
	
	

}
