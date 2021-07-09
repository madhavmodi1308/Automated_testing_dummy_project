package testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTest_DataProvider extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().defaultContent();
			Assert.assertTrue(false,"Invalid User Account");
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
				
	}
	
	
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][] {
            { "mngr322614", "tebEqat" },
            { "madhav", "qwerty" }
//            ,{ "mngr322617", "dUtegyz" },
//            { "madhavmodi", "tebEqat" }
        };  
	}
	
}
