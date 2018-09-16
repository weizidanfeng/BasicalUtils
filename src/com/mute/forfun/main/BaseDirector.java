package com.mute.forfun.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.UUID;

import com.mute.forfun.bo.Entity;
import com.mute.forfun.bo.InitSeed;
import com.mute.forfun.bo.World;
import com.mute.forfun.utils.StaticInputs;
import com.mute.forfun.utils.WorldUtil;

public class BaseDirector {
	
	private static World currentWorld;
	
	public static void main(String[] args) throws Exception {
		initWorld();
		HashMap<String,ArrayList<Entity>> map = WorldUtil.generateXYViewWorld(currentWorld);
		WorldUtil.generateExcelFromXYView(map);
		
	}
	
	
	public  static void initWorld()throws Exception{
		World newWorld = new World();
		InitSeed seed = new InitSeed();
		seed.setMapX(100);
		seed.setMapY(100);
		HashMap<String,Integer> actorsGroup = new HashMap<String,Integer>();		
		HashMap<String,Integer> mapObjectGroup = new HashMap<String,Integer>();
		
		actorsGroup.put(StaticInputs.TEST_TAMPLATE_HUMAN, 10);
		mapObjectGroup.put(StaticInputs.TEST_TAMPLATE_ROCK, 200);
		seed.setActorsGroup(actorsGroup);
		seed.setMapObjectGroup(mapObjectGroup);
		
		newWorld.initWorld(seed);
		myWorld = newWorld;
	}


	
	public static World getNextRound()throws Exception{
		World newWorld=new World();
		Iterator iterObj = currentWorld.getActorsMap().entrySet().iterator();
		while (iterObj.hasNext()) {
			Entry entry = (Entry) iterObj.next();
			UUID actorUUID = (UUID) entry.getKey();
			Entity actor = (Entity)entry.getValue();
			int[] actionList = actor.actionDecision();
			if(actionList[0] == StaticInputs.ACTIONDECISION_DONOTHING) {continue;}
			for(int i=0;i<actionList.length;i++) {
				
			}

			}
		
	}
}
