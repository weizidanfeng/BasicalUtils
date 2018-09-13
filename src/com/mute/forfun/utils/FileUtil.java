package com.mute.forfun.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtil {
	
	public static final void createFile(String fileNameWithPath)throws Exception{
		Path fpath=Paths.get(fileNameWithPath);
		if(!Files.exists(fpath)) {
           
                Files.createFile(fpath);
            } 
	}
	
	
	public static final void writeALine(String fileNameWithPath, String content )throws Exception{
		FileWriter fw = new FileWriter(fileNameWithPath, true);
		BufferedWriter bfw=new BufferedWriter(fw);
        bfw.write(content);
        bfw.newLine();
        bfw.flush();
        bfw.close();
	}
	
	public static final ArrayList<File> getExcelFileList()throws Exception{
		File file = new File("excel_import");
	    File[] tempList = file.listFiles();
	    ArrayList<File> files = new ArrayList<File>();

	    for (int i = 0; i < tempList.length; i++) {
	        if (tempList[i].isFile()) {
//	              
	            files.add(tempList[i]);
	            System.out.println(tempList[i].getName());
	        }
	        if (tempList[i].isDirectory()) {
//	              
	        }
	    }
	    return files;
		
	}

}
