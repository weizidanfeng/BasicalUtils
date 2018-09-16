package com.mute.versionT.bo;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import com.mute.versionT.bo.tamplate.ActorTamplate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class World {
	
	private UUID worldID;
	private String worldName;
	private HashMap<UUID,Actor> aliveActors;
	private HashMap<UUID,Actor> deadBodys;
	private HashMap<UUID,Actor> mapObjects;
	private int mapX;
	private int mapY;
	
	public void initialize(Seed seed)throws Exception{
		this.worldID=UUID.randomUUID();
		this.worldName = "测试世界";
		this.mapX = seed.getMapX();
		this.mapY = seed.getMapY();
		Set<Entry<String, Integer>> entrySet = seed.getActorAmountByTamplate().entrySet();
		HashMap<UUID,Actor> temMap =new HashMap<UUID,Actor>();
		for (Entry<String, Integer> entry : entrySet) {
			String tamplateName = entry.getKey();
			int loopAmount = entry.getValue().intValue();
			ActorTamplate tamplate = new ActorTamplate();
			tamplate.loadTamplateByName(tamplateName);
			for(int i=0;i<loopAmount;i++){
				Actor newActor = new Actor();
				newActor.initialize(tamplate);
				temMap.put(newActor.getActorID(), newActor);		
			}
		}
			this.aliveActors = temMap;
			
			entrySet = seed.getMapObjectAmountByTamplate().entrySet();
			temMap =new HashMap<UUID,Actor>();
			for (Entry<String, Integer> entry : entrySet) {
				String tamplateName = entry.getKey();
				int loopAmount = entry.getValue().intValue();
				ActorTamplate tamplate = new ActorTamplate();
				tamplate.loadTamplateByName(tamplateName);
				for(int i=0;i<loopAmount;i++){
					Actor newActor = new Actor();
					newActor.initialize(tamplate);
					temMap.put(newActor.getActorID(), newActor);		
				}
			}
				this.mapObjects = temMap;
			
			
		}
	}
	
	


