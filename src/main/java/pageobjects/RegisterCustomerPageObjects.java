package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.GenericMethods;

public class RegisterCustomerPageObjects {

	GenericMethods gen=new GenericMethods();
	@FindBy(xpath="//input[@id='msisdn']")
	private WebElement customer_msisdn ;
	@FindBy(xpath="//div[@id='search-icon']")
	private WebElement search_icon ;
	@FindBy(xpath="//input[@id='name']")
	private WebElement customer_name ;
	@FindBy(xpath="//input[@id='age']")
	private WebElement customer_age ;
	@FindBy(xpath="//input[@name='gender']")
	private WebElement customer_gender ;
	@FindBy(xpath="//input[@id='gender1']")
	private WebElement customer_gender_male ;
	@FindBy(xpath="//input[@id='gender2']")
	private WebElement customer_gender_female ;
	@FindBy(xpath="//input[@id='paidOfferId']")
	private WebElement product_selection ;
	@FindBy(xpath="//input[@id='paidOfferId' and @value='1']")
	private WebElement combo_pack ;
	@FindBy(xpath="//input[@id='paidOfferId' and @value='4']")
	private WebElement family_pack ;
	@FindBy(xpath="//input[@id='paidOfferId' and @value='5']")
	private WebElement bkash_life ;
	@FindBy(xpath="//input[@id='paidOfferId' and @value='6']")
	private WebElement bkash_hospital ;
	@FindBy(xpath="//select[@id='nomineeRelation']")
	private WebElement combo_nominee_relationship ;
	@FindBy(xpath="//input[@id='nomineeName']")
	private WebElement combo_nominee_name ;
	@FindBy(xpath="//input[@id='nomineeMsisdn']")
	private WebElement combo_nominee_number ;
	@FindBy(xpath="//select[@id='beneficiaryRelation1']")
	private WebElement family_first_beneficiary_relationship ;
	@FindBy(xpath="//input[@id='beneficiaryName']")
	private WebElement family_first_beneficiary_name ;
	@FindBy(xpath="//input[@id='beneficiaryMsisdn']")
	private WebElement family_first_beneficiary_msisdn ;
	@FindBy(xpath="//input[@name='bnfgender1']")
	private WebElement family_first_beneficiary_gender ;
	@FindBy(xpath="//input[@name='bnfgender2']")
	private WebElement family_second_beneficiary_gender ;
	@FindBy(xpath="//input[@id='bnfgender1M' and @value='M']")
	private WebElement family_first_beneficiary_male ;
	@FindBy(xpath="//input[@id='bnfgender1F' and @value='F']")
	private WebElement family_first_beneficiary_female ;
	@FindBy(xpath="//input[@id='beneficiaryAge']")
	private WebElement family_first_beneficiary_age ;
	@FindBy(xpath="//select[@id='beneficiaryRelation2']")
	private WebElement family_second_beneficiary_relationship ;
	@FindBy(xpath="//input[@id='beneficiaryName1']")
	private WebElement family_second_beneficiary_name ;
	@FindBy(xpath="//input[@id='beneficiaryMsisdn1']")
	private WebElement family_second_beneficiary_msisdn ;
	@FindBy(xpath="//input[@id='bnfgender2M' and @value='M']")
	private WebElement family_second_beneficiary_male ;
	@FindBy(xpath="//input[@id='bnfgender2F' and @value='F']")
	private WebElement family_second_beneficiary_female ;
	@FindBy(xpath="//input[@id='beneficiaryAge1']")
	private WebElement family_second_beneficiary_age ;
	@FindBy(xpath="//select[@id='lifeCoverId']")
	private WebElement life_cover ;
	@FindBy(xpath="//select[@id='hospCoverId']")
	private WebElement hospital_cover ;
	@FindBy(xpath="//select[@id='paymentFrequency']")
	private WebElement payment_frequency ;
	@FindBy(xpath="//select[@id='paymentType']")
	private WebElement payment_type ;
	@FindBy(xpath="//select[@id='bkashNomineeRelation']")
	private WebElement bKash_life_nominee_relationship ;
	@FindBy(xpath="//input[@id='bkashNomineeName']")
	private WebElement bKash_life_nominee_name ;
	@FindBy(xpath="//input[@id='bkashNomineeMsisdn']")
	private WebElement bKash_life_nominee_msisdn ;
	@FindBy(xpath="//input[@id='bkashNomineeAge']")
	private WebElement bKash_life_nominee_age ;
	@FindBy(xpath="//select[@id='bkashHospNomineeRelation']")
	private WebElement bKash_hospital_nominee_relationship ;
	@FindBy(xpath="//input[@id='bkashHospNomineeName']")
	private WebElement bKash_hospital_nominee_name ;
	@FindBy(xpath="//input[@id='bkashHospNomineeMsisdn']")
	private WebElement bKash_hospital_nominee_msisdn ;
	@FindBy(xpath="//input[@id='bkashHospNomineeAge']")
	private WebElement bKash_hospital_nominee_age ;
	@FindBy(xpath="//select[@id='bkashBeneficiaryRelation1']")
	private WebElement bKash_hospital_first_beneficiary_relationship ;
	@FindBy(xpath="//input[@id='bkashBeneficiaryName1']")
	private WebElement bKash_hospital_first_beneficiary_name ;
	@FindBy(xpath="//input[@id='bkashBeneficiaryMsisdn1']")
	private WebElement bKash_hospital_first_beneficiary_msisdn ;
	@FindBy(xpath="//input[@id='bkashBeneficiaryAge1']")
	private WebElement bKash_hospital_first_beneficiary_age ;
	@FindBy(xpath="//select[@id='bkashBeneficiaryRelation2']")
	private WebElement bKash_hospital_second_beneficiary_relationship ;
	@FindBy(xpath="//input[@id='bkashBeneficiaryName2']")
	private WebElement bKash_hospital_second_beneficiary_name ;
	@FindBy(xpath="//input[@id='bkashBeneficiaryMsisdn2']")
	private WebElement bKash_hospital_second_beneficiary_msisdn ;
	@FindBy(xpath="//input[@id='bkashBeneficiaryAge2']")
	private WebElement bKash_hospital_second_beneficiary_age ;
	@FindBy(xpath="//select[@id='bkashBeneficiaryRelation3']")
	private WebElement bKash_hospital_third_beneficiary_relationship ;
	@FindBy(xpath="//input[@id='bkashBeneficiaryName3']")
	private WebElement bKash_hospital_third_beneficiary_name ;
	@FindBy(xpath="//input[@id='bkashBeneficiaryMsisdn3']")
	private WebElement bKash_hospital_third_beneficiary_msisdn ;
	@FindBy(xpath="//input[@id='bkashBeneficiaryAge3']")
	private WebElement bKash_hospital_third_beneficiary_age ;
	@FindBy(xpath="//select[@id='healthTipsSmsFrequency']")
	private WebElement health_tips_frequency ;
	@FindBy(xpath="//select[@id='healthTipLang']")
	private WebElement health_tips_language ;
	@FindBy(xpath="//input[@id='healthTipDate']")
	private WebElement health_tips_date ;
	@FindBy(xpath="//li[@id='backBtn']")
	private WebElement back_button ;
	@FindBy(xpath="//li[@id='clearBtn']")
	private WebElement clear_button ;
	@FindBy(xpath="//li[@id='saveBtn']")
	private WebElement save_button ;
	@FindBy(xpath="//li[@id='popup_ok']")
	private WebElement confirmation_ok ;
	@FindBy(xpath="//li[@id='popup_cancel']")
	private WebElement confirmation_cancel ;
	@FindBy(xpath="//div[@id='message_div']")
	private WebElement success_message ;


