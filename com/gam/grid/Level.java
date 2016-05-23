package com.gam.grid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import com.gam.gui.Gui;
import com.gam.thing.GridStack;
import com.gam.thing.ViewableObject;

public class Level extends JComponent implements Gui {
	
	/**
	 * A level is a fancy 2D array.
	 * It contains:
	 * 		- A 2D array of ViewableObjects which comprises the main map.
	 * 		- OPTIONAL: Color variables to customize the appearances of different levels.
	 *		- OPTIONAL: Mob Spawning, AI, statistic, and other modifiers
	 * You should only create a level for testing purposes.  Levels are not serialized.
	 * They should be temporary objects created from files by the MapParser class.
	 */
	
	private String name;
	private GridStack[][] data;
	private int height;
	private int length;
	
	private Color ColorFilter;//if initialized this filters colors on the level
	private int ColorFilterOpacity;//controls the opacity of the filter, in %
	
	//private int PlayerStatModifier;//add/subtracts this number from the player's stats
	//private int MobStatModifier;//add/subtracts this number from the monsters' stats
	
	//private boolean destructible;//controls whether the player can destroy the environment
	
	public Level() {}
	
	public Level(GridStack[][] d) {
		data = d;
		height = d.length;
		length = d[0].length;
		this.setPreferredSize(new Dimension(gui_tilesize*height, gui_tilesize*length));
	}
	
	public Level(GridStack[][] d, Color f, int a) {
		data = d;
		ColorFilter = f;
		ColorFilterOpacity = a;
	}
	
	public void setName(String s) {
		name = s;
	}
	public String getName() {
		return name;
	}
	public void setGrid(GridStack[][] g) {
		data = g;
	}
	
	public String toString() {
		return name;
	}
	
	
	public void addVO(ViewableObject v, int x, int y) {
		data[y][x].add(v);
	}
	public void removeTopVO(ViewableObject v, int x, int y) {
		data[y][x].removeTop();
	}
	public GridStack getGridStack(int x, int y) {
		//System.out.println(data[y][x].toString());
		return data[y][x];
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
	
		for (int i=0 ; i<height ; i++) {
			for (int j=0 ; j<length ; j++) {
				if (data[i][j].top().isTransparent()) {
					data[i][j].floor().paint(g2d, gui_tilesize, (j*gui_tilesize), (i*gui_tilesize));
				}
				data[i][j].top().paint(g2d, gui_tilesize, (j*gui_tilesize), (i*gui_tilesize));
			}
		}
	}
	
	

}
