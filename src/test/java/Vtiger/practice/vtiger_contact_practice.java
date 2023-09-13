package Vtiger.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.GenericUtilities.ExcelFileUtilities;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtilities;
import Vtiger.GenericUtilities.WebDriverUtility;
import Vtiger.objectRepository.ContactInfoPage;
import Vtiger.objectRepository.ContactPage;
import Vtiger.objectRepository.CreateNewContactPage;
import Vtiger.objectRepository.CreateNewOrgnizationPage;
import Vtiger.objectRepository.HomePage;
import Vtiger.objectRepository.LoginPage;
import Vtiger.objectRepository.OrganizationInfoPage;
import Vtiger.objectRepository.OrganizationPage;

public class vtiger_contact_practice {
	public static void main(String[] args) throws Throwable {

		// Create Objects of all Utility Classes
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtilities pUtil = new PropertyFileUtilities();
		ExcelFileUtilities eUtil = new ExcelFileUtilities();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		WebDriver driver = null;

		// Step 1: Read All the Data required 
		
		/* read Data from Property file */
		String BROWSER = pUtil.ReadDataFromPropertyFile("browser");
		String URL = pUtil.ReadDataFromPropertyFile("url");
		String USERNAME = pUtil.ReadDataFromPropertyFile("username");
		String PASSWORD = pUtil.ReadDataFromPropertyFile("password");


		/* read Data from ExcelFile */
		String ORGNAME = eUtil.ReadDataFromExcelFile("Contacts", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.ReadDataFromExcelFile("Contacts", 4, 3);

		// Step 2: Launch the browser - //Run Time Polymorphism - driver
				if (BROWSER.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();
				} 
				else if (BROWSER.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				} 
				else if (BROWSER.equalsIgnoreCase("edge")) {
					driver = new EdgeDriver();
				}
				else {
					System.out.println("Invalid Browser name");
				}

				wUtil.maximiseWindow(driver);
				wUtil.WaitForpageLoad(driver);
				driver.get(URL);
				
				// Step 2: Login To Application
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);		
				
				// Step 3: Navigate to Organizations Link
				HomePage hp = new HomePage(driver);
				hp.clickOnOrganizationslink();
				
				// Step 4: Click On create Organization Look Up Image
				OrganizationPage op = new OrganizationPage(driver);
				op.clickOnCreateOrgLookUpImage();
				
				// Step 5: Create Organization with mandatory Information
				CreateNewOrgnizationPage cnop = new CreateNewOrgnizationPage(driver);
				cnop.CreateNewOrganization(ORGNAME);
				

				// Step 8: Validate
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String orgHeader = oip.getOrgHeader();

				if (orgHeader.contains(ORGNAME)) {
					System.out.println("Organization created");
					System.out.println(orgHeader);
				} else {
					System.out.println("FAIL");
				}
				

				//Step 9: Click on Contacts Link
				hp.ClickOnContactsLink();
				
				//Step 10: Click on Create Contact Look Up image
				ContactPage cp = new ContactPage(driver);
				cp.ClickOnCreateContactLookUpImg();
				
				//Step 11: create Contact using the organization
				CreateNewContactPage cncp = new CreateNewContactPage(driver); 
				cncp.createNewContact(LASTNAME, ORGNAME, driver);
				
				//Step 12: Validate for Contacts
				ContactInfoPage cip = new ContactInfoPage(driver);
				String ContactHeader = cip.getContactHeader();
				
				if(ContactHeader.contains(LASTNAME))
				{
					System.out.println("PASSS");
					System.out.println(ContactHeader);
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Step 13: Logout of app
				Thread.sleep(2000);
				hp.LogoutofApp(driver);
				//Step 14: Close the browser
				driver.quit();
				
			}

  		}






















