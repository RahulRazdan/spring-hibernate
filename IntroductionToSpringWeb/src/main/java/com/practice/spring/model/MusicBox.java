package com.practice.spring.model;

public class MusicBox {

	private String type;

	public String getType() {
		return type;
	}

	public String getArguementType(int parameter){
		return "Arguement Tested";
	}
	public void setType(String type) {
		this.type = type;
	}
 
	public MusicBox() {
		this.type="advance";
	}
	
	public MusicBox(String type) {
		this.type=type;
	}
	
}
