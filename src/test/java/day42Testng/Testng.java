package day42Testng;

import org.testng.annotations.Test;

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
