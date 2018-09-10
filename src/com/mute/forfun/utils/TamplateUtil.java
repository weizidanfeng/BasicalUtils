package com.mute.forfun.utils;

import com.mute.forfun.bo.Part;
import com.mute.forfun.bo.tamplates.NamingRule;
import com.mute.forfun.bo.tamplates.PartTamplate;

public class TamplateUtil {
	
	public static PartTamplate loadPartTamplate(String tamplateName, boolean simulation) {
		PartTamplate result = null;
		if(simulation) {
			
			result = loadPartTamplate(tamplateName);
		}
		
		
		return result;
		
	}
	
	
	public static Part initPartByTamplate(PartTamplate partRule) throws Exception {
		Part part=new Part();
		part.setPartName(StringUitl.getNameByNaming(partRule.getNaming()));
		part.setType(partRule.getType());
		part.setHP(MathUtil.randomINT(partRule.getMinHP(), partRule.getMaxHP()));
		part.setFP(MathUtil.randomINT(partRule.getMinFP(), partRule.getMaxFP()));
		part.setSP(MathUtil.randomINT(partRule.getMinSP(), partRule.getMaxSP()));
		part.setRP(MathUtil.randomINT(partRule.getMinRP(), partRule.getMaxRP()));
		
		return part;
	}
	
	
	
	private static PartTamplate loadPartTamplate(String tamplateStr) {
		
		String[] data= tamplateStr.split(",");
		PartTamplate partsRule = new PartTamplate();
		partsRule.setName(data[0]);
		partsRule.setType(Integer.valueOf(data[1]));
		partsRule.setMinHP(Integer.valueOf(data[2]));
		partsRule.setMaxHP(Integer.valueOf(data[3]));
		partsRule.setMinFP(Integer.valueOf(data[4]));
		partsRule.setMaxFP(Integer.valueOf(data[5]));
		partsRule.setMinSP(Integer.valueOf(data[6]));
		partsRule.setMaxSP(Integer.valueOf(data[7]));
		partsRule.setMinRP(Integer.valueOf(data[8]));
		partsRule.setMaxRP(Integer.valueOf(data[9]));
		
		
		NamingRule nameRule = new NamingRule();
		nameRule.setNamePrefix(data[0]);
		nameRule.setNameSource(StaticInputs.qianziwen);
		nameRule.setMinCharNum(2);
		nameRule.setMaxCharNum(3);
		partsRule.setNaming(nameRule);
		
		return partsRule;
		
		
	
		
		
	}

}
