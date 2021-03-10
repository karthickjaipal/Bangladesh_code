package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GenericMethods;


public class LoginPageObject {
	GenericMethods gen=new GenericMethods();
	
	@FindBy(xpath="//input[@id='loginId']")
	WebElement username; 
	
	@FindBy(xpath="//input[@id='userHash']")
	WebElement password;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[@id='mylink']")
	WebElement forgotpwd;
	
	@FindBy(xpath="//li[@id='clearBtn']")
	WebElement clear;
	
	@FindBy(xpath="//div[@class='error-msg-login']")
	WebElement error_message;
	
	public LoginPageObject(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String uname)
	{
		
		//gen.isTextBox(username);
		username.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		//gen.isTextBox(password);
		password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}
	
	public void clickClear()
	{
		clear.click();
	}

	public void clickforgotpassowrd()
	{
		gen.isHyperLink(forgotpwd);
		forgotpwd.click();
	}
	
	public void isUsernamecleared()
	{
		String text=username.getText();
		if(text.isEmpty()==true)
		{
			System.out.println("Username field is cleared");
		}
	}
	
	public void isPasswordcleared()
	{
		String text=password.getText();
		if(text.isEmpty()==true)
		{
			System.out.println("Password field is cleared");
		}
	}
	
	public void iserrordisplayed()
	{
		if(error_message.isDisplayed()==true)
		{
			System.out.println("User is displayed with the error message");
		}
	}
	
}
