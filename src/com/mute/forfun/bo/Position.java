package com.mute.forfun.bo;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class Position {
	
	@Getter  @Setter
	private int x;
	
	@Getter  @Setter
	private int y;
	
	@Getter  @Setter
	private ArrayList<Part> parts;
	

}
