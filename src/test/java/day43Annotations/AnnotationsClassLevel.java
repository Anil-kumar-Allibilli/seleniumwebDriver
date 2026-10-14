package day43Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 here we will create a @test class where we have all the test methods, and we will have seperate beforeClass and afterClass as seperate classes, BeforeClass will execute before TestClass and After class will execute After Test class
 or
 execute the beforeclass/Afterclass after completion of all the test methods in same class
  1) Log in ----> @BeforeMetho (this will be executed before every Test method and in this case if we mention one time it will execute before each Test
  2) Search -----> @Test (this are the main actions we do)
  3) Adv search -----> @Test (this are the main actions we do)
  4) log out 
 */
public class AnnotationsClassLevel 
{
	@BeforeClass
	void login()
	{
		System.out.println("this is lon in");
	}
	
	@Test
	void search()
	{
		System.out.println("this is search");
	}
	
	@Test
	void advanceSearch()
	{
		System.out.println("this is advance search");
	}
	
	
	@AfterClass
	void logout()
	{
		System.out.println("this is lon out");
	}
}
