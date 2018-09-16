package com.mute.forfun.bo;

import java.util.HashMap;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class Position {
	
	@Getter  @Setter
	private int x;
	
	@Getter  @Setter
	private int y;
	

	public String getTxtXY() {
		return "("+x+","+y+")";
	}


	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	

}
