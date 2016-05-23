package com.gam.thing.inventory;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.gam.gui.Gui;
import com.gam.thing.inventory.Inventoriable.type2;

public class Inventory implements Gui {
	
	ArrayList<Inventoriable> inventory = new ArrayList<Inventoriable>();

	public Inventory() {
		/*//inventory.add(new Equipment("Macklemore's Holey Armor", type2.CHEST, true));
		/inventory.add(new Equipment("Helm of Blind Vision", type2.HEAD, true));
		/inventory.add(new Equipment("Boots of Tiptoeing", type2.BOOTS, true));
		/inventory.add(new Equipment("Pants of No Pockets", type2.LEGGINGS, true));
		/inventory.add(new Equipment("Skirt of Twirliness", type2.LEGGINGS, false));
		/inventory.add(new Equipment("Shoes of Athelete's Foot", type2.BOOTS, false));
		inventory.add(new Potions("Potion of Instant Nothing"));
		inventory.add(new Comestibles("Banana of Apple Tasting"));
		inventory.add(new Spellbooks("Spellbook of Fire Extinguishing"));*/
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
		JTextArea equipments = new JTextArea("Equipment:\n");
		
		JTextArea potions = new JTextArea("Potions:\n");
		JTextArea comestibles = new JTextArea("Comestibles:\n");
		JTextArea spellbooks = new JTextArea("Spellbooks:\n");
		equipments.setEditable(false);
		equipments.setBorder(gui_padding_border);
		potions.setEditable(false);
		potions.setBorder(gui_padding_border);
		comestibles.setEditable(false);
		comestibles.setBorder(gui_padding_border);
		spellbooks.setEditable(false);
		spellbooks.setBorder(gui_padding_border);
		for (Inventoriable i : inventory) {
			if (i instanceof Item) {
			switch (i.getType()) {
			case EQUIPMENT:
				equipments.append("   " + i + "\n");
				break;
			case POTIONS:
				potions.append("   " + i + "\n");
				break;
			case COMESTIBLES:
				comestibles.append("   " + i + "\n");
				break;
			case SPELLBOOKS:
				spellbooks.append("   " + i + "\n");
				break;
			default:
				break;
			}}
		}
		panel.add(equipments);
		panel.add(potions);
		panel.add(comestibles);
		panel.add(spellbooks);
		panel.setVisible(true);
		return panel;
	}

	public void display() {
		JFrame frame = new JFrame("Inventory");
		frame.setLocation(300, 150);
		frame.setSize(300, 500);
		//System.out.println(inventory.get(0));
		JPanel j = sort();
		frame.add(j);
		frame.setVisible(true);
	}
}
