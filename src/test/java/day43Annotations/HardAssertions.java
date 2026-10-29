package day43Annotations;

import org.testng.Assert;
import org.testng.annotations.Test;


//hard Assertion are assertions which we can use using class, because they are static method
public class HardAssertions 
{
	@Test
	void test()
	{
		Assert.assertEquals("xyz", 123); //comparison - false
		Assert.assertNotEquals("xyz", "xyz"); //false
		Assert.assertTrue(true);
		Assert.assertFalse(false); 
		Assert.fail(); //to fail the method
	}
	
	@Test
	void test2()
	{
		System.out.println("test1");
		System.out.println("test2");
		
		Assert.assertEquals(123, "asd");
		
		System.out.println("test3"); //in hard assertions if Assertions fail next steps will not execute, it is an issue so we for soft assertions
	}
}


