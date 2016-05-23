package com.gam.main;

//import Grid.Grid;

import com.gam.grid.MapParser;
import com.gam.gui.GameFrame;

public class DungeonCrawler {
	
	/**
	 * This is the "main" class.  It runs everything and contains main(String[] args).
	 */
	
	
	
	public static void main(String[] args) {
		//new Grid();
		GameFrame game = new GameFrame();
		game.run();
		//MapParser m = new MapParser();
		//m.parse("level1.txt");
	}

	
	
}
