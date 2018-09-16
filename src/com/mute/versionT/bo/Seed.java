package com.mute.versionT.bo;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Seed {
	
	private String worldNamePrefix;
	private String worldNamePostfix;
	private int mapX;
	private int mapY;
	
	HashMap<String,Integer> actorAmountByTamplate;
	HashMap<String,Integer> mapObjectAmountByTamplate;
	
	public void loadTestData()throws Exception{
		HashMap<String,Integer> temMap = new HashMap<String,Integer>();
		temMap.put("TESTHUMAN", new Integer("10"));
		temMap.put("TESTBEAST", new Integer("10"));
		this.actorAmountByTamplate = temMap;
		this.mapX=100;
		this.mapY=100;
		 temMap = new HashMap<String,Integer>();
		 temMap.put("TESTROCK",new Integer("2000"));
		 temMap.put("TESTBOX",new Integer("500"));
		 this.mapObjectAmountByTamplate = temMap;
		 
		
		
		
	}
	
	

}
