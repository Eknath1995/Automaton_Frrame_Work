package Vtiger.practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromPropertyFil {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		// create an fileinputestream object
	FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties"); 

	//create an properties object
	Properties pobj = new Properties();
			pobj.load(fis);
			
			pobj.getProperty("browser");
			pobj.getProperty("url");
			pobj.getProperty("username");
			pobj.getProperty("password");
			
			System.out.println(pobj.getProperty("browser"));
			System.out.println(pobj.getProperty("url"));
			System.out.println(pobj.getProperty("username"));
			System.out.println(pobj.getProperty("password"));
			
			
			String browserName = pobj.getProperty("browser");
				if(browserName.equals("chrome")) {
					driver = new ChromeDriver();
					}
				else if(browserName.equals("firefox")){
						driver = new FirefoxDriver();
				}
				else if(browserName.equals("edge")){
					driver = new EdgeDriver();
			}
				  
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(pobj.getProperty("url"));
			driver.findElement(By.name("user_name")).sendKeys(pobj.getProperty("username"));
			driver.findElement(By.name("user_password")).sendKeys(pobj.getProperty("password"));
			driver.findElement(By.id("submitButton")).click();
 

	}
}