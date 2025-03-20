package com.bs.practice.point.model.vo;

public class Point {
//	- x : int
//	- y : int
//	+ Point()
//	+ Point(x:int, y:int)
//	+ getter/setter()
//	+ toString() : String
	private int x;
	private int y;
	public Point() {
		// TODO Auto-generated constructor stub
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return x + " " + y;
	}
	
}
