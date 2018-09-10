package com.mute.forfun.utils;

import com.mute.forfun.bo.tamplates.NamingRule;

public class StringUitl {
	
	
	
	public static String getAcharFromStr(String str)throws Exception{
		int rdm = MathUtil.randomINT(0, str.length()-1);
		return str.substring(rdm, rdm+1);
		
		
		
	}
	
	public static String getNameByNaming(NamingRule rule)throws Exception{
		StringBuffer result = new StringBuffer("无名");
		if(rule !=null) {
			result = new StringBuffer(rule.getNamePrefix());
			result.append(" ");
			int charNum = MathUtil.randomINT(rule.getMinCharNum(), rule.getMaxCharNum());
			for(int i=0;i<charNum;i++) {
				result.append(getAcharFromStr(rule.getNameSource()));
				
			}
			
			
		}
		
		
		
		return result.toString();
		
	}

}
