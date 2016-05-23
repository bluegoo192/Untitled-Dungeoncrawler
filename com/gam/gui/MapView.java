package com.gam.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import com.gam.backend.Direction;
import com.gam.backend.PlayerAction;
import com.gam.backend.PlayerMoveAction;
import com.gam.grid.Level;
import com.gam.grid.MapParser;

public class MapView extends JPanel implements Gui {

	/**
	 * This is an extended version of Michael's Grid class. Unlike the Grid
	 * class, it does not run in it's own frame. It is a component which can be
	 * embedded into a larger gui.
	 */

	JPopupMenu Pmenu = new JPopupMenu();
	Level level;
	JScrollPane spane;
	Action w, a, s, d, p, stop;

	public boolean isFocusable() {
		return true;
	}

	public MapView(Level arg) {
		level = arg;
		draw(level);
	}

	public MapView(String lvlname) {
		MapParser lvlmaker = new MapParser();
		level = lvlmaker.parse(lvlname);
		setFocusable(true);
		putKeys();
		draw(level);
	}

	public void draw(Level m) {
		spane = new JScrollPane(level);
		spane.setPreferredSize(gui_map_size);
		this.add(spane);
		this.setBorder(gui_comp_border);
	}

	public void putKeys() {
		d = new PlayerMoveAction(Direction.EAST, this);
		a = new PlayerMoveAction(Direction.WEST, this);
		w = new PlayerMoveAction(Direction.NORTH, this);
		s = new PlayerMoveAction(Direction.SOUTH, this);
		p = new PlayerAction("pickup", this);
		stop = new PlayerAction("wait", this);
		getInputMap().put(KeyStroke.getKeyStroke("PERIOD"), "stop");
		getInputMap().put(KeyStroke.getKeyStroke("D"), "dpress");
		getInputMap().put(KeyStroke.getKeyStroke("A"), "apress");
		getInputMap().put(KeyStroke.getKeyStroke("W"), "wpress");
		getInputMap().put(KeyStroke.getKeyStroke("S"), "spress");
		getInputMap().put(KeyStroke.getKeyStroke("P"), "ppress");
		getActionMap().put("ppress", p);
		getActionMap().put("stop", stop);
		getActionMap().put("wpress", w);
		getActionMap().put("spress", s);
		getActionMap().put("dpress", d);
		getActionMap().put("apress", a);
	}
}
