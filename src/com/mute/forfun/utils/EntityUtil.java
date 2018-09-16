package com.mute.forfun.utils;

import com.mute.forfun.bo.Map;
import com.mute.forfun.bo.Position;

public class EntityUtil {
	
	public static Position  move(Position sourcePos, Position targetPos, int speed,Map map)throws Exception{
		Position result = null;
		if(targetPos ==null) {
			targetPos = PosUtil.getRandomPos(map.getX(), map.getY());
		}
		int distance = PosUtil.getDistance(sourcePos, targetPos);
		if(speed >= distance) {
			result =  targetPos;
		}else {
			result = PosUtil.getPosBetweenPoints(sourcePos, targetPos, speed);
		}
		
		return result;
		
		
	}

}
