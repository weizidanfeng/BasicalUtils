package com.mute.forfun.utils;

import java.util.Random;

public class MathUtil {
	
	public static int randomINT(int from, int to)throws Exception{
		if(from==to) {return from;}
		Random rand = new Random();
		return rand.nextInt(to-from+1)+from;
		
		
	}

}
