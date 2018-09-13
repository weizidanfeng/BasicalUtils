package com.mute.forfun.bo;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class Map {

	
	
	@Getter  @Setter
	private ArrayList<Position> pos;
	
	@Getter  @Setter
	private int x;
	
	@Getter  @Setter
	private int y;
	
	
	
	
	public void initMap()throws Exception{
		ArrayList<Position> myPos=new ArrayList<Position>();
		
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				Position aPos = new Position();
				aPos.setX(i);
				aPos.setY(j);
				myPos.add(aPos);
			}
		}
		this.pos=myPos;
		
	}
}
