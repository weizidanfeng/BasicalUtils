package com.mute.versionT.bo.tamplate;

import com.mute.versionT.bo.utils.Mathutil;
import com.mute.versionT.bo.utils.Statics;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RootTamplate {
	private String namePrefix;
	private String namePostfix;
	private String nameSource =Statics.qianziwen;
	private int minNameAmount=0;
	private int maxNameAmount=0;
	
	
	public String getName()throws Exception{
		StringBuffer result = new StringBuffer();
		result.append(this.namePrefix);
		result.append(" ");
		int nameLength = Mathutil.randomINT(this.minNameAmount, this.maxNameAmount);
		for(int i=0;i<nameLength;i++) {
			int temPos= Mathutil.randomINT(0, nameSource.length()-1);
			result.append(nameSource.substring(temPos, temPos+1));
		}
		result.append(" ");
		result.append(this.namePostfix);
		return result.toString();
	}

}
