package Vtiger.GenericUtilities;




	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Vtiger.objectRepository.HomePage;
import Vtiger.objectRepository.LoginPage;


	/**
	 * This is a generic class consisting of all basic configuration 
	 * annotations of TESTNG
	 * @author Chaitra M
	 *
	 */
	public class BaseClass {
		public JavaUtility jUtil = new JavaUtility();
		public ExcelFileUtilities eUtil = new ExcelFileUtilities();
		public PropertyFileUtilities pUtil = new PropertyFileUtilities();
		public WebDriverUtility wUtil = new WebDriverUtility();
		public WebDriver driver=null;
//		public static WebDriver sdriver;
		
		
		@BeforeSuite//(alwaysRun = true) For Parallel execution
		public void bsConfig(){
			System.out.println("======== Database Connection Successful ========");
		}
//		@Parameters("browser")
//		@BeforeTest
		@BeforeClass//(alwaysRun = true)
		public void bcConfig(/*String BROWSER*/) throws Throwable
		{
			String BROWSER = pUtil.ReadDataFromPropertyFile("browser");
			String URL = pUtil.ReadDataFromPropertyFile("url");
			
			if (BROWSER.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (BROWSER.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (BROWSER.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else {
				System.out.println("Invalid Browser name");
			}

			wUtil.maximiseWindow(driver);
			wUtil.WaitForpageLoad(driver);
			driver.get(URL);
//			sdriver=driver;
			
			System.out.println(BROWSER+" ===== Browser Launched =====");
		}
		
		@BeforeMethod//(alwaysRun = true)
		public void bmConfig() throws Throwable
		{
			String USERNAME = pUtil.ReadDataFromPropertyFile("username");
			String PASSWORD = pUtil.ReadDataFromPropertyFile("password");
			
		LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			System.out.println("===== Login Successful =====");
		}
		
		@AfterMethod//(alwaysRun = true)
		public void amConfig() throws Throwable 
		{
			HomePage hp = new HomePage(driver);
			hp.LogoutofApp(driver);
			
			System.out.println("===== Logout Successful =====");
		}
		
//		@AfterTest
		@AfterClass//(alwaysRun = true)
		public void acConfig()
		{
			driver.quit();
			System.out.println(" ===== Browser Closed =====");
		}
		
		@AfterSuite//(alwaysRun = true)
		public void asConfig()
		{
			System.out.println("======== Database Connection Closed =======");
		}

	}


