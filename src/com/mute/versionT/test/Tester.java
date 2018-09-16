package com.mute.versionT.test;

import com.mute.versionT.bo.Seed;
import com.mute.versionT.bo.World;

public class Tester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		World myWorld = new World();
		Seed seed = new Seed();
		seed.loadTestData();
		myWorld.initialize(seed);
		

	}
	
	

}
