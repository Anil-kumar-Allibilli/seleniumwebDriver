package day42Testng;

import org.testng.annotations.Test;

/*
//TestNg is an built in Fremework, used to use the featured of TestNg like 

Advantages:
			1) Test cases and Test suites
			2) Grouping of test cases 
			3) Prioritizing
			4) Parameterization   
			5) parallel testing/execution
			6) Reports
			-4 -3 -2 -1 0 1 2 3 4
			
*/
public class Testng 
{
	@Test(priority=1)
	void openwebsite()
	{
		System.out.println("open the website");
	}
	@Test(priority=2)
	void login()
	{
		System.out.println("login the website");
	}
	@Test(priority=3)
	void checkpage()
	{
		System.out.println("checkpage the website");
	}
	@Test(priority=4)
	void logout()
	{
		System.out.println("logout the website");
	}

}
