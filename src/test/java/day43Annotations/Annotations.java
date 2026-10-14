package day43Annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
  1) Log in ----> @BeforeMetho (this will be executed before every Test method and in this case if we mention one time it will execute before each Test
  2) Search -----> @Test (this are the main actions we do)
  3) log out  ----> @AfterMetho (this will be executed After every Test method and in this case if we mention one time it will execute After each Test
  4) log in
  5) Adv search -----> @Test (this are the main actions we do)
  6) log out 
 */


/*
 1. Read testng.xml
2. Pick first class from xml
3. Execute that class completely
   - BeforeClass
   - BeforeMethod
   - Test methods (priority/dependency order)
   - AfterMethod
   - AfterClass
4. Pick next class from xml
5. Execute that class completely
6. Continue until all classes are finished
 */
public class Annotations 
{
	@BeforeMethod
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
	
	
	@AfterMethod
	void logout()
	{
		System.out.println("this is lon out");
	}
}
