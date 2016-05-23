package com.gam.gui;

import java.awt.TextArea;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.gam.backend.CombatManager;

public class StatusView extends JPanel implements Gui {
	
	JScrollPane pane;
	private static StatusView instance = null;
	TextArea text;
	
	private StatusView() {
		this.setBorder(gui_comp_border);
		text = new TextArea("Welcome to Dungeon Crawler!");
		text.append("\nYou are playing in Developer mode.");
		
		text.setEditable(false);
		text.setFocusable(false);
		pane = new JScrollPane(text);
		this.add(pane);
	}
	
	public static StatusView getInstance() {
		if (instance == null) {
			instance = new StatusView();
		}
		return instance;
	}
	
	public void print(String s) {
		text.append("\n" + s);
	}

}
