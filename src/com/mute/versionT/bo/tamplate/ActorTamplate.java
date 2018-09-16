package com.mute.versionT.bo.tamplate;

import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;

import com.mute.versionT.bo.utils.XMLutil;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ActorTamplate extends RootTamplate {
	

	private int minmapX=0;
	private int minmapY=0;
	private int maxmapX=0;
	private int maxmapY=0;
	
	private HashMap<String,Integer> majorPartAmountByComponentTamplateName;
	private HashMap<String,Integer> functionalPartAmountByComponentTamplateName;
	private HashMap<String,Integer> movementPartAmountByComponentTamplateName;
	private HashMap<String,Integer> equipmentAmountByComponentTamplateName;
	
	public void loadTamplateByName(String tamplateName)throws Exception{
		

		Document doc = XMLutil.parse(tamplateName);
		Element root = doc.getRootElement();
		String CFG_majorPartAmountByComponentTamplateName="";
		String CFG_functionalPartAmountByComponentTamplateName="";
		String CFG_movementPartAmountByComponentTamplateName="";
		String CFG_equipmentAmountByComponentTamplateName="";
		 String[] major= {};
		 String[] func = {};
		 String[] move= {};
		 String[] equipment= {};
		 

	    // iterate through child elements of root
	    for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
	        Element element = it.next();
	        if("minmapX".equals(element.getName())) {
	        	this.minmapX=new Integer(element.getStringValue()).intValue();
	        }else if("minmapY".equals(element.getName())) {
	        	this.minmapY=new Integer(element.getStringValue()).intValue();
	        }else if("maxmapX".equals(element.getName())) {
	        	this.maxmapX = new Integer(element.getStringValue()).intValue();
	        }else if("maxmapY".equals(element.getName())) {
	        	this.maxmapY=new Integer(element.getStringValue()).intValue();
	        }else if("majorPartAmountByComponentTamplateName".equals(element.getName())) {
	        	CFG_majorPartAmountByComponentTamplateName=element.getStringValue();
	        }else if("functionalPartAmountByComponentTamplateName".equals(element.getName())) {
	        	CFG_functionalPartAmountByComponentTamplateName=element.getStringValue();
	        }else if("movementPartAmountByComponentTamplateName".equals(element.getName())) {
	        	CFG_movementPartAmountByComponentTamplateName=element.getStringValue();
	        }else if("equipmentAmountByComponentTamplateName".equals(element.getName())) {
	        	CFG_equipmentAmountByComponentTamplateName=element.getStringValue();
	        }
	}
	    if(CFG_majorPartAmountByComponentTamplateName !=null && !"".equals(CFG_majorPartAmountByComponentTamplateName)) {
	    major = CFG_majorPartAmountByComponentTamplateName.split(",");
	    }
	    if(CFG_functionalPartAmountByComponentTamplateName !=null && !"".equals(CFG_functionalPartAmountByComponentTamplateName)) {
	    func = CFG_functionalPartAmountByComponentTamplateName.split(",");
	    }
	    if(CFG_movementPartAmountByComponentTamplateName !=null && !"".equals(CFG_movementPartAmountByComponentTamplateName)) {
	     move = CFG_movementPartAmountByComponentTamplateName.split(",");
	    }
	    if(CFG_equipmentAmountByComponentTamplateName !=null && !"".equals(CFG_equipmentAmountByComponentTamplateName)) {
	    equipment = CFG_equipmentAmountByComponentTamplateName.split(",");
	    }
	    
	     HashMap<String,Integer> temMap = new  HashMap<String,Integer>();
	     
	    for(int i=0;i<major.length;i=i+2) {
	    	String name = major[i];
	    	Integer amount  = new Integer(major[i+1]);
	    	temMap.put(name, amount);    	
	    }
	    this.majorPartAmountByComponentTamplateName = temMap;
	    
	    temMap = new  HashMap<String,Integer>();
	    System.out.println(func.length+"  "+func[0]);
	    for(int i=0;i<func.length;i=i+2) {
	    	String name = func[i];
	    	Integer amount  = new Integer(func[i+1]);
	    	temMap.put(name, amount);    	
	    	
	    }
	    this.functionalPartAmountByComponentTamplateName = temMap;
	    
	    temMap = new  HashMap<String,Integer>();
	    for(int i=0;i<move.length;i=i+2) {
	    	String name = move[i];
	    	Integer amount  = new Integer(move[i+1]);
	    	temMap.put(name, amount);    	
	    }
	    this.movementPartAmountByComponentTamplateName = temMap;
	    
	    temMap = new  HashMap<String,Integer>();
	    for(int i=0;i<equipment.length;i=i+2) {
	    	String name = equipment[i];
	    	Integer amount  = new Integer(equipment[i+1]);
	    	temMap.put(name, amount);    	
	    }
	    this.equipmentAmountByComponentTamplateName = temMap;
	    
	    
	    
	


}
}
