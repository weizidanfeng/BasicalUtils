package com.mute.forfun.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.mute.forfun.bo.Damage;
import com.mute.forfun.bo.Entity;

public class BaseDirector {
	
	public HashMap getNextRoundStatus(ArrayList<Entity> entitys)throws Exception{
		ArrayList<Entity> nextRoundEntity = new ArrayList<Entity>();
		ArrayList<Damage> damages = new ArrayList<Damage>();
		for(Entity i:entitys) {
			if(i.isAlive()) {
				int[] actionList = i.actionDecision();
			}
			
		}
		
		
	}

}
