package com.mute.versionT.bo.tamplate;

import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import com.mute.versionT.bo.utils.XMLutil;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EquipmentTamplate extends RootTamplate {
	private int minremainAmount;
	private int minrange;
	private int minbasicAP;
	
	private int maxremainAmount;
	private int maxrange;
	private int maxbasicAP;
	
	public void loadTamplateByName(String tamplateName)throws Exception{
		Document doc = XMLutil.parse(tamplateName);
		Element root = doc.getRootElement();

	    // iterate through child elements of root
	    for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
	        Element element = it.next();
	        if("minremainAmount".equals(element.getName())) {
	        	this.minremainAmount=new Integer(element.getStringValue()).intValue();
	        }else if("minrange".equals(element.getName())) {
	        	this.minrange=new Integer(element.getStringValue()).intValue();
	        }else if("minbasicAP".equals(element.getName())) {
	        	this.minbasicAP = new Integer(element.getStringValue()).intValue();
	        }else if("maxremainAmount".equals(element.getName())) {
	        	this.maxremainAmount=new Integer(element.getStringValue()).intValue();
	        }else if("maxrange".equals(element.getName())) {
	        	this.maxrange=new Integer(element.getStringValue()).intValue();
	        }else if("maxbasicAP".equals(element.getName())) {
	        	this.maxbasicAP = new Integer(element.getStringValue()).intValue();
	        }
	        
	    }




		
	}
	
	
}
