package Vtiger.practice;

import Vtiger.GenericUtilities.ExcelFileUtilities;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtilities;

public class GenericUtilityPractice {
	public static void main(String[] args) throws Throwable {
		PropertyFileUtilities putil= new PropertyFileUtilities();
		String value = putil.ReadDataFromPropertyFile("browser");
		System.out.println(value);
		
		 String username = putil.ReadDataFromPropertyFile("username");
		System.out.println(username);
		
		System.out.println("----------------------------------------");
		
		ExcelFileUtilities eutil =new ExcelFileUtilities();
		
		String data = eutil.ReadDataFromExcelFile("Contacts", 1, 2);
		System.out.println(data);
		
		System.out.println("-------------------------------------------");
		
		 eutil.writeDataIntoExcel("Trail01",1,2,"EKNATH");
		System.out.println("Data added");
		
		System.out.println("---------------------------------------");
		
		JavaUtility jutil = new JavaUtility();
			System.out.println(jutil.getRandomNumber());
			System.out.println( jutil.getSystemDate());
			
		System.out.println("---------------------------------------");
	
	}
}




















