package day43Annotations;

import org.testng.Assert;
import org.testng.annotations.Test;



//when we use any conditional statements in Test even if the condition fails when we execute results show "Passed: testTittle" but it should fail this issue can over some by using Assertions
public class Assertions 
{

	@Test
	void testTittle()
	{
		String expected_tittle = "OpenCart";
		String actual_tittke = "OpenShop";
//		if(expected_tittle.equals(actual_tittke))
//		{
//			System.out.println("Same title");
//		}
//		else
//		{
//			System.out.println("Different title");
//		}
		
		//if we want to use conditional statement then we use condition with assertion
		/*
		 if(expected_tittle.equals(actual_tittke))
//		{
//			System.out.println("Same title");
			Assert.assertTrue(true); or Assert.assertTrue(false);
//		}
		 */
		Assert.assertEquals(expected_tittle, actual_tittke);
	}
}
