package com.mute.forfun.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.UUID;

import com.mute.forfun.bo.tamplates.EntityTamplate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class World {
	private boolean isTest =true;
	
	private Map myMap;
	
	private HashMap<UUID,Entity> actorsMap;
	
	private HashMap<UUID,Entity> mapObjectsMap;
	
	private HashMap<UUID,Entity> deadActorsMap;
	
	private HashMap<Integer,ArrayList<Damage>> damageList;
	
	
	public void initWorld(InitSeed seed) throws Exception{
		//create empty map
		Map map = new Map();
		map.setX(seed.getMapX());
		map.setY(seed.getMapY());
		map.initMap();
		
		//create actor list
		HashMap<UUID,Entity> newActorMap = new HashMap<UUID,Entity>();
		Iterator iter = seed.getActorsGroup().entrySet().iterator();
		while (iter.hasNext()) {
			Entry entry = (Entry) iter.next();
			String tamplateName = (String) entry.getKey();
			EntityTamplate tamplate = new EntityTamplate();
			tamplate.loadTamplateByName(tamplateName,isTest);
			int entityAmount = (Integer) entry.getValue();
			for(int i=0;i<entityAmount;i++) {
				Entity actor = new Entity();
				actor.initEntityByTamplate(tamplate);
				newActorMap.put(actor.getEntityUUID(), actor);
			}
		}
		this.actorsMap = newActorMap;
		
		
			//create mapObject list
			HashMap<UUID,Entity> newobjectMap = new HashMap<UUID,Entity>();
			Iterator iterObj = seed.getMapObjectGroup().entrySet().iterator();
			while (iterObj.hasNext()) {
				Entry entry = (Entry) iterObj.next();
				String tamplateName = (String) entry.getKey();
				EntityTamplate tamplate = new EntityTamplate();
				tamplate.loadTamplateByName(tamplateName,isTest);
				int entityAmount = (Integer) entry.getValue();
				for(int i=0;i<entityAmount;i++) {
					Entity mapObj = new Entity();
					mapObj.initEntityByTamplate(tamplate);
					newActorMap.put(mapObj.getEntityUUID(), mapObj);
				}
		}
			this.mapObjectsMap = newobjectMap;
		
	}
		
	

}
