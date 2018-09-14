package com.mute.forfun.main;

import java.util.HashMap;

import com.mute.forfun.bo.InitSeed;
import com.mute.forfun.bo.World;

public class BaseDirector {
	
	private World myWorld;
	
	public static void main(String[] args) throws Exception {
		initWorld();
		
	}
	
	
	public  static void initWorld()throws Exception{
		World newWorld = new World();
		InitSeed seed = new InitSeed();
		seed.setMapX(100);
		seed.setMapY(100);
		HashMap<String,Integer> actorsGroup = new HashMap<String,Integer>();		
		HashMap<String,Integer> mapObjectGroup = new HashMap<String,Integer>();
		
		actorsGroup.put("human", 10);
		mapObjectGroup.put("Rock", 200);
		seed.setActorsGroup(actorsGroup);
		seed.setMapObjectGroup(mapObjectGroup);
		
		newWorld.initWorld(seed);
		this.myWorld = newWorld;
	}


}
