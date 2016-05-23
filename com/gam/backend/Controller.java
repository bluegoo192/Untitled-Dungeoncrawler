package com.gam.backend;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

	public Controller() {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("hi");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("hi");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("hi");
	}

}
