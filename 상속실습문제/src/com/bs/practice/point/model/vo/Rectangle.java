package com.bs.practice.point.model.vo;

public class Rectangle extends Point{
//	- width : int
//	- height : int
//	+ Rectangle()
//	+ Rectangle(x:int, y:int, width:int, height:int)
//	+ getter/setter()
//	+ toString() : String
	
	private int width ;
	private int height ;
	public Rectangle() {
	
	}
	
	public Rectangle(int x, int y, int width, int height) {
		super(x,y);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String toString() {
		return width + " " + height + " " + getX() + " " + getY();
	}
	
}
