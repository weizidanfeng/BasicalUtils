package com.mute.forfun.main;

import java.util.ArrayList;

import com.mute.forfun.bo.Position;
import com.mute.forfun.utils.MathUtil;
import com.mute.forfun.utils.PosUtil;

public class tempTester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		testPos();
		//testDis();

	}
	
	
	private static void testDis()throws Exception{
		Position a = new Position(10,10);
		Position b = new Position(10,12);
		
		int x = Math.abs(a.getX() - b.getX());
		int y = Math.abs(a.getY() - b.getY());
		System.out.println(PosUtil.getDistance(a, b));
	} 
	
	
	private static void testPos()throws Exception{
		ArrayList<Position> posList = new ArrayList<Position>();
		for(int i=0;i<50;i++) {
			Position pos = PosUtil.getRandomPos(100, 100);
			posList.add(pos);			
		}
		for(int i=0;i<20;i++) {
			Position pos1 = posList.get(MathUtil.randomINT(0, posList.size()-1));
			Position pos2 = posList.get(MathUtil.randomINT(0, posList.size()-1));
			int dis = PosUtil.getDistance(pos1, pos2);
			int speed1=dis>2?dis-2:1;
			int speed2=dis;
			int speed3=dis+6;
			
			Position re1 = PosUtil.getPosBetweenPoints(pos1, pos2, speed1);
			Position re2 = PosUtil.getPosBetweenPoints(pos1, pos2, speed2);
			Position re3 = PosUtil.getPosBetweenPoints(pos1, pos2, speed3);
			
			System.out.println(pos1.getTxtXY()+"  "+pos2.getTxtXY()+": distance("+dis+")  Speed1("+speed1+")-"+re1.getTxtXY()+"- Speed2("+speed2+")-"+re2.getTxtXY()+"-  Speed3("+speed3+")-"+re3.getTxtXY());
		}
		
	}

}
