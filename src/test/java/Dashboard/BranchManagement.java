package Dashboard;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageobjects.AddBranchPageObjects;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;
import pageobjects.RegisterCustomerPageObjects;
import utility.GenericMethods;

public class BranchManagement {
	GenericMethods gen=new GenericMethods();
	public WebDriver driver=gen.launchBrowser();
	Properties property=gen.readPropertyFile("RegisterCustomer");
	Properties property1=gen.readPropertyFile("BranchManagement");
	
	@Test
	public void createBranch()
	{
		driver.get(property.getProperty("dashboard_url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginPageObject loginpage=new LoginPageObject(driver);
		HomePageObject homepage=new HomePageObject(driver);
		AddBranchPageObjects branch=new AddBranchPageObjects(driver);
		loginpage.setUsername(property.getProperty("dashboard_username"));
		loginpage.setPassword(property.getProperty("dashboard_password"));
		loginpage.clickLogin();
		homepage.selectBranchManagement();
		homepage.selectAddBranch();
		branch.selectBranchType(property1.getProperty("branch_type"));
		branch.enterBranchName(property1.getProperty("branch_name"));
		branch.enterBranchStreet(property1.getProperty("branch_street"));
		branch.enterBranchRegion(property1.getProperty("branch_region"));
		branch.enterBranchCity(property1.getProperty("branch_city"));
		
	}
	
	
	
}
