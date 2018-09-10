package com.mute.forfun.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
public class Part {
	
	@Getter  @Setter
	private String partName;
	
	@Getter  @Setter
	private int HP;//部件耐久
	
	@Getter  @Setter
	private int FP;//功能点数
	
	@Getter  @Setter
	private int SP;//速度点数
	
	@Getter  @Setter
	private int RP;//范围点数
	
	
	@Getter  @Setter
	private int type;//类型

}
