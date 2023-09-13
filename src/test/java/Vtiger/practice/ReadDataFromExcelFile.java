package Vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDataFromExcelFile {
	public static void main(String[] args) throws Throwable {
	//step 1: open the document  in the java readable format	
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ProjectData.xlsx");
	
	//step 2: Create workbook
	Workbook wb=WorkbookFactory.create(fis);
	
	//step 3: navigate to required sheet
	Sheet sh = wb.getSheet("Organizations");
	
	//step 4: navigate to required row
	Row rw = sh.getRow(0);
	
	//step 5: navigate to required cell
	Cell cl = rw.getCell(2);
	
	//step 6: Read the data inside the cell
	String data = cl.getStringCellValue();
	System.out.println(data);
	
	//step 7: Close the work book
	wb.close();
}}
