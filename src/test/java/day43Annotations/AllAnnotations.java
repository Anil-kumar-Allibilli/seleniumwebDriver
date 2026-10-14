package day43Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations 
{
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
	
	@BeforeTest
	void bt()
	{
		System.out.println("this is before test method");
	}
	
	@AfterTest
	void at()
	{
		System.out.println("this is After test method");
	}
	
	@BeforeClass
	void loginBC()
	{
		System.out.println("this is lon in BC");
	}
	
	@AfterClass
	void logoutAC()
	{
		System.out.println("this is lon out AC");
	}
	
	@BeforeMethod
	void loginBM()
	{
		System.out.println("this is lon in BM");
	}

	@AfterMethod
	void logoutAM()
	{
		System.out.println("this is lon out AM");
	}
	
	@Test
	void searchTM()
	{
		System.out.println("this is search TM");
	}
	
	@Test
	void advanceSearchTM()
	{
		System.out.println("this is advance search TM");
	}
}
