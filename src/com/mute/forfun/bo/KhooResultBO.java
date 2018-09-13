package com.mute.forfun.bo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KhooResultBO {
	
	private String reportDate;
	
	private String avgExecutionTime;
	
	private String maxExecutionTime;
	
	private String minExecutionTime;
	
	private String noExec;
	
	private String QueryContent;
	
	private String lastExecTime;
	
	
	
	public String printLine() {
		StringBuffer result = new StringBuffer();
		result.append(this.reportDate);
		result.append("|||");
		result.append(this.avgExecutionTime);
		result.append("|||");
		result.append(this.maxExecutionTime);
		result.append("|||");
		result.append(this.minExecutionTime);
		result.append("|||");
		result.append(this.noExec);
		result.append("|||");
		result.append(this.QueryContent);
		result.append("|||");
		result.append(this.lastExecTime);
		result.append("\n");
		
		return result.toString();
		
	}
	

}
