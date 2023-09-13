package Vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class scenario1_org {
	public static void main(String[] args) throws Throwable {
	//step 1: launch the browser
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		
	//step 2: login to appilcation
		 WebElement username = driver.findElement(By.name("user_name"));
			username.clear();
			username.sendKeys("admin");
		 WebElement password = driver.findElement(By.name("user_password"));
			password.clear();
			password.sendKeys("admin");
		 driver.findElement(By.id("submitButton")).click();
	
	//step 3: Navigate to contact link
		 driver.findElement(By.linkText("Contacts")).click();
		 
	//step 4: Click on create contact lool up image 
		 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		 
	//step 5: create contact with mandatory info
		 driver.findElement(By.name("lastname")).sendKeys("chinna");
		 
	//step 6: save
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
	//sstep 7: validate
		String contactHeader = driver.findElement(By.className("dvHeaderText")).getText();
		if (contactHeader.contains("chinna")) {
			System.out.println("Pass");
			System.out.println(contactHeader); 
		}
		else {
			System.out.println("Fail");
		}
		
	//step 8: logout of app
		WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
		Actions act=new Actions(driver);
		act.moveToElement(mouseHover).perform();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
	//step 9: close the browser
		driver.quit();
	
	}
	
}
















