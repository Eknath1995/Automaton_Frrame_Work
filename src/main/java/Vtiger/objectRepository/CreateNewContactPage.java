package Vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	//Declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement OrglookupImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement OrgSearchEdt;
	
	@FindBy(name = "search")
	private WebElement OrgSearchBtn;
	
	//initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrglookupImg() {
		return OrglookupImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}

	//Business library
	/**
	 * This method will create Contact using mandatory fields.
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	public void createNewContact(String LASTNAME, String ORGNAME, WebDriver driver) {
		lastNameEdt.sendKeys(LASTNAME);
		OrglookupImg.click();
		switchToWindow(driver, "Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click(); //Dynamic Xpath
		//a[text()='ch399'] - regular xpath for reference
				//a[text()='"+ORGNAME+"'] -> Dynamic Xpath
				//driver.findElement(By.linkText(ORGNAME));
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
}
