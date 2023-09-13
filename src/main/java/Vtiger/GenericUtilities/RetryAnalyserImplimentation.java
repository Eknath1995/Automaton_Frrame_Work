package Vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will provoide implementaion for Iretry interface of TestNG
 * @author ADMIN
 *
 */
public class RetryAnalyserImplimentation implements IRetryAnalyzer{
	
	int count =0;
	int retrycount = 2;
	
	public boolean retry(ITestResult result) {
		while(count<retrycount) {
			count++;
			return true;
		}
		return false;
	}

}
