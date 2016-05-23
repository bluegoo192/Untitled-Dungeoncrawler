package com.gam.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.gam.thing.inventory.Inventoriable;

public interface Gui {
	
	/**
	 * This contains all the gui's "settings" variables.
	 * All elements of the gui's look and feel should be changeable in this interface.
	 */
	
	final Color off_black = new Color(38, 38, 38);
	final Color dark_grey = new Color(56, 56, 56);
	final Color off_white = new Color(236, 236, 236);
	final Color pale_blue = new Color(240, 252, 255);
	
	public int gui_tilesize = 30;//size of a map tile
	public int gui_margin = 10;
	public int gui_border_width = 3;
	public Dimension gui_map_size = new Dimension(450, 450);
	public Dimension gui_mainframe_size = new Dimension(775, 775);
	
	public Color gui_text = dark_grey;
	public Color gui_comp_background = off_white;
	public Color gui_main_background = pale_blue;
	public Color gui_border_color = dark_grey;
	
	public Border gui_comp_border = BorderFactory.createLineBorder(gui_border_color, gui_border_width);
	public Border gui_padding_border = new EmptyBorder(10, 10, 10, 10);
	
	
	

}
