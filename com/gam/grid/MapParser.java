package com.gam.grid;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import com.gam.thing.GridStack;
import com.gam.thing.Player;
import com.gam.thing.ViewableObject;
import com.gam.thing.noclip.Floor;

public class MapParser {

	/**
	 * Takes a file of a certain type(Probably .nfo or .txt) and uses it to
	 * create a Level object. Contains information about how to parse a file,
	 * such as which data goes where.
	 */

	String name = "lvlname";
	String dimensions = "dim";
	int x;
	int y;
	String floor = "deffloor";
	static Level current;
	public GridStack[][] dat;
	Floor f;
	String strLine;
	Class fclass;
	BufferedReader br;

	public Level parse(String n) {
		current = new Level();

		try {
			FileInputStream fstream = new FileInputStream("src/com/gam/levels/"
					+ n);// open file(raw)
			DataInputStream in = new DataInputStream(fstream);// Get the object
																// of
																// DataInputStream
			br = new BufferedReader(new InputStreamReader(in));// make
																// bufferedreader
			strLine = br.readLine();

			if (!validateHeader(strLine))
				return null;

		} catch (Exception e) {// Catch exception if any
			System.err.println("br creation error Error: " + e.getMessage());
		}

		try {
			current.setName(br.readLine());

			strLine = br.readLine();
			x = Integer.parseInt(strLine.substring(0, strLine.indexOf(",")));
			y = Integer.parseInt(strLine.substring(strLine.indexOf(",") + 1,
					strLine.length()));
			dat = new GridStack[y][x];

			fclass = Class.forName("com.gam.thing.noclip." + br.readLine());
			f = (Floor) fclass.newInstance();// this is gonna cause a ton of
												// errors TODO

			if (br.readLine() == "-")
				System.err.println("Error");// check up to this point
		} catch (Exception e) {// Catch exception if any
			System.err.println("Metadata read Error: " + e.getMessage());
		}// /trycatch

		try {
			for (int r = 0; r < y; r++) {
				parseRow(br.readLine(), r);
			}
		} catch (Exception e) {// Catch exception if any
			System.err.println("Lvldata read Error: " + e.getMessage());
		}
		
		current = new Level(dat);

		return current;

	}

	private void parseRow(String text, int rowNum) {
		String temp;
		String celldat = "blank";
		LinkedList<ViewableObject> list;
		for (int i = 0; i < x; i++) {// for each square(gridstack) in the row
			try {
				celldat = text.substring(1, text.indexOf("]"));// celldat is that cell's data
			} catch (Exception e) {
				System.err.println("err");
			}
			list = new LinkedList<ViewableObject>();// create a list for this gridstack
			while (celldat.indexOf(",") > -1) {
				temp = celldat.substring(0, celldat.indexOf(","));// set temp to the first element of the list
				try {
					if (!(temp.equals("Player"))) {
						Class c = Class.forName("com.gam.thing." + temp);
						list.add((ViewableObject) c.newInstance());// add instance
					} else {
						list.add(Player.getPlayer());
					}
					temp = celldat.substring(celldat.indexOf(",") + 1);// set temp to everything the rest of the string
					celldat = temp;// set celldat to temp
				} catch (Exception e) {
					System.err.println("  ParseRow while error: " + e.getMessage());
				}
			}
			if (celldat.length() > 0) {
				try {
					if (!(celldat.equals("Player"))) {
						Class c = Class.forName("com.gam.thing." + celldat);
						list.add((ViewableObject) c.newInstance());// add
																	// instance
					} else {
						list.add(Player.getPlayer());
					}
				} catch (Exception e) {
					System.err.println("ParseRow outofwhile error: " + e.getMessage());
				}
			}
			GridStack tgs;
			try {
				tgs = new GridStack((Floor) fclass.newInstance(), list);
				tgs.setLocation(i, rowNum);
				//tgs.setLevel(getLevel());
				dat[rowNum][i] = tgs;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			temp = text.substring(text.indexOf("]") + 1);// get rid of square's data
			text = temp;
		}
	}
	
	public void serialize() {
		try {
			FileOutputStream fileStream = new FileOutputStream("latest.ser");
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(getLevel());
			os.close();
		} catch(Exception e) {
			System.err.println("Serialization error: " + e.getMessage());
		}
	}

	public boolean validateHeader(String h) {// verifies a file header
		if (!(h.equals("DOCTYPE=GAM APCS DUNGEONCRAWLER"))) {// validate the
																// file format,
																// kinda
			System.err.println("Error:  Invalid level file: Invalid header");
			System.out.println(h);
			return false;
		}
		return true;
	}

	public static Level getLevel() {
		return current;
	}
}
