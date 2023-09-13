package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of generic/reusable metods related to Property file.
 * @author ADMIN
 *
 */
public class PropertyFileUtilities {
	/**
	 * This method will read data from property file and return the value to caller.
	 * @param propertyfilekey
	 * @return
	 * @throws Throwable
	 */
	
	public  String ReadDataFromPropertyFile(String propertyfilekey) throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(propertyfilekey);
		return value;
	}
}
