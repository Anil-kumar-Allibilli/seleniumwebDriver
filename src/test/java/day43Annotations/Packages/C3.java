package day43Annotations.Packages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C3 
{
	@Test
	void abc()
	{
		System.out.println("this is abc from C3 class");
	}
	
	@BeforeSuite
	void bs()
	{
		System.out.println("this is beforeSuite method");
	}
	
	@AfterSuite
	void as()
	{
		System.out.println("this is AfterSuite method");
	}
}
