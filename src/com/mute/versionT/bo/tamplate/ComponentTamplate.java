package com.mute.versionT.bo.tamplate;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;

import com.mute.versionT.bo.utils.XMLutil;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ComponentTamplate extends RootTamplate {
	
	private int minhp;//heath point
	private int minfp;//functional point
	private int mincp;//control point
	private int minsp;//speed point
	
	private int maxhp;//heath point
	private int maxfp;//functional point
	private int maxcp;//control point
	private int maxsp;//speed point
	
	public void loadTamplateByName(String tamplateName)throws Exception{
		

		Document doc = XMLutil.parse(tamplateName);
		Element root = doc.getRootElement();

	    // iterate through child elements of root
	    for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
	        Element element = it.next();
	        if("minhp".equals(element.getName())) {
	        	this.minhp=new Integer(element.getStringValue()).intValue();
	        }else if("minfp".equals(element.getName())) {
	        	this.minfp=new Integer(element.getStringValue()).intValue();
	        }else if("mincp".equals(element.getName())) {
	        	this.mincp = new Integer(element.getStringValue()).intValue();
	        }else if("minsp".equals(element.getName())) {
	        	this.minsp=new Integer(element.getStringValue()).intValue();
	        }else if("maxhp".equals(element.getName())) {
	        	this.maxhp=new Integer(element.getStringValue()).intValue();
	        }else if("maxfp".equals(element.getName())) {
	        	this.maxfp = new Integer(element.getStringValue()).intValue();
	        }else if("maxcp".equals(element.getName())) {
	        	this.maxcp = new Integer(element.getStringValue()).intValue();
	        }else if("maxsp".equals(element.getName())) {
	        	this.maxsp = new Integer(element.getStringValue()).intValue();
	        }
	        
	    }
	}
	
	

}
