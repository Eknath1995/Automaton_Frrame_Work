package testNGPractice;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Vtiger.GenericUtilities.listnerImplimentation.class)
public class ListenerPractice {
	
	@Test
	public void Demo() {
//		Assert.fail();
		System.out.println("Hi");
	}
	
	@Test(dependsOnMethods = "Demo")
	public void demo1() {
		System.out.println("Hello");
	}
}
