package Vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.ExcelFileUtilities;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtilities;
import Vtiger.GenericUtilities.WebDriverUtility;
import Vtiger.objectRepository.HomePage;

public class CreateOrgWithIndustryUsingGU {

	@Test(groups = "smokesuite")
	public void CreateOrgWithIndustryUsingGU() throws Throwable {
	// Create object of all utility classes
		JavaUtility jutil = new JavaUtility();
		PropertyFileUtilities putil = new PropertyFileUtilities();
		ExcelFileUtilities eutil = new ExcelFileUtilities();
		WebDriverUtility wutil = new WebDriverUtility();
		
		WebDriver driver = null;
		
	// step 1: Read all the data required
		/* read data from property file*/
		String BROWSER = putil.ReadDataFromPropertyFile("browser");
		String URL = putil.ReadDataFromPropertyFile("url");
		String USERNAME = putil.ReadDataFromPropertyFile("username");
		String PASSWORD = putil.ReadDataFromPropertyFile("password");
		
		/*Read data from excel file*/
		String ORGNAME = eutil.ReadDataFromExcelFile("Organizations", 4, 2)+jutil.getRandomNumber();
			String INDUSTRYTYPE = eutil.ReadDataFromExcelFile("Organizations", 4, 3);
	
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
			HomePage hp = new HomePage(driver);
			hp.LogoutofApp(driver);
					
		//Step 10: Close the browser
			driver.quit();
	
	}
}



























