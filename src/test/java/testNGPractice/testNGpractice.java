package testNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNGpractice {
	@Test
	public void testngpractice() {
//		Assert.fail();
		System.out.println("hello maam");
	}
	
	@Test(dependsOnMethods = "testngpractice")
	public void test() {
		System.out.println("hi");
	}
	
	@Test(dependsOnMethods = {"testngpractice","test"})
	public void name() {
		System.out.println("my name");
	}
}
