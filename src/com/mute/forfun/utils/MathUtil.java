package com.mute.forfun.utils;

import java.util.Random;

public class MathUtil {
	
	public static int randomINT(int from, int to)throws Exception{
		if(from==to) {return from;}
		Random rand = new Random();
		return rand.nextInt(to-from+1)+from;
		
		
	}
	
	public static boolean isHitPecentage(int pecentage)throws Exception{
		int randomInt  = randomINT(0,100);
		boolean result=false;
		if(pecentage>randomInt) {
			result = true;
		}
		return result;
		
	}

}
