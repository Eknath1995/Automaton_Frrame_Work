package Vtiger.ContactTest;

import Vtiger.GenericUtilities.BaseClass;
import Vtiger.objectRepository.HomePage;

public class CreateContactWithOrgTest extends BaseClass{

	public void CreateContactWithOrgTest() throws Throwable {
		/*Read Data from property file*/
		String ORGNAME = eUtil.ReadDataFromExcelFile("Contacts", 4, 2)+jUtil.getRandomNumber();
		String LASTNAME= eUtil.ReadDataFromExcelFile("Contacts", 4, 3);
		
		/*Navigate to Organization link*/
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationslink();
				
	}
}
