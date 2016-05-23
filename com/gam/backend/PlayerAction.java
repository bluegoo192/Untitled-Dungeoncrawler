package com.gam.backend;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JComponent;

import com.gam.grid.MapParser;
import com.gam.gui.GameFrame;
import com.gam.gui.StatsView;
import com.gam.gui.StatusView;
import com.gam.thing.Player;
import com.gam.thing.inventory.Inventoriable;
import com.gam.thing.inventory.Item;

public class PlayerAction extends AbstractAction {
	String command;
	JComponent cont;
	public PlayerAction(String str, JComponent c) {
		command = str;
		cont = c;
	}

	public void actionPerformed(ActionEvent e) {
		if (command.equals("pickup")) {
			try {
				ArrayList<Inventoriable> temp = 
						MapParser
						.getLevel()
						.getGridStack(Player.getPlayer().xc,
								Player.getPlayer().yc).removeItems();
				Player.getPlayer().addMy_inventory(temp);
				System.out.println(temp);
				StatusView.getInstance().print("You pick up the " + temp);
			} catch(Exception ex) {
				
			}
		}
		if(command.equals("wait")){
			AIManager.getAIM().nextTurn();
			cont.repaint();
		}
		StatsView s = new StatsView();
		s.repaint();
	}
}
