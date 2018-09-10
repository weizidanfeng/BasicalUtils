package com.mute.forfun.main;

import com.mute.forfun.bo.Entity;
import com.mute.forfun.bo.tamplates.EntityTamplate;
import com.mute.forfun.utils.FileUtil;
import com.mute.forfun.utils.dataOfPartEntity.TamplateSimulator;

public class MainTester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		EntityTamplate humanTamplate = TamplateSimulator.getHumanTamplate();
		FileUtil.createFile("test.txt");
		for(int i=0;i<100;i++) {
			Entity aHuman = new Entity();
			aHuman.initEntityByTamplate(humanTamplate);
			System.out.println(aHuman.getEntityDetail());
			FileUtil.writeALine("test.txt", aHuman.getName());
			
		}
		

	}

}
