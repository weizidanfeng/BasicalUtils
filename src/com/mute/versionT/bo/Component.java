package com.mute.versionT.bo;

import java.util.UUID;

import com.mute.versionT.bo.tamplate.ComponentTamplate;
import com.mute.versionT.bo.utils.Mathutil;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Component {
	
	private UUID componentID;
	private String componentName;
	
	private int hp;//heath point
	private int fp;//functional point
	private int cp;//control point
	private int sp;//speed point
	
	public void initialize(ComponentTamplate tamplate)throws Exception{
		this.componentID=UUID.randomUUID();
		this.componentName=tamplate.getName();
		this.hp=Mathutil.randomINT(tamplate.getMinhp(), tamplate.getMaxhp());
		this.fp=Mathutil.randomINT(tamplate.getMinfp(), tamplate.getMaxfp());
		this.cp=Mathutil.randomINT(tamplate.getMincp(), tamplate.getMaxcp());
		this.sp=Mathutil.randomINT(tamplate.getMinsp(), tamplate.getMaxsp());
	}

}
