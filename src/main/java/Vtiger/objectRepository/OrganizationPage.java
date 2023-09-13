package Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	//initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}

	//business library
	public void clickOnCreateOrgLookUpImage() {
		CreateOrgLookUpImg.click();
	}
	
}
