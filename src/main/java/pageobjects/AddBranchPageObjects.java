package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.GenericMethods;

public class AddBranchPageObjects {
	
	GenericMethods gen=new GenericMethods();
	@FindBy(xpath="//select[@id='branchTypeId']")
	private WebElement branchtype;
	@FindBy(xpath="//input[@id='branchName']")
	private WebElement branchname;
	@FindBy(xpath="//input[@id='branchStreet']")
	private WebElement branchstreet;
	@FindBy(xpath="//input[@id='branchRegion']")
	private WebElement branchregion;
	@FindBy(xpath="//input[@id='branchCity']")
	private WebElement branchcity;
	@FindBy(xpath="//li[@id='saveBtn']")
	private WebElement savebutton;
	@FindBy(xpath="//li[@id='clearBtn']")
	private WebElement clearbutton;
	
	public AddBranchPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectBranchType(String val)
	{
		
		gen.dropdownByValue(branchtype, val);
	}
	public void enterBranchName(String b_name)
	{
		gen.isTextBox(branchname);
		branchname.sendKeys(b_name);
	}
	public void enterBranchStreet(String b_street)
	{
		gen.isTextBox(branchstreet);
		branchstreet.sendKeys(b_street);
	}
	public void enterBranchRegion(String b_region)
	{
		gen.isTextBox(branchstreet);
		branchstreet.sendKeys(b_region);
	}
	public void enterBranchCity(String b_city)
	{
		gen.isTextBox(branchstreet);
		branchstreet.sendKeys(b_city);
	}
	public void clickSave()
	{
	    gen.isEnabled(savebutton);
	    savebutton.click();
	}
	public void clickClear()
	{
		gen.isEnabled(clearbutton);
		clearbutton.click();
		
	}
}
