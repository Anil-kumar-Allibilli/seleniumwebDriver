package day44Dependency;

import org.testng.annotations.Test;

/*
<groups>
			<run>
				<include name="Regression"/>
				<exclude name="sanity"></exclude>
			</run>
		</groups>
*/

public class GroupsRegression 
{
	@Test(priority=1,groups= {"Regression"})
	void signByEmail()
	{
		System.out.println("sign in by email");
	}
	
	@Test(priority=2,groups= {"Regression"})
	void signByFaceBook()
	{
		System.out.println("sign in by FB");
	}
	
	@Test(priority=3,groups= {"Regression"})
	void signByTwitter()
	{
		System.out.println("sign in by Twitter");
	}
	
}
