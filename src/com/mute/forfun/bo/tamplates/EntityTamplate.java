package com.mute.forfun.bo.tamplates;

import java.util.ArrayList;

import com.mute.forfun.utils.StaticInputs;
import com.mute.forfun.utils.TamplateUtil;

import lombok.Getter;
import lombok.Setter;

public class EntityTamplate extends Tamplate {
	
	
	@Getter @Setter
	private ArrayList<PartTamplate> compulsoryParts;
	
	@Getter @Setter
	private ArrayList<PartTamplate> optionalParts;
	
	
	public void loadTamplateByName(String tamplateName, boolean isTest)throws Exception{
		if(isTest && tamplateName.equals(StaticInputs.TEST_TAMPLATE_HUMAN)) {// only human now
			NamingRule nameRule = new NamingRule();
			nameRule.setNamePrefix("人族");
			nameRule.setNameSource(StaticInputs.qianziwen);
			nameRule.setMinCharNum(2);
			nameRule.setMaxCharNum(3);
			this.setNaming(nameRule);
			
			ArrayList<PartTamplate> mustHaveList = new ArrayList<PartTamplate>();
			ArrayList<PartTamplate> niceHaveList = new ArrayList<PartTamplate>();
			mustHaveList.add(TamplateUtil.loadPartTamplate(StaticInputs.PART_SIMULATION_HEAD, true));
			mustHaveList.add(TamplateUtil.loadPartTamplate(StaticInputs.PART_SIMULATION_HAND, true));
			mustHaveList.add(TamplateUtil.loadPartTamplate(StaticInputs.PART_SIMULATION_HAND, true));
			mustHaveList.add(TamplateUtil.loadPartTamplate(StaticInputs.PART_SIMULATION_LEG, true));
			mustHaveList.add(TamplateUtil.loadPartTamplate(StaticInputs.PART_SIMULATION_LEG, true));
			this.setCompulsoryParts(mustHaveList);
			
		}else if(isTest && tamplateName.equals(StaticInputs.TEST_TAMPLATE_ROCK)) {//ROCK
			NamingRule nameRule = new NamingRule();
			nameRule.setNamePrefix("巨岩");
			nameRule.setNameSource(StaticInputs.qianziwen);
			nameRule.setMinCharNum(2);
			nameRule.setMaxCharNum(3);
			this.setNaming(nameRule);
			
			ArrayList<PartTamplate> mustHaveList = new ArrayList<PartTamplate>();
			ArrayList<PartTamplate> niceHaveList = new ArrayList<PartTamplate>();
			mustHaveList.add(TamplateUtil.loadPartTamplate(StaticInputs.PART_SIMULATION_ROCK, true));
			this.setCompulsoryParts(mustHaveList);
			
		}
		
		//===========real template load below===========
	}
	

}
