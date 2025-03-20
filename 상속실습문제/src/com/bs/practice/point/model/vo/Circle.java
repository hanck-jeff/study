package com.bs.practice.point.model.vo;

public class Circle extends Point{
//	- radius : int
//	+ Circle()
//	+ Circle(x:int, y:int, radius:int)
//	+ getter/setter()
//	+ toString() : String
	
	private int radius;
	
	public Circle() {
		// TODO Auto-generated constructor stub
	}
	
	public Circle(int x, int y, int radius) {
		super(x,y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String toString() {
		return radius + " " + getX() + " " + getY();
	}
	
	
}
