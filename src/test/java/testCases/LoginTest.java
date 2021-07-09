package testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;


public class LoginTest extends BaseClass
{

	@Test
	public void loginTest() throws IOException 
	{
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		
		lp.setPassword(password);
		
		lp.clickSubmit();

		Assert.assertTrue(driver.getTitle().equals("Guru99 Bank Manager HomePage"),"Login test failed");
		
	}
}