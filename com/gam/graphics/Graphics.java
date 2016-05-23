package com.gam.graphics;

import java.awt.Color;

public interface Graphics {
	
	public boolean useRColors = true;//set whether or not to use random shades of set colors
	
	public int RandomColorVariance = 10;

	public Color gra_player = new Color(191, 15, 15);
	public Color gra_jackal = new Color(156, 146, 128);
	public Color gra_couatl = new Color(133, 182, 222);
	
	public Color gra_clay = new Color(107, 58, 17);
	public Color gra_dirt = new Color(158, 132, 98);
	
	public Color gra_grass = new Color(43, 173, 48);
	
	public Color gra_stone = new Color(110, 110, 110);
	public Color gra_basalt = new Color(64, 64, 64);
	public Color gra_obsidian = new Color(18, 18, 18);
	
	public String sym_beast = "B";
	public String sym_bird = "V";
	

}
