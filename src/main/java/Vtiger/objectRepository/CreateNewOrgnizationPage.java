package Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrgnizationPage extends WebDriverUtility{
	//Declaration
	
		@FindBy(name = "accountname")
		private WebElement OrgNameEdt;
	
		@FindBy(name = "industry")
		private WebElement IndustryDropDown;
	
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement SaveBtn;
		
	//initialization
		public CreateNewOrgnizationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

	//utilization
		public WebElement getOrgNameEdt() {
			return OrgNameEdt;
		}

		public WebElement getIndustryDropDown() {
			return IndustryDropDown;
		}

		public WebElement getSaveBtn() {
			return SaveBtn;
		}
		
	//Business library
		/**
		 * This method will create organizaton using mandatory fields.
		 * @param ORGNAME
		 */
		public void CreateNewOrganization(String ORGNAME) {
			OrgNameEdt.sendKeys(ORGNAME);
			SaveBtn.click();
		}
		
		public void CreateNewOrganization(String ORGNAME, String INDUSTRY) {
			OrgNameEdt.sendKeys(ORGNAME);
			HandleDropDown(IndustryDropDown, INDUSTRY);
			SaveBtn.click();
		}
		
}
















