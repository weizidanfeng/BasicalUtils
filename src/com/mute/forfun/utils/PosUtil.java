package com.mute.forfun.utils;

import com.mute.forfun.bo.Position;

public class PosUtil {
	public static Position getRandomPos(int mapX, int mapY)throws Exception{
		Position pos= new Position(MathUtil.randomINT(0, mapX),MathUtil.randomINT(0, mapY));

		return pos;
	}
	
	public static int getDistance(Position a, Position b) throws Exception{
		int x = Math.abs(a.getX() - b.getX());
		int y = Math.abs(a.getY() - b.getY());
		return x+y;
	}
	
	public static Position getPosBetweenPoints(Position sourcePos, Position targetPos,int speed)throws Exception{
		if(speed>=getDistance(sourcePos,targetPos)) {return targetPos;}
		Position result=new Position(sourcePos.getX(),sourcePos.getY());
		for(int i=0;i<speed;i++) {
			result = babyStepMover(result,targetPos);
			
		}
		return result;
		
		
	}
	
	public static Position babyStepMover(Position a, Position b)throws Exception{
		if(a.getX() ==b.getX() && a.getY() == b.getY()) {return a;}
		Position result = new Position(a.getX(),a.getY());
		boolean isGoX =true;
		if(MathUtil.isHitPecentage(50)) {
			isGoX =false;
		}
		if(a.getX()==b.getX()) {
			isGoX=false;
		}
		if(a.getY()==b.getY()) {
			isGoX =true;
		}
		
		if(isGoX) {
			if((b.getX()-a.getX())>0){
				result.setX(result.getX()+1);
			}else {
				result.setX(result.getX()-1);
			}
		}else {
			if((b.getY()-a.getY())>0){
				result.setY(result.getY()+1);
			}else {
				result.setY(result.getY()-1);
			}
			
		}
		return result;
	}

}
