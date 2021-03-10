package Dashboard;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dto.ComboFamilyRegData;
import dto.ComboRegData;
import dto.FamilyRegData;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;
import pageobjects.RegisterCustomerPageObjects;
import utility.GenericMethods;
import utility.ReadExcelData;

public class RegisterCustomer {
	GenericMethods gen=new GenericMethods();
	public WebDriver driver=gen.launchBrowser();
	Properties property=gen.readPropertyFile("RegisterCustomer");
	
	public static Logger log=LogManager.getLogger(RegisterCustomer.class.getName());
	
	
	/*@Test
	public void validateRegisterCustomerFields()
	{
		try {
			log.debug("Entering Method: validateRegisterCustomerFields ");
			driver.get(property.getProperty("dashboard_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LoginPageObject loginpage=new LoginPageObject(driver);
			HomePageObject homepage=new HomePageObject(driver);
			RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
			loginpage.setUsername(property.getProperty("dashboard_username"));
			loginpage.setPassword(property.getProperty("dashboard_password"));
			loginpage.clickLogin();
			homepage.selectCusManagement();
			homepage.selectRegisterCustomer();
			registrationpage.enterCustomerMsisdn(property.getProperty("combo_msisdn"));
			registrationpage.clickSearch();             
			registrationpage.enterCustomerName(property.getProperty("combo_cusname"),driver);
			Integer age=new Integer(property.getProperty("combo_cusage"));
			registrationpage.enterCustomerAge(age);
			registrationpage.selectCustomerGender(property.getProperty("combo_cusgender"));
			Integer offer_id=new Integer(property.getProperty("combo_product_id"));
			registrationpage.selectPaidProduct(offer_id);
			registrationpage.selectComboNomineeRelationship(property.getProperty("combo_nomrel"));
			registrationpage.enterComboNomineeName(property.getProperty("combo_nomname"));
			registrationpage.enterComboNomineeMsisdn(property.getProperty("combo_nommsisdn"));
			Integer cp_id=new Integer(property.getProperty("combo_health_tips"));
			registrationpage.selectHealthTipsFrequency(cp_id);
			registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
			registrationpage.clickSave();
			registrationpage.clickYes();
			System.out.println("entered");
			System.out.println(registrationpage);
			boolean result=registrationpage.success_registration();
			Assert.assertTrue(result, "Successful Registration");
			
		} catch (Exception e) {
			Assert.fail("Validation field");
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void freshComboRegistration()
	{
		try {
			//log.debug(property);
			driver.get(property.getProperty("dashboard_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LoginPageObject loginpage=new LoginPageObject(driver);
			HomePageObject homepage=new HomePageObject(driver);
			RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
			System.out.println("Entered username");
			loginpage.setUsername(property.getProperty("dashboard_username"));
			System.out.println("Entered password");
			System.out.println(property.getProperty("dashboard_password"));
			loginpage.setPassword(property.getProperty("dashboard_password"));
			loginpage.clickLogin();
			homepage.selectCusManagement();
			homepage.selectRegisterCustomer();
			registrationpage.enterCustomerMsisdn(property.getProperty("combo_msisdn"));
			registrationpage.clickSearch();             
			registrationpage.enterCustomerName(property.getProperty("combo_cusname"),driver);
			Integer age=new Integer(property.getProperty("combo_cusage"));
			registrationpage.enterCustomerAge(age);
			registrationpage.selectCustomerGender(property.getProperty("combo_cusgender"));
			Integer offer_id=new Integer(property.getProperty("combo_product_id"));
			registrationpage.selectPaidProduct(offer_id);
			registrationpage.selectComboNomineeRelationship(property.getProperty("combo_nomrel"));
			registrationpage.enterComboNomineeName(property.getProperty("combo_nomname"));
			registrationpage.enterComboNomineeMsisdn(property.getProperty("combo_nommsisdn"));
			Integer cp_id=new Integer(property.getProperty("combo_health_tips"));
			registrationpage.selectHealthTipsFrequency(cp_id);
			registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
			registrationpage.clickSave();
			registrationpage.clickYes();
			System.out.println("entered");
			System.out.println(registrationpage);
			boolean result=registrationpage.success_registration();
			Assert.assertTrue(result, "Successful Registration");
			
		} catch (Exception e) {
			Assert.fail("Customer Registration failed");
			e.printStackTrace();
		}
	}*/
	
