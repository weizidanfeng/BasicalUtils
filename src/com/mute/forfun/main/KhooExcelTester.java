package com.mute.forfun.main;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mute.forfun.bo.KhooResultBO;
import com.mute.forfun.utils.FileUtil;

public class KhooExcelTester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 ArrayList<File> files = FileUtil.getExcelFileList();
		 ArrayList<KhooResultBO> khooList =new ArrayList<KhooResultBO>();
		
		 DataFormatter dataFormatter = new DataFormatter();
		 for(File i:files) {
			 Workbook workbook = WorkbookFactory.create(i);
			 String fileName = i.getName();
			 for(Sheet sheet: workbook) {	
				 boolean newRecordFlag=true;
				 for (Row row: sheet) {
					 KhooResultBO bo=new KhooResultBO();
					 if(sheet.getSheetName().contains("1") && row.getRowNum()<4) {continue;}
					 String cell0 = dataFormatter.formatCellValue(row.getCell(0));
					 if(cell0 !=null && cell0.length()>0 ){newRecordFlag =true;}else {newRecordFlag =false;}
					 if(newRecordFlag) {//first line	
						 bo.setAvgExecutionTime(dataFormatter.formatCellValue(row.getCell(0)));
						 bo.setMaxExecutionTime(dataFormatter.formatCellValue(row.getCell(1)));
						 bo.setMinExecutionTime(dataFormatter.formatCellValue(row.getCell(2)));
						 bo.setNoExec(dataFormatter.formatCellValue(row.getCell(3)));
						 bo.setQueryContent(dataFormatter.formatCellValue(row.getCell(4)));
						 bo.setLastExecTime(dataFormatter.formatCellValue(row.getCell(5)));
						 bo.setReportDate(fileName);
						 khooList.add(bo);
						 
						 

			            }else {
			            	bo = khooList.get(khooList.size()-1);
							 bo.setAvgExecutionTime(bo.getAvgExecutionTime()+" "+dataFormatter.formatCellValue(row.getCell(0)));
							 bo.setMaxExecutionTime(bo.getMaxExecutionTime()+" "+dataFormatter.formatCellValue(row.getCell(1)));
							 bo.setMinExecutionTime(bo.getMinExecutionTime()+" "+dataFormatter.formatCellValue(row.getCell(2)));
							 bo.setNoExec(bo.getNoExec()+" "+dataFormatter.formatCellValue(row.getCell(3)));
							 bo.setQueryContent(bo.getQueryContent()+" "+dataFormatter.formatCellValue(row.getCell(4)));
							 bo.setLastExecTime(bo.getLastExecTime()+" "+dataFormatter.formatCellValue(row.getCell(5)));
							 khooList.remove(khooList.size()-1);
							 bo.setReportDate(fileName);
							 khooList.add(bo);
							 
			            	
			            }
			            
					 System.out.println(bo.printLine());
					 
			        }
		        }
		 }
		 
		 Workbook finalResult = WorkbookFactory.create(new File("KhooResult.xlsx"));
		 Sheet sheet = finalResult.createSheet("all");
		 int i=1;
		 Row frow = sheet.createRow(0);
		 Cell fcell0 = frow.createCell(0);
		 Cell fcell1 = frow.createCell(1);
		 Cell fcell2 = frow.createCell(2);
		 Cell fcell3 = frow.createCell(3);
		 Cell fcell4 = frow.createCell(4);
		 Cell fcell5 = frow.createCell(5);
		 Cell fcell6 = frow.createCell(6);
		 Cell fcell7 = frow.createCell(7);
		 
		 fcell0.setCellValue("Report time");
		 fcell1.setCellValue("Avg Exec");
		 fcell2.setCellValue("Max Exec");
		 fcell3.setCellValue("Min Exec");
		 fcell4.setCellValue("Num of Exec");
		 fcell5.setCellValue("Query Content");
		 fcell6.setCellValue("Last Exec time");
		 fcell6.setCellValue("Schema Contains");
		 
		 
		 
		 
		 for(KhooResultBO bo:khooList) {
			 Row row = sheet.createRow(i);
			 Cell cell0 = row.createCell(0);
			 Cell cell1 = row.createCell(1);
			 Cell cell2 = row.createCell(2);
			 Cell cell3 = row.createCell(3);
			 Cell cell4 = row.createCell(4);
			 Cell cell5 = row.createCell(5);
			 Cell cell6 = row.createCell(6);
			 Cell cell7 = row.createCell(7);
			 cell0.setCellValue(bo.getReportDate());
			 cell1.setCellValue(bo.getAvgExecutionTime());
			 cell2.setCellValue(bo.getMaxExecutionTime());
			 cell3.setCellValue(bo.getMinExecutionTime());
			 cell4.setCellValue(bo.getNoExec());
			 String sql = bo.getQueryContent();
			 if(sql.length()>31000) {sql=sql.substring(0, 31000);}
			 cell5.setCellValue(sql);
			 cell6.setCellValue(bo.getLastExecTime());
			 String schema = "";
			 if(sql.toUpperCase().contains("DBO")) {schema = schema+"DBO,";}
			 if(sql.toUpperCase().contains("VM1DTA")) {schema = schema+"VM1DTA,";			 }
			 cell7.setCellValue(schema);
			 i++;
		 }
		 
		 FileOutputStream fOut = new FileOutputStream("KhooResult_final.xlsx"); 
		// 把相应的Excel 工作簿存盘 
		 finalResult.write(fOut); 
		fOut.flush(); 
		// 操作结束，关闭文件 
		fOut.close(); 
		System.out.println("=============fini");

	}

}
