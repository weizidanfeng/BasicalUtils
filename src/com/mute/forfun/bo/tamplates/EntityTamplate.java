package com.mute.forfun.bo.tamplates;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class EntityTamplate extends Tamplate {
	
	
	@Getter @Setter
	private ArrayList<PartTamplate> compulsoryParts;
	
	@Getter @Setter
	private ArrayList<PartTamplate> optionalParts;
	

}
