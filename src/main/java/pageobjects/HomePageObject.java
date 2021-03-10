package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject{
	
	@FindBy(xpath="//li[@id='menu5']")
	WebElement customerManagement;
	@FindBy(xpath="//li[@id='submenu22']")
	WebElement RegisterCustomer;
	@FindBy(xpath="//li[@id='submenu24']")
	WebElement DeregisterCustomer;
	@FindBy(xpath="//li[@id='menu2']")
	WebElement branchManagement;
	@FindBy(xpath="//li[@id='submenu14']")
	WebElement addBranch;
	@FindBy(xpath="//li[@id='submenu15']")
	WebElement listBranch;

	
	public HomePageObject(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void selectCusManagement()
	{
		customerManagement.click();
	}
	public void selectRegisterCustomer()
	{
		RegisterCustomer.click();
	}
	public void selectDeregisterCustomer()
	{
		DeregisterCustomer.click();
	}
	public void selectBranchManagement()
	{
		branchManagement.click();
	}
	public void selectAddBranch()
	{
		addBranch.click();
	}
	public void selectListBranch()
	{
		listBranch.click();
	}

	

}
