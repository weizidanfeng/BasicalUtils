package com.mute.forfun.bo;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Damage {
	
	private UUID damagedEntityID;
	
	private UUID damagingEntityID;
	
	private UUID damangedPartID;
	private UUID damanagingPartID;

}
