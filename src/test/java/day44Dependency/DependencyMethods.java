package day44Dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods 
{
	@Test(priority=1)
	void openapp()
	{
		System.out.println("Open app");
		Assert.assertTrue(true);
	}
	@Test(priority=2, dependsOnMethods = {"openapp"})
	void login()
	{
		System.out.println("logged in");
		Assert.assertTrue(false);
	}
	@Test(priority=3, dependsOnMethods = {"login"})
	void search()
	{
		System.out.println("Search");
		Assert.assertTrue(true);
	}
	@Test(priority=4, dependsOnMethods = {"login","search"})
	void advSearch()
	{
		System.out.println("Advanced search");
		Assert.assertTrue(true);
	}
	@Test(priority=5, dependsOnMethods = {"login"})
	void logout()
	{
		System.out.println("Log out");
		Assert.assertTrue(true);
	}
}
