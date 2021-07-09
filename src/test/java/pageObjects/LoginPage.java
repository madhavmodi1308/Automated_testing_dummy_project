package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name="uid")
	WebElement UserName;

	@FindBy(name="password")
	WebElement Password;

	@FindBy(name="btnLogin")
	WebElement Login_btn;


	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement Logout;



	public void setUserName(String uname)
	{
		UserName.sendKeys(uname);
	}

	public void setPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}


	public void clickSubmit()
	{
		Login_btn.click();
	}	

	public void clickLogout()
	{
		Logout.click();
	}



}
