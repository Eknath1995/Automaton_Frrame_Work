package Vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {
	public static void main(String[] args) throws Throwable {
	//step 1: open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ProjectData.xlsx");

	//Create workbook
		Workbook wb = WorkbookFactory.create(fis);
		
//	navigste to the sheet
		Sheet sh = wb.createSheet("Trail01");
	
//	navigate to row
		Row rw = sh.createRow(2);
		
//		create a cell
		Cell cl = rw.createCell(3);
	
//	Provoide data to be provoide
		cl.setCellValue("jasgandu");
		
//		open document in java write format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\ProjectData.xlsx");
	
	//write the data
		wb.write(fos);
		System.out.println("Data added successfully");
	
	
	}
}
