package day44Dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods 
{
	@Test(priority=1)
	void openapp()
	{
		System.out.println("Open app");
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	void login()
	{
		System.out.println("logged in");
		Assert.assertTrue(true);
	}
	@Test(priority=3)
	void search()
	{
		System.out.println("Search");
		Assert.assertTrue(true);
	}
	@Test(priority=4)
	void advSearch()
	{
		System.out.println("Advanced search");
		Assert.assertTrue(true);
	}
	@Test(priority=5)
	void logout()
	{
		System.out.println("Log out");
		Assert.assertTrue(true);
	}
}
