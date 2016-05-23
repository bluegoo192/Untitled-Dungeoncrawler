package com.gam.backend;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;

import com.gam.grid.MapParser;
import com.gam.gui.StatsView;
import com.gam.thing.Player;

public class PlayerMoveAction extends AbstractAction {
	
	Direction direction;
	JComponent cont;

	public PlayerMoveAction(Direction d, JComponent jc) {
		direction = d;
		cont = jc;
	}

	public void actionPerformed(ActionEvent e) {
		Player.getPlayer().move(direction, MapParser.getLevel());
		AIManager.getAIM().nextTurn();
		cont.repaint();
		StatsView s = new StatsView();
		s.repaint();
	}

}
