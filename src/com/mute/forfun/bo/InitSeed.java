package com.mute.forfun.bo;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InitSeed {
	
	private int mapX =1000;
	
	private int mapY = 1000;
	
	private HashMap<String,Integer> actorsGroup = new HashMap<String,Integer>();
	
	private HashMap<String,Integer> mapObjectGroup = new HashMap<String,Integer>();
	
	
	

}
