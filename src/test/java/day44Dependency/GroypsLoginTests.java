package day44Dependency;

import org.testng.annotations.Test;

public class GroypsLoginTests 


/*
 <groups>
			<run>
				<include name="sanity"/>
				<exclude name="Regression"></exclude>
			</run>
		</groups>
 */
{
	@Test(priority=1,groups= {"sanity"})
	void loginByEmail()
	{
		System.out.println("Log in by email");
	}
	
	@Test(priority=2,groups= {"sanity"})
	void loginByFaceBook()
	{
		System.out.println("Log in by FB");
	}
	
	@Test(priority=3,groups= {"sanity"})
	void loginByTwitter()
	{
		System.out.println("Log in by Twitter");
	}
	
	
}
