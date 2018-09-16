package com.mute.versionT.bo.utils;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XMLutil {
	
	public static Document parse(String fileName) throws DocumentException {
		
		File f = new File("resource\\tamplate\\"+fileName+".xml");  
        SAXReader reader = new SAXReader();
        Document document = reader.read(f);
        return document;
    }

}