	@Test
	public void comboRegistrationTest()
	{
		try {
			List<ComboRegData> comboreglist = ReadExcelData.readComboRegData();
			for(ComboRegData comboregdata: comboreglist)
			{
			log.debug(property);
			driver.get(property.getProperty("dashboard_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LoginPageObject loginpage=new LoginPageObject(driver);
			HomePageObject homepage=new HomePageObject(driver);
			RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
			loginpage.setUsername(property.getProperty("dashboard_username"));
			loginpage.setPassword(property.getProperty("dashboard_password"));
			loginpage.clickLogin();
			homepage.selectCusManagement();
			homepage.selectRegisterCustomer();
			registrationpage.enterCustomerMsisdn(comboregdata.getMsisdn());
			registrationpage.clickSearch();
			if(registrationpage.isCustomerNameEnabled()== true)
			{
			registrationpage.enterCustomerName(comboregdata.getCustomername(),driver);
			registrationpage.enterCustomerAge(comboregdata.getAge());
			registrationpage.selectCustomerGender(comboregdata.getGender());
			}
			registrationpage.selectPaidProduct(comboregdata.getOfferid());
			registrationpage.selectComboNomineeRelationship(comboregdata.getNomineerelationship());
			registrationpage.enterComboNomineeName(comboregdata.getNomineename());
			registrationpage.enterComboNomineeMsisdn(comboregdata.getNomineemsisdn());
			registrationpage.selectHealthTipsFrequency(comboregdata.getHealthtip());
			registrationpage.selectHealthTipsLangauage(comboregdata.getHealthtiplang());
			registrationpage.clickSave();
			registrationpage.clickYes();
			boolean result=registrationpage.success_registration();
			Assert.assertTrue(result, "Successful Registration");
			}
			
		} catch (Exception e) {
			Assert.fail("Customer Registration failed");
			e.printStackTrace();
		}
	}
	
	@Test
	public void CombofamilyRegistrationTest()
	{
		try {
			List<ComboFamilyRegData> combofamilyreglist = ReadExcelData.readComboFamilyRegData();
			for(ComboFamilyRegData combofamilyregdata: combofamilyreglist)
			{
			log.debug(property);
			driver.get(property.getProperty("dashboard_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LoginPageObject loginpage=new LoginPageObject(driver);
			HomePageObject homepage=new HomePageObject(driver);
			RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
			loginpage.setUsername(property.getProperty("dashboard_username"));
			loginpage.setPassword(property.getProperty("dashboard_password"));
			loginpage.clickLogin();
			homepage.selectCusManagement();
			homepage.selectRegisterCustomer();
			registrationpage.enterCustomerMsisdn(combofamilyregdata.getMsisdn());
			registrationpage.clickSearch();
			if(registrationpage.isCustomerNameEnabled()== true)
			{
			registrationpage.enterCustomerName(combofamilyregdata.getCustomername(),driver);
			registrationpage.enterCustomerAge(combofamilyregdata.getAge());
			registrationpage.selectCustomerGender(combofamilyregdata.getGender());
			}
			registrationpage.selectPaidProduct(combofamilyregdata.getComboofferid());
			registrationpage.selectPaidProduct(combofamilyregdata.getFamilyofferid());
			registrationpage.selectComboNomineeRelationship(combofamilyregdata.getNomineerelationship());
			registrationpage.enterComboNomineeName(combofamilyregdata.getNomineename());
			registrationpage.enterComboNomineeMsisdn(combofamilyregdata.getNomineemsisdn());
			registrationpage.selectFamilyFirstBeneficiaryrelation(combofamilyregdata.getFirstbeneficiaryrelationship());
			registrationpage.enterFamilyFirstBeneficiaryName(combofamilyregdata.getFirstbeneficiaryname());
			registrationpage.enterFamilyFirstBeneficiaryMsisdn(combofamilyregdata.getFirstbeneficiarymsisdn());
			registrationpage.selectFamilyFirstBeneficiaryGender(combofamilyregdata.getFirstbeneficiarygender());
			registrationpage.enterFamilyFirstBeneficiaryAge(combofamilyregdata.getFirstbeneficiaryage());
			if(combofamilyregdata.getSecondbeneficiaryrelationship()!=null)
			{
			registrationpage.selectFamilySecondBeneficiaryrelation(combofamilyregdata.getSecondbeneficiaryrelationship());
			registrationpage.enterFamilySecondBeneficiaryName(combofamilyregdata.getSecondbeneficiaryname());
			registrationpage.enterFamilySecondBeneficiaryMsisdn(combofamilyregdata.getSecondbeneficiarymsisdn());
			registrationpage.selectFamilySecondBeneficiaryGender(combofamilyregdata.getSecondbeneficiarygender());
			registrationpage.enterFamilySecondBeneficiaryAge(combofamilyregdata.getSecondbeneficiaryage());
			}
			registrationpage.selectHealthTipsFrequency(combofamilyregdata.getHealthtip());
			registrationpage.selectHealthTipsLangauage(combofamilyregdata.getHealthtiplang());
			registrationpage.clickSave();
			registrationpage.clickYes();
			boolean result=registrationpage.success_registration();
			Assert.assertTrue(result, "Successful Registration");
			}
			
		} catch (Exception e) {
			Assert.fail("Customer Registration failed");
			e.printStackTrace();
		}
	}
	
	@Test
	public void familyRegistrationTest()
	{
		try {
			List<FamilyRegData> familylist = ReadExcelData.readFamilyRegData();
			for(FamilyRegData familyregdata: familylist)
			{
			driver.get(property.getProperty("dashboard_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LoginPageObject loginpage=new LoginPageObject(driver);
			HomePageObject homepage=new HomePageObject(driver);
			RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
			loginpage.setUsername(property.getProperty("dashboard_username"));
			loginpage.setPassword(property.getProperty("dashboard_password"));
			loginpage.clickLogin();
			homepage.selectCusManagement();
			homepage.selectRegisterCustomer();
			registrationpage.enterCustomerMsisdn(familyregdata.getMsisdn());
			registrationpage.clickSearch();
			/*
			 * ExistingCustomer Check
			 */
			if(registrationpage.isCustomerNameEnabled()== true)
			{
			registrationpage.enterCustomerName(familyregdata.getCustomername(),driver);
			registrationpage.enterCustomerAge(familyregdata.getAge());
			registrationpage.selectCustomerGender(familyregdata.getGender());
			}
			registrationpage.selectPaidProduct(familyregdata.getOfferid());
			registrationpage.selectFamilyFirstBeneficiaryrelation(familyregdata.getFirstbeneficiaryrelationship());
			registrationpage.enterFamilyFirstBeneficiaryName(familyregdata.getFirstbeneficiaryname());
			registrationpage.enterFamilyFirstBeneficiaryMsisdn(familyregdata.getFirstbeneficiarymsisdn());
			registrationpage.selectFamilyFirstBeneficiaryGender(familyregdata.getFirstbeneficiarygender());
			registrationpage.enterFamilyFirstBeneficiaryAge(familyregdata.getFirstbeneficiaryage());
			if(familyregdata.getSecondbeneficiaryrelationship()!=null)
			{
			registrationpage.selectFamilySecondBeneficiaryrelation(familyregdata.getSecondbeneficiaryrelationship());
			registrationpage.enterFamilySecondBeneficiaryName(familyregdata.getSecondbeneficiaryname());
			registrationpage.enterFamilySecondBeneficiaryMsisdn(familyregdata.getSecondbeneficiarymsisdn());
			registrationpage.selectFamilySecondBeneficiaryGender(familyregdata.getSecondbeneficiarygender());
			registrationpage.enterFamilySecondBeneficiaryAge(familyregdata.getSecondbeneficiaryage());
			}
			registrationpage.selectHealthTipsFrequency(familyregdata.getHealthtip());
			registrationpage.selectHealthTipsLangauage(familyregdata.getHealthtiplang());
			registrationpage.clickSave();
			registrationpage.clickYes();
			boolean result=registrationpage.success_registration();
			Assert.assertTrue(result, "Successful Registration");
			}
		} catch (Exception e) {
			Assert.fail("Customer Registration failed");
			e.printStackTrace();
		}
	}
	
	/*@Test
	public void freshComboBkashLifeRegistration()
	{
		try {
			driver.get(property.getProperty("dashboard_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LoginPageObject loginpage=new LoginPageObject(driver);
			HomePageObject homepage=new HomePageObject(driver);
			RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
			loginpage.setUsername(property.getProperty("dashboard_username"));
			loginpage.setPassword(property.getProperty("dashboard_password"));
			loginpage.clickLogin();
			homepage.selectCusManagement();
			homepage.selectRegisterCustomer();
			//Customer details
			registrationpage.enterCustomerMsisdn(property.getProperty("combo_blife_msisdn"));
			registrationpage.clickSearch();
			registrationpage.enterCustomerName(property.getProperty("combo_cusname"),driver);
			Integer age=new Integer(property.getProperty("combo_cusage"));
			registrationpage.enterCustomerAge(age);
			registrationpage.selectCustomerGender(property.getProperty("combo_cusgender"));
			//Product details
			Integer offer_id=new Integer(property.getProperty("combo_product_id"));
			registrationpage.selectPaidProduct(offer_id);
			Integer life_offer_id=new Integer(property.getProperty("bkash_life_product_id"));
			registrationpage.selectPaidProduct(life_offer_id);
			Integer life_cover_id=new Integer(property.getProperty("bkash_life_cover_id"));
			registrationpage.selectLifeCover(life_cover_id);
			//Payment info
			registrationpage.selectPaymentFrequency(property.getProperty("payment_frequency"));
			registrationpage.selectPaymentType(property.getProperty("payment_type"));
			//Combo nominee
			registrationpage.selectComboNomineeRelationship(property.getProperty("combo_nomrel"));
			registrationpage.enterComboNomineeName(property.getProperty("combo_nomname"));
			registrationpage.enterComboNomineeMsisdn(property.getProperty("combo_nommsisdn"));
			//BKash Life Nominee
			registrationpage.selectBKashLifeNomineeRelationship(property.getProperty("bkash_life_nomrel"));
			registrationpage.enterBKashLifeNomineeName(property.getProperty("bkash_life_nomname"));
			registrationpage.enterBKashLifeNomineeMsisdn(property.getProperty("bkash_life_nommsisdn"));
			Integer nom_age=new Integer(property.getProperty("bkash_life_nomage"));
			registrationpage.enterBKashLifeNomineeAge(nom_age);
			//Coaching programme
			Integer cp_id=new Integer(property.getProperty("combo_health_tips"));
			registrationpage.selectHealthTipsFrequency(cp_id);
			registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
			registrationpage.clickSave();
			registrationpage.clickYes();
			boolean result=registrationpage.success_registration();
			Assert.assertTrue(result, "Successful Registration");
		} catch (Exception e) {
			Assert.fail("Customer Registration failed");
			e.printStackTrace();
		}
	}

	@Test
	public void freshComboBkashHospRegistration()
	{
		try {
			driver.get(property.getProperty("dashboard_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LoginPageObject loginpage=new LoginPageObject(driver);
			HomePageObject homepage=new HomePageObject(driver);
			RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
			loginpage.setUsername(property.getProperty("dashboard_username"));
			loginpage.setPassword(property.getProperty("dashboard_password"));
			loginpage.clickLogin();
			homepage.selectCusManagement();
			homepage.selectRegisterCustomer();
			//Customer details
			registrationpage.enterCustomerMsisdn(property.getProperty("combo_bhosp_msisdn"));
			registrationpage.clickSearch();
			registrationpage.enterCustomerName(property.getProperty("combo_cusname"),driver);
			Integer age=new Integer(property.getProperty("combo_cusage"));
			registrationpage.enterCustomerAge(age);
			registrationpage.selectCustomerGender(property.getProperty("combo_cusgender"));
			//Product details
			Integer offer_id=new Integer(property.getProperty("combo_product_id"));
			registrationpage.selectPaidProduct(offer_id);
			Integer hosp_offer_id=new Integer(property.getProperty("bkash_hosp_product_id"));
			registrationpage.selectPaidProduct(hosp_offer_id);
			Integer hosp_cover_id=new Integer(property.getProperty("bkash_hosp_cover_id"));
			registrationpage.selectHospitalCover(hosp_cover_id);
			//Payment info
			registrationpage.selectPaymentFrequency(property.getProperty("payment_frequency"));
			registrationpage.selectPaymentType(property.getProperty("payment_type"));
			//Combo nominee
			registrationpage.selectComboNomineeRelationship(property.getProperty("combo_nomrel"));
			registrationpage.enterComboNomineeName(property.getProperty("combo_nomname"));
			registrationpage.enterComboNomineeMsisdn(property.getProperty("combo_nommsisdn"));
			//BKash Hosp Nominee and Beneficiary
			if(hosp_cover_id==15)
			{
				 //Nominee 
				registrationpage.selectBKashHospitalNomineeRelationship(property.getProperty("bkash_hosp_nomrel"));
				registrationpage.enterBKashHospitalNomineeName(property.getProperty("bkash_hosp_nomname"));
				registrationpage.enterBKashHospitalNomineeMsisdn(property.getProperty("bkash_hosp_nommsisdn"));
				Integer nom_age=new Integer(property.getProperty("bkash_hosp_nomage"));
				registrationpage.enterBKashHospitalNomineeAge(nom_age);
			}
			else if(hosp_cover_id==16)
			{
				// First Beneficiary 
				registrationpage.selectBKashHospitalFirstBeneficiaryRelationship(property.getProperty("bkash_hosp_ben1rel"));
				registrationpage.enterBKashHospitalFirstBeneficiaryName(property.getProperty("bkash_hosp_ben1name"));
				registrationpage.enterBKashHospitalFirstBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben1msisdn"));
				Integer ben1_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalFirstBeneficiaryAge(ben1_age);

			}
			else if(hosp_cover_id==17)
			{
				 //First Beneficiary 
				registrationpage.selectBKashHospitalFirstBeneficiaryRelationship(property.getProperty("bkash_hosp_ben1rel"));
				registrationpage.enterBKashHospitalFirstBeneficiaryName(property.getProperty("bkash_hosp_ben1name"));
				registrationpage.enterBKashHospitalFirstBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben1msisdn"));
				Integer ben1_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalFirstBeneficiaryAge(ben1_age);
				 //Second Beneficiary 
				registrationpage.selectBKashHospitalSecondBeneficiaryRelationship(property.getProperty("bkash_hosp_ben2rel"));
				registrationpage.enterBKashHospitalSecondBeneficiaryName(property.getProperty("bkash_hosp_ben2name"));
				registrationpage.enterBKashHospitalSecondBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben2msisdn"));
				Integer ben2_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalSecondBeneficiaryAge(ben2_age);
			}
			else if(hosp_cover_id==18)
			{
				 //First Beneficiary 
				registrationpage.selectBKashHospitalFirstBeneficiaryRelationship(property.getProperty("bkash_hosp_ben1rel"));
				registrationpage.enterBKashHospitalFirstBeneficiaryName(property.getProperty("bkash_hosp_ben1name"));
				registrationpage.enterBKashHospitalFirstBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben1msisdn"));
				Integer ben1_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalFirstBeneficiaryAge(ben1_age);
				 //Second Beneficiary 
				registrationpage.selectBKashHospitalSecondBeneficiaryRelationship(property.getProperty("bkash_hosp_ben2rel"));
				registrationpage.enterBKashHospitalSecondBeneficiaryName(property.getProperty("bkash_hosp_ben2name"));
				registrationpage.enterBKashHospitalSecondBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben2msisdn"));
				Integer ben2_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalSecondBeneficiaryAge(ben2_age);
				 //Third Beneficiary 
				registrationpage.selectBKashHospitalThirdBeneficiaryRelationship(property.getProperty("bkash_hosp_ben3rel"));
				registrationpage.enterBKashHospitalThirdBeneficiaryName(property.getProperty("bkash_hosp_ben3name"));
				registrationpage.enterBKashHospitalThirdBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben3msisdn"));
				Integer ben3_age=new Integer(property.getProperty("bkash_hosp_ben3age"));
				registrationpage.enterBKashHospitalThirdBeneficiaryAge(ben3_age);

			}
			//Coaching programme
			Integer cp_id=new Integer(property.getProperty("combo_health_tips"));
			registrationpage.selectHealthTipsFrequency(cp_id);
			registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
			registrationpage.clickSave();
			registrationpage.clickYes();
			boolean result=registrationpage.success_registration();
			Assert.assertTrue(result, "Successful Registration");
		} catch (Exception e) {
			Assert.fail("Customer Registration failed");
			e.printStackTrace();
		}
	}
	
	@Test
	public void freshFamilyRegistration()
	{
		try {
			driver.get(property.getProperty("dashboard_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LoginPageObject loginpage=new LoginPageObject(driver);
			HomePageObject homepage=new HomePageObject(driver);
			RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
			loginpage.setUsername(property.getProperty("dashboard_username"));
			loginpage.setPassword(property.getProperty("dashboard_password"));
			loginpage.clickLogin();
			homepage.selectCusManagement();
			homepage.selectRegisterCustomer();
			registrationpage.enterCustomerMsisdn(property.getProperty("family_msisdn"));
			registrationpage.clickSearch();
			registrationpage.enterCustomerName(property.getProperty("family_cusname"),driver);
			Integer age=new Integer(property.getProperty("family_cusage"));
			registrationpage.enterCustomerAge(age);
			registrationpage.selectCustomerGender(property.getProperty("family_cusgender"));
			Integer offer_id=new Integer(property.getProperty("family_product_id"));
			registrationpage.selectPaidProduct(offer_id);
			//Family Beneficiary
			registrationpage.selectFamilyFirstBeneficiaryrelation(property.getProperty("family_ben1rel"));
			registrationpage.enterFamilyFirstBeneficiaryName(property.getProperty("family_ben1name"));
			registrationpage.enterFamilyFirstBeneficiaryMsisdn(property.getProperty("family_ben1msisdn"));
			registrationpage.selectFamilyFirstBeneficiaryGender(property.getProperty("family_ben1gender"));
			registrationpage.enterFamilyFirstBeneficiaryAge(property.getProperty("family_ben1age"));
			registrationpage.selectFamilySecondBeneficiaryrelation(property.getProperty("family_ben2rel"));
			registrationpage.enterFamilySecondBeneficiaryName(property.getProperty("family_ben2name"));
			registrationpage.enterFamilySecondBeneficiaryMsisdn(property.getProperty("family_ben2msisdn"));
			registrationpage.selectFamilySecondBeneficiaryGender(property.getProperty("family_ben2gender"));
			registrationpage.enterFamilySecondBeneficiaryAge(property.getProperty("family_ben2age"));
			Integer cp_id=new Integer(property.getProperty("family_health_tips"));
			registrationpage.selectHealthTipsFrequency(cp_id);
			registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
			registrationpage.clickSave();
			registrationpage.clickYes();
			boolean result=registrationpage.success_registration();
			Assert.assertTrue(result, "Successful Registration");
		} catch (Exception e) {
			Assert.fail("Customer Registration failed");
			e.printStackTrace();
		}
	}
	
	@Test
	public void freshFamilyBKashLifeRegistration()
	{
		try {
			driver.get(property.getProperty("dashboard_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LoginPageObject loginpage=new LoginPageObject(driver);
			HomePageObject homepage=new HomePageObject(driver);
			RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
			loginpage.setUsername(property.getProperty("dashboard_username"));
			loginpage.setPassword(property.getProperty("dashboard_password"));
			loginpage.clickLogin();
			homepage.selectCusManagement();
			homepage.selectRegisterCustomer();
			//Customer details
			registrationpage.enterCustomerMsisdn(property.getProperty("family_blife_msisdn"));
			registrationpage.clickSearch();
			registrationpage.enterCustomerName(property.getProperty("family_cusname"),driver);
			Integer age=new Integer(property.getProperty("family_cusage"));
			registrationpage.enterCustomerAge(age);
			registrationpage.selectCustomerGender(property.getProperty("family_cusgender"));
			//product details
			Integer offer_id=new Integer(property.getProperty("family_product_id"));
			registrationpage.selectPaidProduct(offer_id);
			Integer life_offer_id=new Integer(property.getProperty("bkash_life_product_id"));
			registrationpage.selectPaidProduct(life_offer_id);
			Integer life_cover_id=new Integer(property.getProperty("bkash_life_cover_id"));
			registrationpage.selectLifeCover(life_cover_id);
			//Payment details
			registrationpage.selectPaymentFrequency(property.getProperty("payment_frequency"));
			registrationpage.selectPaymentType(property.getProperty("payment_type"));
			//Family Beneficiary
			registrationpage.selectFamilyFirstBeneficiaryrelation(property.getProperty("family_ben1rel"));
			registrationpage.enterFamilyFirstBeneficiaryName(property.getProperty("family_ben1name"));
			registrationpage.enterFamilyFirstBeneficiaryMsisdn(property.getProperty("family_ben1msisdn"));
			registrationpage.selectFamilyFirstBeneficiaryGender(property.getProperty("family_ben1gender"));
			registrationpage.enterFamilyFirstBeneficiaryAge(property.getProperty("family_ben1age"));
			registrationpage.selectFamilySecondBeneficiaryrelation(property.getProperty("family_ben2rel"));
			registrationpage.enterFamilySecondBeneficiaryName(property.getProperty("family_ben2name"));
			registrationpage.enterFamilySecondBeneficiaryMsisdn(property.getProperty("family_ben2msisdn"));
			registrationpage.selectFamilySecondBeneficiaryGender(property.getProperty("family_ben2gender"));
			registrationpage.enterFamilySecondBeneficiaryAge(property.getProperty("family_ben2age"));
		    //BKash Life Nominee
			registrationpage.selectBKashLifeNomineeRelationship(property.getProperty("bkash_life_nomrel"));
			registrationpage.enterBKashLifeNomineeName(property.getProperty("bkash_life_nomname"));
			registrationpage.enterBKashLifeNomineeMsisdn(property.getProperty("bkash_life_nommsisdn"));
			Integer nom_age=new Integer(property.getProperty("bkash_life_nomage"));
			registrationpage.enterBKashLifeNomineeAge(nom_age);
			Integer cp_id=new Integer(property.getProperty("family_health_tips"));
			registrationpage.selectHealthTipsFrequency(cp_id);
			registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
			registrationpage.clickSave();
			registrationpage.clickYes();
			boolean result=registrationpage.success_registration();
			Assert.assertTrue(result, "Successful Registration");
		} catch (Exception e) {
			Assert.fail("Customer Registration failed");
			e.printStackTrace();
		}
	}
	
	@Test
	public void freshFamilyBKashHospitalRegistration()
	{
		try {
			driver.get(property.getProperty("dashboard_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LoginPageObject loginpage=new LoginPageObject(driver);
			HomePageObject homepage=new HomePageObject(driver);
			RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
			loginpage.setUsername(property.getProperty("dashboard_username"));
			loginpage.setPassword(property.getProperty("dashboard_password"));
			loginpage.clickLogin();
			homepage.selectCusManagement();
			homepage.selectRegisterCustomer();
			//Customer details
			registrationpage.enterCustomerMsisdn(property.getProperty("family_msisdn"));
			registrationpage.clickSearch();
			registrationpage.enterCustomerName(property.getProperty("family_cusname"),driver);
			Integer age=new Integer(property.getProperty("family_cusage"));
			registrationpage.enterCustomerAge(age);
			registrationpage.selectCustomerGender(property.getProperty("family_cusgender"));
			//Product details
			Integer offer_id=new Integer(property.getProperty("family_product_id"));
			registrationpage.selectPaidProduct(offer_id);
			//Bkash hosp cover details
			Integer hosp_offer_id=new Integer(property.getProperty("bkash_hosp_product_id"));
			registrationpage.selectPaidProduct(hosp_offer_id);
			Integer hosp_cover_id=new Integer(property.getProperty("bkash_hosp_cover_id"));
			registrationpage.selectHospitalCover(hosp_cover_id);
			//Payment details
			registrationpage.selectPaymentFrequency(property.getProperty("payment_frequency"));
			registrationpage.selectPaymentType(property.getProperty("payment_type"));
			//Family Beneficiary
			registrationpage.selectFamilyFirstBeneficiaryrelation(property.getProperty("family_ben1rel"));
			registrationpage.enterFamilyFirstBeneficiaryName(property.getProperty("family_ben1name"));
			registrationpage.enterFamilyFirstBeneficiaryMsisdn(property.getProperty("family_ben1msisdn"));
			registrationpage.selectFamilyFirstBeneficiaryGender(property.getProperty("family_ben1gender"));
			registrationpage.enterFamilyFirstBeneficiaryAge(property.getProperty("family_ben1age"));
			registrationpage.selectFamilySecondBeneficiaryrelation(property.getProperty("family_ben2rel"));
			registrationpage.enterFamilySecondBeneficiaryName(property.getProperty("family_ben2name"));
			registrationpage.enterFamilySecondBeneficiaryMsisdn(property.getProperty("family_ben2msisdn"));
			registrationpage.selectFamilySecondBeneficiaryGender(property.getProperty("family_ben2gender"));
			registrationpage.enterFamilySecondBeneficiaryAge(property.getProperty("family_ben2age"));
			Integer cp_id=new Integer(property.getProperty("family_health_tips"));
			if(hosp_cover_id==15)
			{
				 //Nominee 
				registrationpage.selectBKashHospitalNomineeRelationship(property.getProperty("bkash_hosp_nomrel"));
				registrationpage.enterBKashHospitalNomineeName(property.getProperty("bkash_hosp_nomname"));
				registrationpage.enterBKashHospitalNomineeMsisdn(property.getProperty("bkash_hosp_nommsisdn"));
				Integer nom_age=new Integer(property.getProperty("bkash_hosp_nomage"));
				registrationpage.enterBKashHospitalNomineeAge(nom_age);
			}
			else if(hosp_cover_id==16)
			{
				// First Beneficiary 
				registrationpage.selectBKashHospitalFirstBeneficiaryRelationship(property.getProperty("bkash_hosp_ben1rel"));
				registrationpage.enterBKashHospitalFirstBeneficiaryName(property.getProperty("bkash_hosp_ben1name"));
				registrationpage.enterBKashHospitalFirstBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben1msisdn"));
				Integer ben1_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalFirstBeneficiaryAge(ben1_age);

			}
			else if(hosp_cover_id==17)
			{
				 //First Beneficiary 
				registrationpage.selectBKashHospitalFirstBeneficiaryRelationship(property.getProperty("bkash_hosp_ben1rel"));
				registrationpage.enterBKashHospitalFirstBeneficiaryName(property.getProperty("bkash_hosp_ben1name"));
				registrationpage.enterBKashHospitalFirstBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben1msisdn"));
				Integer ben1_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalFirstBeneficiaryAge(ben1_age);
				 //Second Beneficiary 
				registrationpage.selectBKashHospitalSecondBeneficiaryRelationship(property.getProperty("bkash_hosp_ben2rel"));
				registrationpage.enterBKashHospitalSecondBeneficiaryName(property.getProperty("bkash_hosp_ben2name"));
				registrationpage.enterBKashHospitalSecondBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben2msisdn"));
				Integer ben2_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalSecondBeneficiaryAge(ben2_age);
			}
			else if(hosp_cover_id==18)
			{
				 //First Beneficiary 
				registrationpage.selectBKashHospitalFirstBeneficiaryRelationship(property.getProperty("bkash_hosp_ben1rel"));
				registrationpage.enterBKashHospitalFirstBeneficiaryName(property.getProperty("bkash_hosp_ben1name"));
				registrationpage.enterBKashHospitalFirstBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben1msisdn"));
				Integer ben1_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalFirstBeneficiaryAge(ben1_age);
				 //Second Beneficiary 
				registrationpage.selectBKashHospitalSecondBeneficiaryRelationship(property.getProperty("bkash_hosp_ben2rel"));
				registrationpage.enterBKashHospitalSecondBeneficiaryName(property.getProperty("bkash_hosp_ben2name"));
				registrationpage.enterBKashHospitalSecondBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben2msisdn"));
				Integer ben2_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalSecondBeneficiaryAge(ben2_age);
				 //Third Beneficiary 
				registrationpage.selectBKashHospitalThirdBeneficiaryRelationship(property.getProperty("bkash_hosp_ben3rel"));
				registrationpage.enterBKashHospitalThirdBeneficiaryName(property.getProperty("bkash_hosp_ben3name"));
				registrationpage.enterBKashHospitalThirdBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben3msisdn"));
				Integer ben3_age=new Integer(property.getProperty("bkash_hosp_ben3age"));
				registrationpage.enterBKashHospitalThirdBeneficiaryAge(ben3_age);

			}
			//Coaching programme
			registrationpage.selectHealthTipsFrequency(cp_id);
			registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
			registrationpage.clickSave();
			registrationpage.clickYes();
			boolean result=registrationpage.success_registration();
			Assert.assertTrue(result, "Successful Registration");
		} catch (Exception e) {
			Assert.fail("Customer Registration failed");
			e.printStackTrace();
		}
	}

	@Test
	public void freshBkashLifeRegistration()
	{
		try {
			driver.get(property.getProperty("dashboard_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LoginPageObject loginpage=new LoginPageObject(driver);
			HomePageObject homepage=new HomePageObject(driver);
			RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
			loginpage.setUsername(property.getProperty("dashboard_username"));
			loginpage.setPassword(property.getProperty("dashboard_password"));
			loginpage.clickLogin();
			homepage.selectCusManagement();
			homepage.selectRegisterCustomer();
			registrationpage.enterCustomerMsisdn(property.getProperty("bkash_life_msisdn"));
			registrationpage.clickSearch();
			registrationpage.enterCustomerName(property.getProperty("bkash_life_cusname"),driver);
			Integer age=new Integer(property.getProperty("bkash_life_cusage"));
			registrationpage.enterCustomerAge(age);
			registrationpage.selectCustomerGender(property.getProperty("bkash_life_cusgender"));
			Integer offer_id=new Integer(property.getProperty("bkash_life_product_id"));
			registrationpage.selectPaidProduct(offer_id);
			Integer life_cover_id=new Integer(property.getProperty("bkash_life_cover_id"));
			registrationpage.selectLifeCover(life_cover_id);
			registrationpage.selectPaymentFrequency(property.getProperty("payment_frequency"));
			registrationpage.selectPaymentType(property.getProperty("payment_type"));
			//BKash Life Nominee
			registrationpage.selectBKashLifeNomineeRelationship(property.getProperty("bkash_life_nomrel"));
			registrationpage.enterBKashLifeNomineeName(property.getProperty("bkash_life_nomname"));
			registrationpage.enterBKashLifeNomineeMsisdn(property.getProperty("bkash_life_nommsisdn"));
			Integer nom_age=new Integer(property.getProperty("bkash_life_nomage"));
			registrationpage.enterBKashLifeNomineeAge(nom_age);
            Integer cp_id=new Integer(property.getProperty("health_tips"));
			registrationpage.selectHealthTipsFrequency(cp_id);
			registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
			registrationpage.clickSave();
			registrationpage.clickYes();
			boolean result=registrationpage.success_registration();
			Assert.assertTrue(result, "Successful Registration");
		} catch (Exception e) {
			Assert.fail("Customer Registration failed");
			e.printStackTrace();
		}
	}



@Test
public void freshBkashHospitalRegistration()
{
	try {
		driver.get(property.getProperty("dashboard_url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginPageObject loginpage=new LoginPageObject(driver);
		HomePageObject homepage=new HomePageObject(driver);
		RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
		loginpage.setUsername(property.getProperty("dashboard_username"));
		loginpage.setPassword(property.getProperty("dashboard_password"));
		loginpage.clickLogin();
		homepage.selectCusManagement();
		homepage.selectRegisterCustomer();
		registrationpage.enterCustomerMsisdn(property.getProperty("bkash_hosp_msisdn"));
		registrationpage.clickSearch();
		registrationpage.enterCustomerName(property.getProperty("bkash_hosp_cusname"),driver);
		Integer age=new Integer(property.getProperty("bkash_hosp_cusage"));
		registrationpage.enterCustomerAge(age);
		registrationpage.selectCustomerGender(property.getProperty("bkash_hosp_cusgender"));
		//Bkash hosp cover details
		Integer offer_id=new Integer(property.getProperty("bkash_hosp_product_id"));
		registrationpage.selectPaidProduct(offer_id);
		Integer hosp_cover_id=new Integer(property.getProperty("bkash_hosp_cover_id"));
		registrationpage.selectHospitalCover(hosp_cover_id);
		//Payment details
		registrationpage.selectPaymentFrequency(property.getProperty("payment_frequency"));
		registrationpage.selectPaymentType(property.getProperty("payment_type"));
		if(hosp_cover_id==15)
		{
			 //Nominee 
			registrationpage.selectBKashHospitalNomineeRelationship(property.getProperty("bkash_hosp_nomrel"));
			registrationpage.enterBKashHospitalNomineeName(property.getProperty("bkash_hosp_nomname"));
			registrationpage.enterBKashHospitalNomineeMsisdn(property.getProperty("bkash_hosp_nommsisdn"));
			Integer nom_age=new Integer(property.getProperty("bkash_hosp_nomage"));
			registrationpage.enterBKashHospitalNomineeAge(nom_age);
		}
		else if(hosp_cover_id==16)
		{
			// First Beneficiary 
			registrationpage.selectBKashHospitalFirstBeneficiaryRelationship(property.getProperty("bkash_hosp_ben1rel"));
			registrationpage.enterBKashHospitalFirstBeneficiaryName(property.getProperty("bkash_hosp_ben1name"));
			registrationpage.enterBKashHospitalFirstBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben1msisdn"));
			Integer ben1_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
			registrationpage.enterBKashHospitalFirstBeneficiaryAge(ben1_age);

		}
		else if(hosp_cover_id==17)
		{
			 //First Beneficiary 
			registrationpage.selectBKashHospitalFirstBeneficiaryRelationship(property.getProperty("bkash_hosp_ben1rel"));
			registrationpage.enterBKashHospitalFirstBeneficiaryName(property.getProperty("bkash_hosp_ben1name"));
			registrationpage.enterBKashHospitalFirstBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben1msisdn"));
			Integer ben1_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
			registrationpage.enterBKashHospitalFirstBeneficiaryAge(ben1_age);
			 //Second Beneficiary 
			registrationpage.selectBKashHospitalSecondBeneficiaryRelationship(property.getProperty("bkash_hosp_ben2rel"));
			registrationpage.enterBKashHospitalSecondBeneficiaryName(property.getProperty("bkash_hosp_ben2name"));
			registrationpage.enterBKashHospitalSecondBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben2msisdn"));
			Integer ben2_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
			registrationpage.enterBKashHospitalSecondBeneficiaryAge(ben2_age);
		}
		else if(hosp_cover_id==18)
		{
			 //First Beneficiary 
			registrationpage.selectBKashHospitalFirstBeneficiaryRelationship(property.getProperty("bkash_hosp_ben1rel"));
			registrationpage.enterBKashHospitalFirstBeneficiaryName(property.getProperty("bkash_hosp_ben1name"));
			registrationpage.enterBKashHospitalFirstBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben1msisdn"));
			Integer ben1_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
			registrationpage.enterBKashHospitalFirstBeneficiaryAge(ben1_age);
			 //Second Beneficiary 
			registrationpage.selectBKashHospitalSecondBeneficiaryRelationship(property.getProperty("bkash_hosp_ben2rel"));
			registrationpage.enterBKashHospitalSecondBeneficiaryName(property.getProperty("bkash_hosp_ben2name"));
			registrationpage.enterBKashHospitalSecondBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben2msisdn"));
			Integer ben2_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
			registrationpage.enterBKashHospitalSecondBeneficiaryAge(ben2_age);
			 //Third Beneficiary 
			registrationpage.selectBKashHospitalThirdBeneficiaryRelationship(property.getProperty("bkash_hosp_ben3rel"));
			registrationpage.enterBKashHospitalThirdBeneficiaryName(property.getProperty("bkash_hosp_ben3name"));
			registrationpage.enterBKashHospitalThirdBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben3msisdn"));
			Integer ben3_age=new Integer(property.getProperty("bkash_hosp_ben3age"));
			registrationpage.enterBKashHospitalThirdBeneficiaryAge(ben3_age);

		}
		    Integer cp_id=new Integer(property.getProperty("health_tips"));
			registrationpage.selectHealthTipsFrequency(cp_id);
			registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
		    registrationpage.clickSave();
		    registrationpage.clickYes();
		    boolean result=registrationpage.success_registration();
		    Assert.assertTrue(result, "Successful Registration");
	} catch (Exception e) {
		Assert.fail("Customer Registration failed");
		e.printStackTrace();
	}
}


@Test
public void freshBkashLifeandHospitalRegistration()
{
	try {
			driver.get(property.getProperty("dashboard_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LoginPageObject loginpage=new LoginPageObject(driver);
			HomePageObject homepage=new HomePageObject(driver);
			RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
			loginpage.setUsername(property.getProperty("dashboard_username"));
			loginpage.setPassword(property.getProperty("dashboard_password"));
			loginpage.clickLogin();
			homepage.selectCusManagement();
			homepage.selectRegisterCustomer();
			registrationpage.enterCustomerMsisdn(property.getProperty("bkash_life_hosp_msisdn"));
			registrationpage.clickSearch();
			registrationpage.enterCustomerName(property.getProperty("bkash_life_cusname"),driver);
			Integer age=new Integer(property.getProperty("bkash_life_cusage"));
			registrationpage.enterCustomerAge(age);
			registrationpage.selectCustomerGender(property.getProperty("bkash_life_cusgender"));
			Integer life_offer_id=new Integer(property.getProperty("bkash_life_product_id"));
			registrationpage.selectPaidProduct(life_offer_id);
			Integer hosp_offer_id=new Integer(property.getProperty("bkash_hosp_product_id"));
			registrationpage.selectPaidProduct(hosp_offer_id);
			Integer life_cover_id=new Integer(property.getProperty("bkash_life_cover_id"));
			registrationpage.selectLifeCover(life_cover_id);
			Integer hosp_cover_id=new Integer(property.getProperty("bkash_hosp_cover_id"));
			registrationpage.selectHospitalCover(hosp_cover_id);
			registrationpage.selectPaymentFrequency(property.getProperty("payment_frequency"));
			registrationpage.selectPaymentType(property.getProperty("payment_type"));
			//BKash Life Nominee
			registrationpage.selectBKashLifeNomineeRelationship(property.getProperty("bkash_life_nomrel"));
			registrationpage.enterBKashLifeNomineeName(property.getProperty("bkash_life_nomname"));
			registrationpage.enterBKashLifeNomineeMsisdn(property.getProperty("bkash_life_nommsisdn"));
			Integer nom_age=new Integer(property.getProperty("bkash_life_nomage"));
			registrationpage.enterBKashLifeNomineeAge(nom_age);
			if(hosp_cover_id==15)
			{
				 //Nominee 
				registrationpage.selectBKashHospitalNomineeRelationship(property.getProperty("bkash_hosp_nomrel"));
				registrationpage.enterBKashHospitalNomineeName(property.getProperty("bkash_hosp_nomname"));
				registrationpage.enterBKashHospitalNomineeMsisdn(property.getProperty("bkash_hosp_nommsisdn"));
				Integer hosp_nom_age=new Integer(property.getProperty("bkash_hosp_nomage"));
				registrationpage.enterBKashHospitalNomineeAge(hosp_nom_age);
			}
			else if(hosp_cover_id==16)
			{
				// First Beneficiary 
				registrationpage.selectBKashHospitalFirstBeneficiaryRelationship(property.getProperty("bkash_hosp_ben1rel"));
				registrationpage.enterBKashHospitalFirstBeneficiaryName(property.getProperty("bkash_hosp_ben1name"));
				registrationpage.enterBKashHospitalFirstBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben1msisdn"));
				Integer ben1_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalFirstBeneficiaryAge(ben1_age);

			}
			else if(hosp_cover_id==17)
			{
				 //First Beneficiary 
				registrationpage.selectBKashHospitalFirstBeneficiaryRelationship(property.getProperty("bkash_hosp_ben1rel"));
				registrationpage.enterBKashHospitalFirstBeneficiaryName(property.getProperty("bkash_hosp_ben1name"));
				registrationpage.enterBKashHospitalFirstBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben1msisdn"));
				Integer ben1_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalFirstBeneficiaryAge(ben1_age);
				 //Second Beneficiary 
				registrationpage.selectBKashHospitalSecondBeneficiaryRelationship(property.getProperty("bkash_hosp_ben2rel"));
				registrationpage.enterBKashHospitalSecondBeneficiaryName(property.getProperty("bkash_hosp_ben2name"));
				registrationpage.enterBKashHospitalSecondBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben2msisdn"));
				Integer ben2_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalSecondBeneficiaryAge(ben2_age);
			}
			else if(hosp_cover_id==18)
			{
				 //First Beneficiary 
				registrationpage.selectBKashHospitalFirstBeneficiaryRelationship(property.getProperty("bkash_hosp_ben1rel"));
				registrationpage.enterBKashHospitalFirstBeneficiaryName(property.getProperty("bkash_hosp_ben1name"));
				registrationpage.enterBKashHospitalFirstBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben1msisdn"));
				Integer ben1_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalFirstBeneficiaryAge(ben1_age);
				 //Second Beneficiary 
				registrationpage.selectBKashHospitalSecondBeneficiaryRelationship(property.getProperty("bkash_hosp_ben2rel"));
				registrationpage.enterBKashHospitalSecondBeneficiaryName(property.getProperty("bkash_hosp_ben2name"));
				registrationpage.enterBKashHospitalSecondBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben2msisdn"));
				Integer ben2_age=new Integer(property.getProperty("bkash_hosp_ben1age"));
				registrationpage.enterBKashHospitalSecondBeneficiaryAge(ben2_age);
				 //Third Beneficiary 
				registrationpage.selectBKashHospitalThirdBeneficiaryRelationship(property.getProperty("bkash_hosp_ben3rel"));
				registrationpage.enterBKashHospitalThirdBeneficiaryName(property.getProperty("bkash_hosp_ben3name"));
				registrationpage.enterBKashHospitalThirdBeneficiaryMsisdn(property.getProperty("bkash_hosp_ben3msisdn"));
				Integer ben3_age=new Integer(property.getProperty("bkash_hosp_ben3age"));
				registrationpage.enterBKashHospitalThirdBeneficiaryAge(ben3_age);

			}
            Integer cp_id=new Integer(property.getProperty("health_tips"));
			registrationpage.selectHealthTipsFrequency(cp_id);
			registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
			registrationpage.clickSave();
			registrationpage.clickYes();
			boolean result=registrationpage.success_registration();
			Assert.assertTrue(result, "Successful Registration");
		} catch (Exception e) {
			Assert.fail("Customer Registration failed");
			e.printStackTrace();
		}
}

@Test
public void freshComboandFamilyRegistration()
{
	try {
		driver.get(property.getProperty("dashboard_url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginPageObject loginpage=new LoginPageObject(driver);
		HomePageObject homepage=new HomePageObject(driver);
		RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
		loginpage.setUsername(property.getProperty("dashboard_username"));
		loginpage.setPassword(property.getProperty("dashboard_password"));
		loginpage.clickLogin();
		homepage.selectCusManagement();
		homepage.selectRegisterCustomer();
		registrationpage.enterCustomerMsisdn(property.getProperty("combo_family_msisdn"));
		registrationpage.clickSearch();
		registrationpage.enterCustomerName(property.getProperty("combo_cusname"),driver);
		Integer age=new Integer(property.getProperty("combo_cusage"));
		registrationpage.enterCustomerAge(age);
		registrationpage.selectCustomerGender(property.getProperty("combo_cusgender"));
		//Product Selection
		Integer combo_offer_id=new Integer(property.getProperty("combo_product_id"));
		registrationpage.selectPaidProduct(combo_offer_id);
		Integer family_offer_id=new Integer(property.getProperty("family_product_id"));
		registrationpage.selectPaidProduct(family_offer_id);
		//Combo Nominee
		registrationpage.selectComboNomineeRelationship(property.getProperty("combo_nomrel"));
		registrationpage.enterComboNomineeName(property.getProperty("combo_nomname"));
		registrationpage.enterComboNomineeMsisdn(property.getProperty("combo_nommsisdn"));
		//Family beneficiary
		registrationpage.selectFamilyFirstBeneficiaryrelation(property.getProperty("family_ben1rel"));
		registrationpage.enterFamilyFirstBeneficiaryName(property.getProperty("family_ben1name"));
		registrationpage.enterFamilyFirstBeneficiaryMsisdn(property.getProperty("family_ben1msisdn"));
		registrationpage.selectFamilyFirstBeneficiaryGender(property.getProperty("family_ben1gender"));
		registrationpage.enterFamilyFirstBeneficiaryAge(property.getProperty("family_ben1age"));
		registrationpage.selectFamilySecondBeneficiaryrelation(property.getProperty("family_ben2rel"));
		registrationpage.enterFamilySecondBeneficiaryName(property.getProperty("family_ben2name"));
		registrationpage.enterFamilySecondBeneficiaryMsisdn(property.getProperty("family_ben2msisdn"));
		registrationpage.selectFamilySecondBeneficiaryGender(property.getProperty("family_ben2gender"));
		registrationpage.enterFamilySecondBeneficiaryAge(property.getProperty("family_ben2age"));
		Integer cp_id=new Integer(property.getProperty("combo_health_tips"));
		registrationpage.selectHealthTipsFrequency(cp_id);
		registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
		registrationpage.clickSave();
		registrationpage.clickYes();
		boolean result=registrationpage.success_registration();
		Assert.assertTrue(result, "Successful Registration");
	} catch (Exception e) {
		Assert.fail("Customer Registration failed");
		e.printStackTrace();
	}
}

@Test(enabled=false)
public void freshComboFamilyBkashLifeRegistration()
{
	try {
		driver.get(property.getProperty("dashboard_url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginPageObject loginpage=new LoginPageObject(driver);
		HomePageObject homepage=new HomePageObject(driver);
		RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
		loginpage.setUsername(property.getProperty("dashboard_username"));
		loginpage.setPassword(property.getProperty("dashboard_password"));
		loginpage.clickLogin();
		homepage.selectCusManagement();
		homepage.selectRegisterCustomer();
		registrationpage.enterCustomerMsisdn(property.getProperty("combo_family_bkash_msisdn"));
		registrationpage.clickSearch();
		registrationpage.enterCustomerName(property.getProperty("combo_cusname"),driver);
		Integer age=new Integer(property.getProperty("combo_cusage"));
		registrationpage.enterCustomerAge(age);
		registrationpage.selectCustomerGender(property.getProperty("combo_cusgender"));
		//Product Selection
		Integer combo_offer_id=new Integer(property.getProperty("combo_product_id"));
		registrationpage.selectPaidProduct(combo_offer_id);
		Integer family_offer_id=new Integer(property.getProperty("family_product_id"));
		registrationpage.selectPaidProduct(family_offer_id);
		Integer offer_id=new Integer(property.getProperty("bkash_life_product_id"));
		registrationpage.selectPaidProduct(offer_id);
		//life cover details
		Integer life_cover_id=new Integer(property.getProperty("bkash_life_cover_id"));
		registrationpage.selectLifeCover(life_cover_id);
		//Payment details
		registrationpage.selectPaymentFrequency(property.getProperty("payment_frequency"));
		registrationpage.selectPaymentType(property.getProperty("payment_type"));
		//Combo Nominee
		registrationpage.selectComboNomineeRelationship(property.getProperty("combo_nomrel"));
		registrationpage.enterComboNomineeName(property.getProperty("combo_nomname"));
		registrationpage.enterComboNomineeMsisdn(property.getProperty("combo_nommsisdn"));
		//Family beneficiary
		registrationpage.selectFamilyFirstBeneficiaryrelation(property.getProperty("family_ben1rel"));
		registrationpage.enterFamilyFirstBeneficiaryName(property.getProperty("family_ben1name"));
		registrationpage.enterFamilyFirstBeneficiaryMsisdn(property.getProperty("family_ben1msisdn"));
		registrationpage.selectFamilyFirstBeneficiaryGender(property.getProperty("family_ben1gender"));
		registrationpage.enterFamilyFirstBeneficiaryAge(property.getProperty("family_ben1age"));
		registrationpage.selectFamilySecondBeneficiaryrelation(property.getProperty("family_ben2rel"));
		registrationpage.enterFamilySecondBeneficiaryName(property.getProperty("family_ben2name"));
		registrationpage.enterFamilySecondBeneficiaryMsisdn(property.getProperty("family_ben2msisdn"));
		registrationpage.selectFamilySecondBeneficiaryGender(property.getProperty("family_ben2gender"));
		registrationpage.enterFamilySecondBeneficiaryAge(property.getProperty("family_ben2age"));
		//BKash Life Nominee
		registrationpage.selectBKashLifeNomineeRelationship(property.getProperty("bkash_life_nomrel"));
		registrationpage.enterBKashLifeNomineeName(property.getProperty("bkash_life_nomname"));
		registrationpage.enterBKashLifeNomineeMsisdn(property.getProperty("bkash_life_nommsisdn"));
		Integer nom_age=new Integer(property.getProperty("bkash_life_nomage"));
		registrationpage.enterBKashLifeNomineeAge(nom_age);
		//Coaching programme
		Integer cp_id=new Integer(property.getProperty("combo_health_tips"));
		registrationpage.selectHealthTipsFrequency(cp_id);
		registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
		registrationpage.clickSave();
		registrationpage.clickYes();
		boolean result=registrationpage.success_registration();
		Assert.assertTrue(result, "Successful Registration");
	} catch (Exception e) {
		Assert.fail("Customer Registration failed");
		e.printStackTrace();
	}
}

@Test
public void freshFamilyBkashLifeRegistration()
{
	try {
		driver.get(property.getProperty("dashboard_url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginPageObject loginpage=new LoginPageObject(driver);
		HomePageObject homepage=new HomePageObject(driver);
		RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
		loginpage.setUsername(property.getProperty("dashboard_username"));
		loginpage.setPassword(property.getProperty("dashboard_password"));
		loginpage.clickLogin();
		homepage.selectCusManagement();
		homepage.selectRegisterCustomer();
		registrationpage.enterCustomerMsisdn(property.getProperty("combo_family_msisdn"));
		registrationpage.clickSearch();
		registrationpage.enterCustomerName(property.getProperty("combo_cusname"),driver);
		Integer age=new Integer(property.getProperty("combo_cusage"));
		registrationpage.enterCustomerAge(age);
		registrationpage.selectCustomerGender(property.getProperty("combo_cusgender"));
		//Product Selection
		Integer family_offer_id=new Integer(property.getProperty("family_product_id"));
		registrationpage.selectPaidProduct(family_offer_id);
		Integer life_offer_id=new Integer(property.getProperty("bkash_life_product_id"));
		registrationpage.selectPaidProduct(life_offer_id);
		String life_cover=property.getProperty("bkash_life_cover_id");
		//registrationpage.selectLifeCover(life_cover);
		registrationpage.selectPaymentFrequency(property.getProperty("payment_frequency"));
		registrationpage.selectPaymentType(property.getProperty("payment_type"));
		//Combo Nominee
		registrationpage.selectComboNomineeRelationship(property.getProperty("combo_nomrel"));
		registrationpage.enterComboNomineeName(property.getProperty("combo_nomname"));
		registrationpage.enterComboNomineeMsisdn(property.getProperty("combo_nommsisdn"));
		//Family Beneficiary
		registrationpage.selectFamilyFirstBeneficiaryrelation(property.getProperty("family_ben1rel"));
		registrationpage.enterFamilyFirstBeneficiaryName(property.getProperty("family_ben1name"));
		registrationpage.enterFamilyFirstBeneficiaryMsisdn(property.getProperty("family_ben1msisdn"));
		registrationpage.selectFamilyFirstBeneficiaryGender(property.getProperty("family_ben1gender"));
		registrationpage.enterFamilyFirstBeneficiaryAge(property.getProperty("family_ben1age"));
		registrationpage.selectFamilySecondBeneficiaryrelation(property.getProperty("family_ben2rel"));
		registrationpage.enterFamilySecondBeneficiaryName(property.getProperty("family_ben2name"));
		registrationpage.enterFamilySecondBeneficiaryMsisdn(property.getProperty("family_ben2msisdn"));
		registrationpage.selectFamilySecondBeneficiaryGender(property.getProperty("family_ben2gender"));
		registrationpage.enterFamilySecondBeneficiaryAge(property.getProperty("family_ben2age"));
		//BKash Life Nominee
		registrationpage.selectBKashLifeNomineeRelationship(property.getProperty("bkash_life_nomrel"));
		registrationpage.enterBKashLifeNomineeName(property.getProperty("bkash_life_nomname"));
		registrationpage.enterBKashLifeNomineeMsisdn(property.getProperty("bkash_life_nommsisdn"));
		Integer nom_age=new Integer(property.getProperty("bkash_life_nomage"));
		registrationpage.enterBKashLifeNomineeAge(nom_age);
		Integer cp_id=new Integer(property.getProperty("combo_health_tips"));
		registrationpage.selectHealthTipsFrequency(cp_id);
		registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
		registrationpage.clickSave();
		registrationpage.clickYes();
		boolean result=registrationpage.success_registration();
		Assert.assertTrue(result, "Successful Registration");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

@Test
public void freshComboBkashLifeRegistratio()
{
	try {
		driver.get(property.getProperty("dashboard_url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginPageObject loginpage=new LoginPageObject(driver);
		HomePageObject homepage=new HomePageObject(driver);
		RegisterCustomerPageObjects registrationpage=new RegisterCustomerPageObjects(driver);
		loginpage.setUsername(property.getProperty("dashboard_username"));
		loginpage.setPassword(property.getProperty("dashboard_password"));
		loginpage.clickLogin();
		homepage.selectCusManagement();
		homepage.selectRegisterCustomer();
		registrationpage.enterCustomerMsisdn(property.getProperty("combo_family_msisdn"));
		registrationpage.clickSearch();
		registrationpage.enterCustomerName(property.getProperty("combo_cusname"),driver);
		Integer age=new Integer(property.getProperty("combo_cusage"));
		registrationpage.enterCustomerAge(age);
		registrationpage.selectCustomerGender(property.getProperty("combo_cusgender"));
		//Product Selection
		Integer family_offer_id=new Integer(property.getProperty("family_product_id"));
		registrationpage.selectPaidProduct(family_offer_id);
		Integer life_offer_id=new Integer(property.getProperty("bkash_life_product_id"));
		registrationpage.selectPaidProduct(life_offer_id);
		String life_cover=property.getProperty("bkash_life_cover_id");
		//registrationpage.selectLifeCover(life_cover);
		registrationpage.selectPaymentFrequency(property.getProperty("payment_frequency"));
		registrationpage.selectPaymentType(property.getProperty("payment_type"));
		//Combo Nominee
		registrationpage.selectComboNomineeRelationship(property.getProperty("combo_nomrel"));
		registrationpage.enterComboNomineeName(property.getProperty("combo_nomname"));
		registrationpage.enterComboNomineeMsisdn(property.getProperty("combo_nommsisdn"));
		//BKash Life Nominee
		registrationpage.selectBKashLifeNomineeRelationship(property.getProperty("bkash_life_nomrel"));
		registrationpage.enterBKashLifeNomineeName(property.getProperty("bkash_life_nomname"));
		registrationpage.enterBKashLifeNomineeMsisdn(property.getProperty("bkash_life_nommsisdn"));
		Integer nom_age=new Integer(property.getProperty("bkash_life_nomage"));
		registrationpage.enterBKashLifeNomineeAge(nom_age);
		Integer cp_id=new Integer(property.getProperty("combo_health_tips"));
		registrationpage.selectHealthTipsFrequency(cp_id);
		registrationpage.selectHealthTipsLangauage(property.getProperty("health_tips_lang"));
		registrationpage.clickSave();
		registrationpage.clickYes();
		boolean result=registrationpage.success_registration();
		Assert.assertTrue(result, "Successful Registration");
	} catch (Exception e) {
		e.printStackTrace();
	}
}*/

	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}



