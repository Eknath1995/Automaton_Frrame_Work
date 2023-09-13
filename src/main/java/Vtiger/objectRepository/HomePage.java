package Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class HomePage  extends WebDriverUtility{
		
	//Declaration - dropdown, frame, window, text file, popup
	@FindBy(linkText = "Organizations")
	private WebElement Organizationslink;
	
	@FindBy(linkText = "Contacts")
	private WebElement Contactslink;
	
	@FindBy(linkText = "Products")
	private WebElement Productslink;
	
	@FindBy(xpath = "//img[@src='ofted/images/user.PNG']")
	private WebElement administatorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;
	
	//initializtion
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrganizationslink() {
		return Organizationslink;
	}
	public WebElement getContactslink() {
		return Contactslink;
	}
	public WebElement getProductslink() {
		return Productslink;
	}

	public WebElement getAdministatorImg() {
		return administatorImg;
	}
	public WebElement getSignoutlink() {
		return signoutlink;
	}

	//bussiness library
	
	/**
	 * This method will logout of application.
	 * @param driver
	 * @throws InterruptedException
	 */
	public void LogoutofApp(WebDriver driver) throws InterruptedException {
		MouseHover(driver, administatorImg);
		Thread.sleep(3000);
		WaitForElementTobeVisible(driver, signoutlink);
		signoutlink.click();
	}
	
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganizationslink() {
		Organizationslink.click();
	}


	/**
	 * This method will click on Contactslink link
	 */	
	public void ClickOnContactsLink() {
		Contactslink.click();
	}
	

	/**
	 * This method will click on Products link
	 */	
	public void ClickOnProductslinkLink() {
		Productslink.click();
	}
}





















