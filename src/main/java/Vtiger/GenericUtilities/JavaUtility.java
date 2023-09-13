package Vtiger.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This Class consist of re usable method related to java.
 * @author ADMIN
 *
 */

public class JavaUtility {
	/**
	 * This method will return a random number for every execution.
	 * @return
	 */
	public int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(1000);
	}
	
	/**
	 * This method will generate the current system date in spesific format.
	 * @return
	 */
	public String getSystemDate() {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String date = formatter.format(d);
		return date;
	}
}
