package testNGPractice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners
public class Retry_Implimentation {
	
	@Test(retryAnalyzer = Vtiger.GenericUtilities.RetryAnalyserImplimentation.class)
	public void sample() {
//		Assert.fail();
		System.out.println("Hello");
	}
}
