package day43Annotations;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions 
{
	//in hard assertions if Assertions fail next steps will not execute, it is an issue so we for soft assertions
	
	@Test
	void test_hardasserion()
	{
		System.out.println("Hardtest1");
		System.out.println("Hardtest2");
		
		Assert.assertEquals(123, "asd"); // hard assertion
		
		System.out.println("Hardtest3"); 
	}
	
	@Test
	void test_softassertion()
	{
		System.out.println("Softtest1");
		System.out.println("Softtest2");
		
		SoftAssert sa = new SoftAssert();// in soft assertion we will create SiftAssert(class) object as use it for assertion, so that even if assertion fails, code continues reading, soft asserts are not static so we use object
		sa.assertEquals(123, "asd");
		
		System.out.println("Softtest3"); 
		sa.assertAll(); // this line is mandatory for soft assetions because soft asserts will always pass
	}
	
}
