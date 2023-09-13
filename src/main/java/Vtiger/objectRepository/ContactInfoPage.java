package Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	//Declaration 
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaerText;
	
	//initialization
	public ContactInfoPage(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getContactHeaerText() {
		return ContactHeaerText;
	}
	
	//Business library
	
	/**
	 * This method will return the contacts header text
	 * @return
	 */
	public String getContactHeader() {
		return ContactHeaerText.getText();
	}
}
