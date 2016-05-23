package com.gam.thing;

import java.util.ArrayList;
import java.util.LinkedList;

import com.gam.grid.MapParser;
import com.gam.thing.inventory.Inventoriable;
import com.gam.thing.noclip.Floor;

public class GridStack {
	
	private LinkedList<ViewableObject> viewables = new LinkedList<ViewableObject>();
	//public LinkedList<noclips>
	public Floor floor;
	
	public GridStack(Floor f, LinkedList<ViewableObject> list) {
		viewables = list;
		floor = f;
		checkFloor();
	}
	
	public GridStack(Floor f, ViewableObject v) {
		viewables = new LinkedList<ViewableObject>();
		viewables.add(v);
		floor = f;
		checkFloor();
	}
	
	public GridStack() {
		// TODO Auto-generated constructor stub
	}

	public ViewableObject top() {
		if (viewables.isEmpty()) return floor;
		return viewables.getLast();
	}
	
	public Floor floor() {
		return floor;
	}
	public ViewableObject getTop() {
		if (viewables.size() == 0) return floor;
		return viewables.getLast();
	}
	
	public void setFloor(Floor f) {
		floor = f;
	}
	public LinkedList<ViewableObject> getViewables() {
		return viewables;
	}
	
	public void setLocation(int x, int y) {
		floor.xc = x; floor.yc = y;
		for (ViewableObject vo : viewables) {
			vo.xc = x;
			vo.yc = y;
		}
	}
	
	public ArrayList<Inventoriable> getItems(){
		ArrayList<Inventoriable> x = new ArrayList<Inventoriable>();
		for(ViewableObject o: viewables){
			if(o instanceof Inventoriable)
				x.add((Inventoriable) o);
		}
		return x;
	}
	public ArrayList<Inventoriable> removeItems() {
		ArrayList<Inventoriable> x = new ArrayList<Inventoriable>();
		for(ViewableObject o: viewables){
			if(o instanceof Inventoriable)
				x.add((Inventoriable) o);
			o.removeFromLevel(MapParser.getLevel());
		}
		return x;
	}
	
	public void add(ViewableObject top) {
		viewables.add(top);
		//System.out.println("t: " + viewables.size() + " " + this.hashCode());
	}
	
	public ViewableObject removeTop() {
		if (viewables.size() == 0) return floor;
		ViewableObject v = top();
		viewables.removeLast();
		return v;
	}
	
	public ViewableObject removeVO(ViewableObject v) {
		ViewableObject temp = v;
		viewables.remove(v);
		return temp;
	}
	
	public void checkFloor() {//finds a floor in the stack and sets it to floor
		for (ViewableObject v : viewables) {
			if (v instanceof Floor) {
				this.setFloor((Floor) v);
			}
		}
	}
	

}
