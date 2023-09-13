package Vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scenaroi5_cont {
	public static void main(String[] args) {
	//step 1: Launch the browser
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.get("http://localhost:8888/");
		 
	//step 2: Login to the app
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
		 driver.findElement(By.name("lastname")).sendKeys("Rathod");
	}
}
