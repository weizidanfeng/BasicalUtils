package com.mute.versionT.bo.utils;

import java.util.Random;

public class Mathutil {
	
	public static int randomINT(int from, int to)throws Exception{
		if(from==to) {return from;}
		Random rand = new Random();
		return rand.nextInt(to-from+1)+from;
	}

}
