package com.mute.forfun.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

}
