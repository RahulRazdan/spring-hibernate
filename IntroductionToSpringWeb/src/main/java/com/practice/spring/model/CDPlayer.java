package com.practice.spring.model;

import com.practice.spring.api.Player;

public class CDPlayer implements Player{

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	} 
	
	public CDPlayer() {
		this.type="basic";
	}
	
	public CDPlayer(String type) {
		this.type=type;
	}

	@Override
	public String getPlayerType() {
		return getType();
	}
}
