package com.gam.thing.inventory;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.gam.gui.Gui;
import com.gam.thing.inventory.Inventoriable.type2;

public class Armor extends Inventory{
	public Armor() {
	}

	public void add(Inventoriable i) {
		inventory.add(i);
	}

	public void remove(Inventoriable i) {
		inventory.remove(inventory.indexOf(i));
	}

	public JPanel sort() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(gui_comp_border);
		JTextArea equipments = new JTextArea("Head:\n");

		JTextArea chest = new JTextArea("Chest:\n");
		JTextArea leggings = new JTextArea("Leggings:\n");
		JTextArea boots = new JTextArea("Boots:\n");
		equipments.setEditable(false);
		equipments.setBorder(gui_padding_border);
		chest.setEditable(false);
		chest.setBorder(gui_padding_border);
		leggings.setEditable(false);
		leggings.setBorder(gui_padding_border);
		boots.setEditable(false);
		boots.setBorder(gui_padding_border);
		for (Inventoriable i : inventory) {
			if (i instanceof Equipment) {
				switch (((Equipment) i).getType2()) {
				case HEAD:
					if (((Equipment) i).isEquipped())
						equipments.append("   " + i + "\n");
					break;
				case CHEST:
					if (((Equipment) i).isEquipped())
						chest.append("   " + i + "\n");
					break;
				case LEGGINGS:
					if (((Equipment) i).isEquipped())
						leggings.append("   " + i + "\n");
					break;
				case BOOTS:
					if (((Equipment) i).isEquipped())
						boots.append("   " + i + "\n");
					break;
				default:
					break;
				}
			}
		}
		panel.add(equipments);
		panel.add(chest);
		panel.add(leggings);
		panel.add(boots);
		panel.setVisible(true);
		return panel;
	}

	public void display() {
		JFrame frame = new JFrame("Armor");
		frame.setLocation(300, 150);
		frame.setSize(300, 500);
		JPanel j = sort();
		frame.add(j);
		frame.setVisible(true);
	}
}
