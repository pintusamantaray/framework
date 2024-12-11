package pageObjects;


import org.testng.annotations.*;

public class Annotations {
	
	@BeforeClass
	void login()
	{
		System.out.println("This is login");
	}
	@Test
	void search()
	{
		System.out.println("This is Search");
	}
	@Test
	void advsearch()
	{
		System.out.println("This is advsearch");
	}
	@Test(priority=1)
	void testpurpose()
	{
		System.out.println("This is for test");
	}
	@AfterClass
	void logout()
	{
		System.out.println("This is logout");
	}

}
