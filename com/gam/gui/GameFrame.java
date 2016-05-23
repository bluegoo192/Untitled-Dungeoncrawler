package com.gam.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.gam.backend.Controller;
import com.gam.backend.Direction;
import com.gam.backend.PlayerMoveAction;
import com.gam.grid.Level;
import com.gam.thing.GridStack;
import com.gam.thing.Player;
import com.gam.thing.inventory.Armor;
import com.gam.thing.inventory.Inventory;
import com.gam.thing.meshes.Stone;
import com.gam.thing.noclip.Dirt_Floor;

public class GameFrame implements Gui, ActionListener {

	/**
	 * This is the window with everything in it. The map, text boxes, and other
	 * GUI elements are embedded in this. Note that GameFrame is NOT actually
	 * the frame. It manages it instead.
	 */

	JFrame mainframe;
	MapView map;
	MapView test;
	StatusView text;
	StatsView stats;
	
	Controller mc = new Controller();

	JMenuBar menuBar;
	JMenu menu, submenu, windowmenu;
	JMenuItem menuItem, inventoryMenuButton, armorMenuButton;
	JCheckBoxMenuItem cbMenuItem;

	public GameFrame() {
		System.out.println("init");
		mainframe = new JFrame("Dungeon Crawler");// create the frame
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// make it quit
																	// on close
		map = new MapView("level1.txt");
		test = new MapView(makeTestLevel());
		text = StatusView.getInstance();
		stats = new StatsView();
	}// /GameFrame constructor

	public void run() {
		((JPanel) mainframe.getContentPane()).setBorder(gui_comp_border);// frame
		mainframe.setLocation(200, 25);
		
		mainframe.add(BorderLayout.CENTER, map);
		mainframe.add(BorderLayout.SOUTH, text);
		mainframe.add(BorderLayout.WEST, stats);

		mainframe.setSize(gui_mainframe_size);

		mainframe.pack();

		makeMenus();
		
		mainframe.setVisible(true);
		
	}// /run

	public void makeMenus() {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		menuBar = new JMenuBar();// create the menu bar

		// build a menu
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
				"The only menu in this program that has menu items");
		menuBar.add(menu);

		windowmenu = new JMenu("Window");
		windowmenu.setMnemonic(KeyEvent.VK_W);
		menuBar.add(windowmenu);

		inventoryMenuButton = new JMenuItem("Inventory");
		inventoryMenuButton.addActionListener((ActionListener) this);
		windowmenu.add(inventoryMenuButton);
		
		armorMenuButton = new JMenuItem("Armor");
		armorMenuButton.addActionListener((ActionListener) this);
		windowmenu.add(armorMenuButton);

		// a group of JMenuItems
		menuItem = new JMenuItem("New Game", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(menuItem);
		menuItem = new JMenuItem("Load Game");
		menu.add(menuItem);

		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("Use Autosaving");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		menu.add(cbMenuItem);

		// a submenu
		menu.addSeparator();
		submenu = new JMenu("Profiles");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("Bluegoo of the Nightfall");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem(
				"Innocentius the Witch Hunter King (gravitate)");
		submenu.add(menuItem);
		menu.add(submenu);

		mainframe.setJMenuBar(menuBar);
	}

	public Level makeTestLevel() {
		GridStack[][] m = new GridStack[50][50];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = new GridStack(new Dirt_Floor(), new Stone());
			}
		}
		return new Level(m);
	}// /makeTestLevel()

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inventoryMenuButton){
			Player.getPlayer().getMy_inventory().display();
		}
		else if(e.getSource() == armorMenuButton){
			Armor a = new Armor();
			a.display();
		}
	}
}
