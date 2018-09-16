package com.mute.versionT.bo;

import java.util.UUID;

import com.mute.versionT.bo.tamplate.EquipmentTamplate;
import com.mute.versionT.bo.utils.Mathutil;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Equipment {
	private UUID equipmentID;
	private String equipmentName;
	
	private int remainAmount;
	private int range;
	private int basicAP;
	
	
	public void initialize(EquipmentTamplate tamplate)throws Exception{
		this.equipmentID = UUID.randomUUID();
		this.equipmentName = tamplate.getName();
		this.remainAmount = Mathutil.randomINT(tamplate.getMinremainAmount(), tamplate.getMaxremainAmount());
		this.range = Mathutil.randomINT(tamplate.getMinrange(), tamplate.getMaxrange());
		this.basicAP=Mathutil.randomINT(tamplate.getMinbasicAP(), tamplate.getMaxbasicAP());
	}

}
