package com.ifpractice.model.vo;

public abstract class SmartPhone implements CellPhone,TouchDisplay{
//	- maker : String // 제조사 정보
//	+ SmartPhone()
//	+ printInformation () : String
//	+ setMaker(maker : String) : void
//	+ getMaker() : String
	private String maker;
	public SmartPhone() {}
	
	public abstract String printInformation();

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}
	
	
}
