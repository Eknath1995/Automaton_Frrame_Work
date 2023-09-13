package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consist of generic/reusable metods related to Excel file.
 * @author ADMIN
 *
 */

public class ExcelFileUtilities {
	
	/**
	 * This method will read data from excel sheet and return the value to caller.
	 * @param sheetname
	 * @param rowindex
	 * @param cellindex
	 * @return
	 * @throws Throwable
	 */
	
	public String ReadDataFromExcelFile(String sheetname,int rowindex,int cellindex) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ProjectData.xlsx"); 
		Workbook wb = WorkbookFactory.create(fis);
		 String data = wb.getSheet(sheetname).getRow(rowindex).getCell(cellindex).getStringCellValue();
	wb.close();
	return data;
	}
	
	
	/**
	 * This method will write the data into excel sheet.
	 * @param sheetname
	 * @param rowindex
	 * @param cellindex
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetname, int rowindex,int cellindex,String value) throws Throwable{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ProjectData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).createRow(rowindex).createCell(cellindex).setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\ProjectData.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	public  Object[][] ReadMultipleData(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ProjectData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastrow = sh.getLastRowNum();
		int lastcel = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastrow][lastcel];
		
		for(int i=0; i<lastrow; i++) {
			for(int j=0; j<lastcel; j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	}

