	public RegisterCustomerPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void enterCustomerMsisdn(String Msisdn)
	{
		gen.isTextBox(customer_msisdn);
		customer_msisdn.sendKeys(Msisdn);
	}
	public void clickSearch()
	{
		//boolean res=gen.isClickable(search_icon);
		//Assert.assertTrue(res);
		search_icon.click();
	}
	public void enterCustomerName(String c_name,WebDriver driver)
	{
		gen.isTextBox(customer_name);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(customer_name)).sendKeys(c_name);
	}
	public void enterCustomerAge(int age)
	{
		gen.isTextBox(customer_age);
		Integer i=new Integer(age);
		customer_age.sendKeys(i.toString());
	}
	public void selectCustomerGender(String gender)
	{
		String result=customer_gender.getAttribute("value");
		if(result.equalsIgnoreCase(gender))
		{
			gen.isRadiobutton(customer_gender_male);
			//Assert.assertTrue(gen.isClickable(customer_gender_male));
			customer_gender_male.click();
		}
		else
		{
			gen.isRadiobutton(customer_gender_female);
			//Assert.assertTrue(gen.isClickable(customer_gender_female));
			customer_gender_female.click();
		}
	}
	
	public void selectPaidProduct(int offer_id)
	{
		if(offer_id==1)
		{
			gen.isCheckBox(combo_pack);
			//Assert.assertTrue(gen.isClickable(combo_pack));
			combo_pack.click();
		}
		else if(offer_id==4)
		{
			gen.isCheckBox(family_pack);
			//Assert.assertTrue(gen.isClickable(family_pack));
			family_pack.click();
		}
		else if(offer_id==5)
		{
			gen.isCheckBox(bkash_life);
			//Assert.assertTrue(gen.isClickable(bkash_life));
			bkash_life.click();
		}
		else
		{
			gen.isCheckBox(bkash_hospital);
			//Assert.assertTrue(gen.isClickable(bkash_hospital));
			bkash_hospital.click();
		}
	}
	public void selectComboNomineeRelationship(String val)
	{
		gen.isDropdown(combo_nominee_relationship);
		gen.dropdownByValue(combo_nominee_relationship, val);
	}
	public void enterComboNomineeName(String nom_name)
	{
		gen.isTextBox(combo_nominee_name);
		combo_nominee_name.sendKeys(nom_name);
	}
	public void enterComboNomineeMsisdn(String nom_msisdn)
	{
		gen.isTextBox(combo_nominee_number);
		combo_nominee_number.sendKeys(nom_msisdn);
	}
	public void selectFamilyFirstBeneficiaryrelation(String val)
	{
		gen.isDropdown(family_first_beneficiary_relationship);
		gen.dropdownByValue(family_first_beneficiary_relationship,val);
	}
	public void selectFamilySecondBeneficiaryrelation(String val)
	{
		gen.isDropdown(family_second_beneficiary_relationship);
		gen.dropdownByValue(family_second_beneficiary_relationship,val);
	}
	public void enterFamilyFirstBeneficiaryName(String ben_name)
	{
		gen.isTextBox(family_first_beneficiary_name);
		family_first_beneficiary_name.sendKeys(ben_name);
	}
	public void enterFamilyFirstBeneficiaryMsisdn(String ben_msisdn)
	{
		gen.isTextBox(family_first_beneficiary_msisdn);
		family_first_beneficiary_msisdn.sendKeys(ben_msisdn);
	}
	public void enterFamilyFirstBeneficiaryAge(int ben_age)
	{
		gen.isTextBox(family_first_beneficiary_age);
		Integer i=new Integer(ben_age);
		family_first_beneficiary_age.sendKeys(i.toString());
	}
	public void selectFamilyFirstBeneficiaryGender(String gender)
	{
		String res=customer_gender.getAttribute("value");
		if(res.equalsIgnoreCase(gender))
		{
			gen.isRadiobutton(family_first_beneficiary_male);
			//Assert.assertTrue(gen.isClickable(family_first_beneficiary_male));
			family_first_beneficiary_male.click();
		}
		else
		{
			gen.isRadiobutton(family_first_beneficiary_female);
			//Assert.assertTrue(gen.isClickable(family_first_beneficiary_female));
			family_first_beneficiary_female.click();
		}
	}
	public void selectFamilySecondBeneficiaryGender(String gender)
	{
		String res=customer_gender.getAttribute("value");
		if(res.equalsIgnoreCase(gender))
		{
			gen.isRadiobutton(family_second_beneficiary_male);
			//Assert.assertTrue(gen.isClickable(family_second_beneficiary_male));
			family_second_beneficiary_male.click();;
		}
		else
		{
			gen.isRadiobutton(family_second_beneficiary_female);
			//Assert.assertTrue(gen.isClickable(family_second_beneficiary_female));
			family_second_beneficiary_female.click();
		}
	}
	public void enterFamilySecondBeneficiaryName(String ben_name)
	{
		gen.isTextBox(family_second_beneficiary_name);
		family_second_beneficiary_name.sendKeys(ben_name);
	}
	public void enterFamilySecondBeneficiaryMsisdn(String ben_msisdn)
	{
		gen.isTextBox(family_second_beneficiary_msisdn);
		family_second_beneficiary_msisdn.sendKeys(ben_msisdn);
	}
	public void enterFamilySecondBeneficiaryAge(int ben_age)
	{
		Integer i=new Integer(ben_age);
		gen.isTextBox(family_second_beneficiary_age);
		family_second_beneficiary_age.sendKeys(i.toString());
	}
	public void selectPaymentType(String val)
	{
		gen.isDropdown(payment_type);
		gen.dropdownByVisibleText(payment_type, val);
	}
	public void selectPaymentFrequency(String val)
	{
		gen.isDropdown(payment_frequency);
		gen.dropdownByVisibleText(payment_frequency, val);
	}
	public void selectLifeCover(int val)
	{
		gen.isDropdown(life_cover);
		gen.dropdownByIntValue(life_cover, val);
	}
	public void selectHospitalCover(int val)
	{
		gen.isDropdown(hospital_cover);
		gen.dropdownByIntValue(hospital_cover, val);
	}
	public void selectBKashLifeNomineeRelationship(String val)
	{
		gen.isDropdown(bKash_life_nominee_relationship);
		gen.dropdownByValue(bKash_life_nominee_relationship, val);
	}
	public void enterBKashLifeNomineeName(String nom_name)
	{
		gen.isTextBox(bKash_life_nominee_name);
		bKash_life_nominee_name.sendKeys(nom_name);
	}
	public void enterBKashLifeNomineeMsisdn(String msisdn)
	{
		gen.isTextBox(bKash_life_nominee_msisdn);
		bKash_life_nominee_msisdn.sendKeys(msisdn);
	}
	public void enterBKashLifeNomineeAge(int age)
	{
		gen.isTextBox(bKash_life_nominee_age);
		Integer i=new Integer(age);
		bKash_life_nominee_age.sendKeys(i.toString());
	}
	public void selectBKashHospitalNomineeRelationship(String val)
	{
		gen.isDropdown(bKash_hospital_nominee_relationship);
		gen.dropdownByValue(bKash_hospital_nominee_relationship, val);
	}
	public void enterBKashHospitalNomineeName(String nom_name)
	{
		gen.isTextBox(bKash_hospital_nominee_name);
		bKash_hospital_nominee_name.sendKeys(nom_name);
	}
	public void enterBKashHospitalNomineeMsisdn(String msisdn)
	{
		gen.isTextBox(bKash_hospital_nominee_msisdn);
		bKash_hospital_nominee_msisdn.sendKeys(msisdn);
	}
	public void enterBKashHospitalNomineeAge(int age)
	{
		gen.isTextBox(bKash_hospital_nominee_age);
		Integer i=new Integer(age);
		bKash_hospital_nominee_age.sendKeys(i.toString());
	}
	public void selectBKashHospitalFirstBeneficiaryRelationship(String val)
	{
		gen.isDropdown(bKash_hospital_first_beneficiary_relationship);
		gen.dropdownByVisibleText(bKash_hospital_first_beneficiary_relationship, val);
	}
	public void enterBKashHospitalFirstBeneficiaryName(String nom_name)
	{
		gen.isTextBox(bKash_hospital_first_beneficiary_name);
		bKash_hospital_first_beneficiary_name.sendKeys(nom_name);
	}
	public void enterBKashHospitalFirstBeneficiaryMsisdn(String msisdn)
	{
		gen.isTextBox(bKash_hospital_first_beneficiary_msisdn);
		bKash_hospital_first_beneficiary_msisdn.sendKeys(msisdn);
	}
	public void enterBKashHospitalFirstBeneficiaryAge(int age)
	{
		gen.isTextBox(bKash_hospital_first_beneficiary_age);
		Integer i=new Integer(age);
		bKash_hospital_first_beneficiary_age.sendKeys(i.toString());
	}
	public void selectBKashHospitalSecondBeneficiaryRelationship(String val)
	{
		gen.isDropdown(bKash_hospital_second_beneficiary_relationship);
		gen.dropdownByVisibleText(bKash_hospital_second_beneficiary_relationship, val);
	}
	public void enterBKashHospitalSecondBeneficiaryName(String nom_name)
	{
		gen.isTextBox(bKash_hospital_second_beneficiary_name);
		bKash_hospital_second_beneficiary_name.sendKeys(nom_name);
	}
	public void enterBKashHospitalSecondBeneficiaryMsisdn(String msisdn)
	{
		gen.isTextBox(bKash_hospital_second_beneficiary_msisdn);
		bKash_hospital_second_beneficiary_msisdn.sendKeys(msisdn);
	}
	public void enterBKashHospitalSecondBeneficiaryAge(int age)
	{
		gen.isTextBox(bKash_hospital_second_beneficiary_age);
		Integer i=new Integer(age);
		bKash_hospital_second_beneficiary_age.sendKeys(i.toString());
	}
	public void selectBKashHospitalThirdBeneficiaryRelationship(String val)
	{
		gen.isDropdown(bKash_hospital_third_beneficiary_relationship);
		gen.dropdownByVisibleText(bKash_hospital_third_beneficiary_relationship, val);
	}
	public void enterBKashHospitalThirdBeneficiaryName(String nom_name)
	{
		gen.isTextBox(bKash_hospital_third_beneficiary_name);
		bKash_hospital_third_beneficiary_name.sendKeys(nom_name);
	}
	public void enterBKashHospitalThirdBeneficiaryMsisdn(String msisdn)
	{
		gen.isTextBox(bKash_hospital_third_beneficiary_msisdn);
		bKash_hospital_third_beneficiary_msisdn.sendKeys(msisdn);
	}
	public void enterBKashHospitalThirdBeneficiaryAge(int age)
	{
		gen.isTextBox(bKash_hospital_third_beneficiary_age);
		Integer i=new Integer(age);
		bKash_hospital_third_beneficiary_age.sendKeys(i.toString());
	}
	public void selectHealthTipsFrequency(int val)
	{
		gen.isDropdown(health_tips_frequency);
		Integer i=new Integer(val);
		gen.dropdownByValue(health_tips_frequency, i.toString());
	}
	public void selectHealthTipsLangauage(String val)
	{
		gen.isDropdown(health_tips_language);
		gen.dropdownByValue(health_tips_language, val);
	}
	public void checkHealthTipsDate(String date)
	{
		String curdate=health_tips_date.getText();
		Assert.assertEquals(curdate, date);
	}
	public void clickSave()
	{
		//Assert.assertTrue(gen.isClickable(save_button));
		save_button.click();
	}
	public void clickBack()
	{
		//Assert.assertTrue(gen.isClickable(save_button));
		back_button.click();
	}
	public void clickClear()
	{
		//Assert.assertTrue(gen.isClickable(clear_button));
		clear_button.click();
	}
	public void clickYes()
	{
		//Assert.assertTrue(gen.isClickable(confirmation_ok));
		confirmation_ok.click();
	}
	public void clickNo()
	{
		//Assert.assertTrue(gen.isClickable(confirmation_cancel));
		confirmation_cancel.click();
	}
	public boolean success_registration()
	{
		boolean res=success_message.isDisplayed();
		return res;
	}
	
	public boolean isCustomerNameEnabled()
	{
		boolean result=customer_name.isEnabled();
		return result;
	}

}
