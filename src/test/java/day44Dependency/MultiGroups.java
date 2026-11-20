package day44Dependency;

import org.testng.annotations.Test;


/*
<groups>
			<run>
				<include name="functional"/>
			</run>
		</groups>
*/
public class MultiGroups 
{

	@Test(priority=1,groups= {"sanity","Regression","functional"}) //functional is the combination group groups
	void paaymentInRupees()
	{
		System.out.println("payment in rupees");
	}
	
	@Test(priority=2,groups= {"sanity","Regression","functional"})
	void paymentinDOllers()
	{
		System.out.println("payment in DOllers");
	}
}
