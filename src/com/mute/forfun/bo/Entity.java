package com.mute.forfun.bo;

import java.util.ArrayList;

import com.mute.forfun.bo.tamplates.EntityTamplate;
import com.mute.forfun.bo.tamplates.PartTamplate;
import com.mute.forfun.utils.StringUitl;
import com.mute.forfun.utils.TamplateUtil;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



public class Entity {
	
	@Getter  @Setter
	private ArrayList<Part> parts;
	
	@Getter  @Setter
	private Position currentPos;
	
	@Getter  @Setter
	private Position lastPos;
	
	@Getter  @Setter
	private Position nextPos;
	
	
	@Getter  @Setter
	private String name;
	
	
	public void initEntityByTamplate(EntityTamplate tamplate) throws Exception {
		this.name = StringUitl.getNameByNaming(tamplate.getNaming());
		ArrayList<Part> myParts = new ArrayList<Part>();
		ArrayList<PartTamplate> mustParts = tamplate.getCompulsoryParts();
		ArrayList<PartTamplate> niceParts = tamplate.getOptionalParts();
		for (PartTamplate i : mustParts) {
			Part part = TamplateUtil.initPartByTamplate(i);
			myParts.add(part);
        }
		if(niceParts!=null) {
		for (PartTamplate i : niceParts) {
			Part part = TamplateUtil.initPartByTamplate(i);
			myParts.add(part);
        }
		}
		
		this.parts = myParts;
		
	}
	
	public String getEntityDetail() {
		StringBuffer result = new StringBuffer(this.name);
		result.append(" ");
		if(parts !=null) {
			for(Part i:parts) {
				result.append(i.toString());
				result.append(" ");
				
			}
			
		}
		return result.toString();
	}
	

}
