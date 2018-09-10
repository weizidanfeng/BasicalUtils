package com.mute.forfun.utils.dataOfPartEntity;

import java.util.ArrayList;

import com.mute.forfun.bo.tamplates.EntityTamplate;
import com.mute.forfun.bo.tamplates.NamingRule;
import com.mute.forfun.bo.tamplates.PartTamplate;
import com.mute.forfun.utils.StaticInputs;
import com.mute.forfun.utils.TamplateUtil;

public class TamplateSimulator {
	
	public static EntityTamplate getHumanTamplate()throws Exception{
		EntityTamplate human = new EntityTamplate();
		NamingRule nameRule = new NamingRule();
		nameRule.setNamePrefix("人族");
		nameRule.setNameSource(StaticInputs.qianziwen);
		nameRule.setMinCharNum(2);
		nameRule.setMaxCharNum(3);
		human.setNaming(nameRule);
		ArrayList<PartTamplate> mustHaveList = new ArrayList<PartTamplate>();
		ArrayList<PartTamplate> niceHaveList = new ArrayList<PartTamplate>();
		mustHaveList.add(TamplateUtil.loadPartTamplate(StaticInputs.PART_SIMULATION_HEAD, true));
		mustHaveList.add(TamplateUtil.loadPartTamplate(StaticInputs.PART_SIMULATION_HAND, true));
		mustHaveList.add(TamplateUtil.loadPartTamplate(StaticInputs.PART_SIMULATION_HAND, true));
		mustHaveList.add(TamplateUtil.loadPartTamplate(StaticInputs.PART_SIMULATION_LEG, true));
		mustHaveList.add(TamplateUtil.loadPartTamplate(StaticInputs.PART_SIMULATION_LEG, true));
		
		human.setCompulsoryParts(mustHaveList);
		return human;
		
		
		
	}

}
