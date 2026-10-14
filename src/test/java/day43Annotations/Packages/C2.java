package day43Annotations.Packages;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C2 
{
	@Test
	void abc()
	{
		System.out.println("this is abc from C2 class");
	}
	
	@AfterTest
	void bt()
	{
		System.out.println("this is After test method");
	}
}
