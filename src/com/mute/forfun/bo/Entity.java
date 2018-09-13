package com.mute.forfun.bo;

import java.util.ArrayList;
import java.util.UUID;

import com.mute.forfun.bo.tamplates.EntityTamplate;
import com.mute.forfun.bo.tamplates.PartTamplate;
import com.mute.forfun.utils.MathUtil;
import com.mute.forfun.utils.StaticInputs;
import com.mute.forfun.utils.StringUitl;
import com.mute.forfun.utils.TamplateUtil;

import lombok.Getter;
import lombok.Setter;



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
	
	@Getter
	private UUID entityUUID = UUID.randomUUID();
	
	@Getter @Setter
	private Entity emeny;
	
	
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
	
	public boolean isAlive() {
		boolean aliveFlag = false;
		boolean aliveFlagCtrl = false;
		boolean aliveFlagFatal = false;
		for (Part i : parts) {
			if (i.getType() == StaticInputs.PART_TYPE_CONTROL && i.getHP() > 0) {
				aliveFlagCtrl = true;
				break;
			} else if (i.getType() == StaticInputs.PART_TYPE_FATAL && i.getHP() > 0) {
				aliveFlagFatal = true;
				break;
			}

		}
		aliveFlag = aliveFlagCtrl && aliveFlagFatal;
		return aliveFlag;
	}
	
	public int[] actionDecision()throws Exception {
		int controlPoint =0;
		int result[];
		for(Part i:parts) {
			if(i.getType() == StaticInputs.PART_TYPE_CONTROL && i.getHP() > 0) {
				controlPoint = controlPoint+i.getFP();
			}
		}
		
		int myIQType = GetIQType(controlPoint);
		result = getActionListByIQ(myIQType);
		
		
		return result;
	}
	
	
	private int GetIQType( int controlPoint)throws Exception {
		int result= StaticInputs.IQTYPE_IDIOT;
		if(controlPoint<80) {
			if(MathUtil.isHitPecentage(80)) {
				result= StaticInputs.IQTYPE_IDIOT;
				
			}else {
				result=StaticInputs.IQTYPE_NORMAL;
			}
		}else if(controlPoint<110) {
			if(MathUtil.isHitPecentage(10)) {
				if(MathUtil.isHitPecentage(50)) {
				result = StaticInputs.IQTYPE_IDIOT;
				}else {
					result = StaticInputs.IQTYPE_TALENT;
				}
			}else {
				result= StaticInputs.IQTYPE_NORMAL;
			}
		}else if(controlPoint<160) {

			if(MathUtil.isHitPecentage(10)) {
				if(MathUtil.isHitPecentage(50)) {
				result = StaticInputs.IQTYPE_NORMAL;
				}else {
					result = StaticInputs.IQTYPE_ALIEN;
				}
			}else {
				result= StaticInputs.IQTYPE_TALENT;
			}
		
		}else {
			result = StaticInputs.IQTYPE_GOD;
		}
		
		return result;
	}

	
	private int[] getActionListByIQ(int iq) throws Exception {
		int[] result = new int[10] ;
		for(int i=0;i<10;i++) {
			result[i]=StaticInputs.ACTIONDECISION_DONOTHING;
		}
		//行动槽一共五个，第0个为校准射击对象，其余为行动
		switch (iq) {
		case StaticInputs.IQTYPE_IDIOT:
			if (MathUtil.isHitPecentage(50)) {//50%概率行动，行动中各50%移动或者射击
				if (MathUtil.isHitPecentage(50)) {
					result[0] = StaticInputs.ACTIONDECISION_RANDOMMOVE;
				} else {
					result[0] = StaticInputs.ACTIONDECISION_RANDOMSHOT;
				}
			}
			break;
		case StaticInputs.IQTYPE_NORMAL:
			if(MathUtil.isHitPecentage(70)) {//70%概率行动，行动中10%概率会校准敌人
				if(MathUtil.isHitPecentage(10)){
					result[0] =StaticInputs.ACTIONDECISION_REFRESHEMENYLIST;
				}
				if(MathUtil.isHitPecentage(50)) {
					result[1] = StaticInputs.ACTIONDECISION_RANDOMSHOT;
				}else {result[1] = StaticInputs.ACTIONDECISION_SHOTEMENY;}
				if(MathUtil.isHitPecentage(50)) {
					result[2] = StaticInputs.ACTIONDECISION_RANDOMMOVE;
				}else {result[2] = StaticInputs.ACTIONDECISION_MOVETOEMENY;}
				
			}
			break;
		case StaticInputs.IQTYPE_TALENT:
			if(MathUtil.isHitPecentage(50)) {result[0]=StaticInputs.ACTIONDECISION_REFRESHEMENYLIST;}else {result[0]=StaticInputs.ACTIONDECISION_RANDOMSHOT;}
			if(MathUtil.isHitPecentage(50)) {result[1]=StaticInputs.ACTIONDECISION_FIX;}else {result[0]=StaticInputs.ACTIONDECISION_RANDOMSHOT;}
			if(MathUtil.isHitPecentage(50)) {result[2]=StaticInputs.ACTIONDECISION_REFRESHEMENYLIST;}else {result[0]=StaticInputs.ACTIONDECISION_RANDOMSHOT;}
			if(MathUtil.isHitPecentage(50)) {result[3]=StaticInputs.ACTIONDECISION_MOVETOEMENY;}else {result[0]=StaticInputs.ACTIONDECISION_RANDOMSHOT;}
			if(MathUtil.isHitPecentage(50)) {result[4]=StaticInputs.ACTIONDECISION_SHOTEMENY;}else {result[0]=StaticInputs.ACTIONDECISION_RANDOMSHOT;}
			if(MathUtil.isHitPecentage(50)) {result[5]=StaticInputs.ACTIONDECISION_RANDOMMOVE;}else {result[0]=StaticInputs.ACTIONDECISION_RANDOMSHOT;}
			
			
			
			
			break;
		case StaticInputs.IQTYPE_ALIEN:
			result[0]=StaticInputs.ACTIONDECISION_REFRESHEMENYLIST;
			result[1]=StaticInputs.ACTIONDECISION_FIX;
			result[2]=StaticInputs.ACTIONDECISION_SHOTEMENY;
			result[3]=StaticInputs.ACTIONDECISION_MOVETOEMENY;
			result[4]=StaticInputs.ACTIONDECISION_SHOTEMENY;
			result[5]=StaticInputs.ACTIONDECISION_RANDOMMOVE;
			result[6]=StaticInputs.ACTIONDECISION_RANDOMMOVE;
			result[7]=StaticInputs.ACTIONDECISION_RANDOMMOVE;
			break;
		case StaticInputs.IQTYPE_GOD:
			result[0]=StaticInputs.ACTIONDECISION_REFRESHEMENYLIST;
			result[1]=StaticInputs.ACTIONDECISION_FIX;
			result[2]=StaticInputs.ACTIONDECISION_SHOTEMENY;
			result[3]=StaticInputs.ACTIONDECISION_MOVETOEMENY;
			result[4]=StaticInputs.ACTIONDECISION_SHOTEMENY;
			result[5]=StaticInputs.ACTIONDECISION_RANDOMMOVE;
			result[6]=StaticInputs.ACTIONDECISION_RANDOMMOVE;
			result[7]=StaticInputs.ACTIONDECISION_RANDOMMOVE;
			result[8]=StaticInputs.ACTIONDECISION_FIX;
			result[9]=StaticInputs.ACTIONDECISION_FIX;
			
			break;
		}	
		
		return result;
	}
}
