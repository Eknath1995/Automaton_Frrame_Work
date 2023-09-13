package testNGPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.ExcelFileUtilities;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtilities;
import Vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrgwithIndustry {
	// Create object of all utility classes
	JavaUtility jutil = new JavaUtility();
	PropertyFileUtilities putil = new PropertyFileUtilities();
	ExcelFileUtilities eutil = new ExcelFileUtilities();
	WebDriverUtility wutil = new WebDriverUtility();
	
//	@Test(dataProvider = "getdata")
	public void CreatemultipleOrg(String ORG, String INDUSTRYTYPE) throws Throwable {
	
				WebDriver driver = null;
				
			// step 1: Read all the data required
				/* read data from property file*/
				String BROWSER = putil.ReadDataFromPropertyFile("browser");
				String URL = putil.ReadDataFromPropertyFile("url");
				String USERNAME = putil.ReadDataFromPropertyFile("username");
				String PASSWORD = putil.ReadDataFromPropertyFile("password");
				
				String ORGNAME=ORG+jutil.getRandomNumber();
			
			//Step 2: launch the browser - run time polymorpism - driver
					if(BROWSER.equals("chrome")) {
						driver = new ChromeDriver();
					}
					else if(BROWSER.equalsIgnoreCase("edge")) {
						driver= new EdgeDriver();
					}
					else
						System.out.println("invalid browser name");
					
					wutil.maximiseWindow(driver);
					wutil.WaitForpageLoad(driver);
					driver.get(URL);
					
				// step 3: login to application
					driver.findElement(By.name("user_name")).sendKeys(USERNAME);
					driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
					driver.findElement(By.id("submitButton")).click();
					
				//Step 3: Navigate to Organizations Link
					driver.findElement(By.linkText("Organizations")).click();

				//Step 4: Click On create Organization Look Up Image
					driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

					
				//Step 5: Create Organization with mandatory Information
					driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

				//Step 6: Select 'Chemicals' in industry Drop down
					WebElement dropDown = driver.findElement(By.xpath("//select[@name='industry']"));
					wutil.HandleDropDown(dropDown, INDUSTRYTYPE);
					
				//Step 7: Save 
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

				//Step 8: Validate
					String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					if(orgHeader.contains(ORGNAME))	{
						System.out.println("PASS");
						System.out.println(orgHeader);
					}
					else{
						System.out.println("FAIL");
					}
							
				//Step 9: Logout of App
					WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					wutil.MouseHover(driver, mouseHover);
					Thread.sleep(1000);	
					driver.findElement(By.linkText("Sign Out")).click();
							
				//Step 10: Close the browser
					driver.quit();
			
	}
	
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException {
		Object[][] data = eutil.ReadMultipleData("multipleOrg");
		return data;
	}
}
