package com.mute.forfun.bo;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

public class Map {

	
	
	@Getter  @Setter
	private HashMap<String,Position> posMap = new HashMap<String,Position>();
	
	@Getter  @Setter
	private int x;
	
	@Getter  @Setter
	private int y;
	
	
	
	
	public void initMap()throws Exception{
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				Position myPos = new Position(i,j);
				posMap.put(String.valueOf(i)+String.valueOf(j), myPos);
			}
		}
	}
}
