package utility;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import junit.framework.Assert;

public class GenericMethods implements Bangladesh_Constants  {
	public WebDriver driver;
	
	@BeforeTest
	public WebDriver launchBrowser()
	{
		System.setProperty(Chrome_key,Chrome_value);
		driver=new ChromeDriver();
		return driver;
	}

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

	public void dropdownByValue(WebElement ele,String value)
	{
		Select sel=new Select(ele);
		sel.selectByValue(value);

	}
	public void dropdownByIntValue(WebElement ele,int value)
	{
		Select sel=new Select(ele);
		String str=String.valueOf(value);
		sel.selectByValue(str);

	}
	
	public void dropdownByIndex(WebElement ele,int index)
	{
		Select sel=new Select(ele);
		sel.selectByIndex(index);

	}
	public void dropdownByVisibleText(WebElement ele,String value)
	{
		Select sel=new Select(ele);
		sel.selectByVisibleText(value);
	}

	public String toGetCurrentdate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String curdate=formatter.format(date);
		return curdate;
	}

	public Properties readPropertyFile(String filename)
	{
		Properties property=new Properties();
		try {
			if(filename.equals("RegisterCustomer"))
			{
			String file_path="C:\\Users\\karthick_jaipal\\Myworkspace2\\MIP_BD\\Applicationconfig.properties";
			FileInputStream fis=new FileInputStream(file_path);
            property.load(fis);
			}
			else if (filename.equals("BranchManagement"))
			{
				String file_path="C:\\Users\\karthick_jaipal\\Myworkspace2\\MIP_BD\\BranchManagement.properties";
				FileInputStream fis=new FileInputStream(file_path);
	            property.load(fis);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return property;
	}
	
	public void isTextBox(WebElement ele)
	{
		String attribute_value=ele.getAttribute("type");
		Assert.assertEquals(attribute_value, "text");
	}
	
	public void isRadiobutton(WebElement ele)
	{
		String attribute_value=ele.getAttribute("type");
		Assert.assertEquals(attribute_value, "radio");
	}
	
	public void isCheckBox(WebElement ele)
	{
		String attribute_value=ele.getAttribute("type");
		Assert.assertEquals(attribute_value, "checkbox");
	}
	
	public boolean isClickable(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return true;
	}
	
	public void isDropdown(WebElement ele)
	{
		String res=ele.getTagName();
		Assert.assertEquals(res, "select");
	}
	
	public void isHyperLink(WebElement ele)
	{
		String res=ele.getTagName();
		Assert.assertEquals(res, "a");
	}
	
	public void isEnabled(WebElement ele)
	{
		boolean res=ele.isEnabled();
		Assert.assertTrue(res);
	}
	
	public void isDisabled(WebElement ele)
	{
		boolean res=ele.isEnabled();
		Assert.assertFalse(res);
	}
	
	

}
