package com.mute.versionT.bo;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import com.mute.versionT.bo.tamplate.ActorTamplate;
import com.mute.versionT.bo.tamplate.ComponentTamplate;
import com.mute.versionT.bo.tamplate.EquipmentTamplate;
import com.mute.versionT.bo.utils.Mathutil;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Actor {
	
	private UUID actorID;
	private String actorName;
	private HashMap<UUID,Component> majorParts;
	private HashMap<UUID,Component> functionalParts;
	private HashMap<UUID,Component> movementParts;
	private HashMap<UUID,Equipment> equipments;
	private int mapX=0;
	private int mapY=0;
	
	public void initialize(ActorTamplate tamplate)throws Exception{
		this.actorID=UUID.randomUUID();
		this.actorName=tamplate.getName();
		this.mapX = Mathutil.randomINT(tamplate.getMinmapX(), tamplate.getMaxmapX());
		this.mapY = Mathutil.randomINT(tamplate.getMinmapY(), tamplate.getMaxmapY());

		HashMap<String,Integer> majorPart =tamplate.getMajorPartAmountByComponentTamplateName();
		HashMap<String,Integer> functionalPart=tamplate.getFunctionalPartAmountByComponentTamplateName();
		HashMap<String,Integer> movementPart=tamplate.getMovementPartAmountByComponentTamplateName();
		HashMap<String,Integer> equipment=tamplate.getEquipmentAmountByComponentTamplateName();
		
		HashMap<UUID,Component> tempResultMap = new HashMap<UUID,Component>();
		//create major list
		Set<Entry<String, Integer>> entrySet = majorPart.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			String tamplateName = entry.getKey();
			int loopAmount = entry.getValue().intValue();
			ComponentTamplate temTamplate = new ComponentTamplate();
			temTamplate.loadTamplateByName(tamplateName);
			for(int i=0;i<loopAmount;i++) {
				Component newPart = new Component();
				newPart.initialize(temTamplate);
				tempResultMap.put(newPart.getComponentID(), newPart);
				}
			}
		this.majorParts = tempResultMap;
		
		
		//create functionalPart
		tempResultMap = new HashMap<UUID,Component>();
		entrySet = functionalPart.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			String tamplateName = entry.getKey();
			int loopAmount = entry.getValue().intValue();
			ComponentTamplate temTamplate = new ComponentTamplate();
			temTamplate.loadTamplateByName(tamplateName);
			for(int i=0;i<loopAmount;i++) {
				Component newPart = new Component();
				newPart.initialize(temTamplate);
				tempResultMap.put(newPart.getComponentID(), newPart);
				}
			}
		this.functionalParts = tempResultMap;
		
		//create movePart
		HashMap<UUID,Equipment> temp2ResultMap = new HashMap<UUID,Equipment>();
				entrySet = equipment.entrySet();
				for (Entry<String, Integer> entry : entrySet) {
					String tamplateName = entry.getKey();
					int loopAmount = entry.getValue().intValue();
					EquipmentTamplate temTamplate = new EquipmentTamplate();
					temTamplate.loadTamplateByName(tamplateName);
					for(int i=0;i<loopAmount;i++) {
						Equipment newPart = new Equipment();
						newPart.initialize(temTamplate);
						temp2ResultMap.put(newPart.getEquipmentID(), newPart);
						}
					}
				this.equipments = temp2ResultMap;
				
				
				//create equipmentPart
				tempResultMap = new HashMap<UUID,Component>();
				entrySet = movementPart.entrySet();
				for (Entry<String, Integer> entry : entrySet) {
					String tamplateName = entry.getKey();
					int loopAmount = entry.getValue().intValue();
					ComponentTamplate temTamplate = new ComponentTamplate();
					temTamplate.loadTamplateByName(tamplateName);
					for(int i=0;i<loopAmount;i++) {
						Component newPart = new Component();
						newPart.initialize(temTamplate);
						tempResultMap.put(newPart.getComponentID(), newPart);
						}
					}
				this.movementParts = tempResultMap;
		
	}
	

}
