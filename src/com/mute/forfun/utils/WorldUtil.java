package com.mute.forfun.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mute.forfun.bo.Entity;
import com.mute.forfun.bo.Position;
import com.mute.forfun.bo.World;

public class WorldUtil {
	
	public static HashMap<String,ArrayList<Entity>> generateXYViewWorld(World myWorld) throws Exception{
		HashMap<String,ArrayList<Entity>> result= new HashMap<String,ArrayList<Entity>>();
		ArrayList<Entity> allObjList = new ArrayList<Entity>();
		if(myWorld.getActorsMap() !=null) {
		  allObjList.addAll(new ArrayList<Entity>(myWorld.getActorsMap().values()));
		}
		if(myWorld.getMapObjectsMap() !=null) {
		  allObjList.addAll(new ArrayList<Entity>(myWorld.getMapObjectsMap().values()));
		}
		if(myWorld.getDeadActorsMap() !=null) {
		  allObjList.addAll(new ArrayList<Entity>(myWorld.getDeadActorsMap().values()));
		}
		  for(Entity i:allObjList) {
			  ArrayList<Entity> tempContent = new ArrayList<Entity>();
			  Position pos= i.getCurrentPos();
			  String key = pos.getX()+","+pos.getY();
			  ArrayList<Entity> value = result.get(key);
			  if(value !=null) {
				  tempContent = value;
			  }
			  tempContent.add(i);
			  result.put(key, tempContent);

		  }
		  
		  return result;
		
	}
	
	public static void generateExcelFromXYView(HashMap<String,ArrayList<Entity>> xyView)throws Exception{
		 Workbook finalResult = WorkbookFactory.create(new File("KhooResult.xlsx"));
		 Sheet sheet = finalResult.createSheet("sheet2");
		 Iterator iter = xyView.entrySet().iterator();
			while (iter.hasNext()) {
				Entry entry = (Entry) iter.next();
				String xy = (String) entry.getKey();
				ArrayList<Entity> contents = (ArrayList<Entity>)entry.getValue();
				String[] pos = xy.split(",");
				Row row = sheet.createRow(Integer.valueOf(pos[1]));
				Cell cell = row.createCell(Integer.valueOf(pos[0]),CellType.STRING);
				StringBuffer contentStr = new StringBuffer();
				for(Entity k:contents) {
					contentStr.append(k.getName());
					contentStr.append("\n");
					}
				cell.setCellValue(contentStr.toString());
				CellStyle style = finalResult.createCellStyle();
				 style.setFillForegroundColor(HSSFColorPredefined.BLUE.getIndex());
				 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				 style.setWrapText(true);
				cell.setCellStyle(style);

				}
			
			 FileOutputStream fOut = new FileOutputStream("xyviewWorld.xlsx"); 
				// 把相应的Excel 工作簿存盘 
				 finalResult.write(fOut); 
				fOut.flush(); 
				// 操作结束，关闭文件 
				fOut.close(); 
				System.out.println("=============fini");
	}

}
