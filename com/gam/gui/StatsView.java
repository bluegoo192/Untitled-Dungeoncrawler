package com.gam.gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.gam.thing.Player;

public class StatsView extends JComponent implements Gui {
	
	/**StatsView contains quick info on the player's stats.
	 * 
	 */
	
	public StatsView() {
		this.setBorder(gui_comp_border);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//this.setLayout(BoxLayout);
		JTextArea name = new JTextArea("Test Player Please Ignore");
		JTextArea class_info = new JTextArea("Level 110 Javamancer");
		JTextArea class_stats = new JTextArea("Strength: " + Player.getPlayer().strength);
		JTextArea modifiers = new JTextArea("Hungry");
		modifiers.setEditable(false);
		modifiers.setFocusable(false);
		class_stats.setEditable(false);
		class_stats.setFocusable(false);
		class_info.setEditable(false);
		class_info.setFocusable(false);
		name.setEditable(false);
		name.setFocusable(false);
		name.setBorder(gui_padding_border);
		class_stats.setBorder(gui_padding_border);
		class_info.setBorder(gui_padding_border);
		modifiers.setBorder(gui_padding_border);
		this.add(name);
		this.add(class_info);
		this.add(class_stats);
		this.add(modifiers);
		
	}
	
	public void addName() {
		
	}

}
