
package com.Vtiger.test;

import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Vtiger.genericmethods.BaseTest;
import com.Vtiger.genericmethods.Excel;
import com.Vtiger.pom.CampaignsPage;
import com.Vtiger.pom.HomePage;
import com.Vtiger.pom.LoginPage;
import com.Vtiger.pom.SearchResults;

public class TestQuickCreateCampaign extends BaseTest {
	
	
	
	  @Test(priority = 1) public static void testquickCreateCampaign() throws
	  EncryptedDocumentException, InvalidFormatException, InterruptedException {
	  String un = Excel.getData(XL_PATH, LOGIN_SHEET, 1, 0); String pwd =
	  Excel.getData(XL_PATH, LOGIN_SHEET, 1, 1); String cname
	  =Excel.getData(XL_PATH, HOMEPAGE_SHEET, 1, 0); LoginPage l = new
	  LoginPage(driver); l.login(un,pwd);HomePage h= new HomePage(driver);
	  Thread.sleep(3000); h.moreClick(); h.selectCampaign(); h.sendCName(cname);
	  h.selectCType(); h.clickSave(); h.verifyCampaignName(driver, 10, cname); }
	  
	  @Test(priority = 2) public static void testquickCreateCampaignwithoutname()
	  throws EncryptedDocumentException, InvalidFormatException,
	  InterruptedException { String un = Excel.getData(XL_PATH, LOGIN_SHEET, 1, 0);
	  String pwd = Excel.getData(XL_PATH, LOGIN_SHEET, 1, 1); LoginPage l = new
	  LoginPage(driver); l.login(un,pwd); HomePage h = new HomePage(driver);
	  Thread.sleep(3000); h.moreClick(); h.selectCampaign(); h.selectCType();
	  Thread.sleep(3000); h.clickSave(); Thread.sleep(3000);
	  h.verifyCampaignwithoutNameisCreated(driver, 10); Thread.sleep(3000);
	  
	  }
	  
	  @Test(priority = 3) public static void
	  testquickCreateCampaignwithoutnameAlertMessage() throws
	  EncryptedDocumentException, InvalidFormatException, InterruptedException {
	  String un = Excel.getData(XL_PATH, LOGIN_SHEET, 1, 0); String pwd
	  =Excel.getData(XL_PATH, LOGIN_SHEET,1, 1); LoginPage l = new
	  LoginPage(driver); l.login(un,pwd); HomePage h = new HomePage(driver);
	  Thread.sleep(3000); h.moreClick(); h.selectCampaign(); h.selectCType();
	  Thread.sleep(3000); h.clickSave(); Thread.sleep(3000);
	  h.verifyCampaignwithoutNameisCreatedAlertMsge(driver,10); }
	  
	  
	  @Test(priority = 4) public static void testsearcgCampaignwithletterA() throws
	  EncryptedDocumentException, InvalidFormatException, InterruptedException {
	  String un = Excel.getData(XL_PATH, LOGIN_SHEET, 1, 0); String pwd
	  =Excel.getData(XL_PATH, LOGIN_SHEET,1, 1); LoginPage l = new
	  LoginPage(driver); l.login(un,pwd); HomePage h= new HomePage(driver);
	  h.moreClick(); Thread.sleep(3000); CampaignsPage cp = new
	  CampaignsPage(driver); cp.clickCamp(); cp.clickA();
	  cp.verifyCnameswithLetterA(driver, 10);
	  
	  }
	  
	  @Test(priority = 5) public static void testsearcgCampaignwithletterE() throws
	  EncryptedDocumentException, InvalidFormatException, InterruptedException {
	  String un = Excel.getData(XL_PATH, LOGIN_SHEET, 1, 0); String
	  pwd=Excel.getData(XL_PATH, LOGIN_SHEET,1, 1); LoginPage l = new
	  LoginPage(driver); l.login(un,pwd); HomePage h= new HomePage(driver);
	  h.moreClick(); Thread.sleep(3000); CampaignsPage cp = new
	  CampaignsPage(driver); cp.clickCamp(); cp.clickE(); Thread.sleep(3000);
	  List<WebElement> cnameE =
	  driver.findElements(By.xpath("//td/a[@title='Campaigns']"));
	  Thread.sleep(3000); for(WebElement names: cnameE) { String cNames =
	  names.getText(); System.out.println(cNames); boolean res =
	  cNames.contains("E"); Assert.assertEquals(true, res);
	  
	  } Reporter.log("Campaigns starting with letter E is displayed",true);
	  //cp.verifyCnameswithLetterE(driver, 10)
	  ; }
	  
	  @Test(priority = 6) public static void testsearcgCampaign() throws
	  EncryptedDocumentException, InvalidFormatException, InterruptedException {
	  String un = Excel.getData(XL_PATH, LOGIN_SHEET, 1, 0); String pwd
	  =Excel.getData(XL_PATH, LOGIN_SHEET,1, 1); LoginPage l = new
	  LoginPage(driver); l.login(un,pwd); HomePage h= new HomePage(driver);
	  h.searchSend(); h.clicksearchdrop(); Thread.sleep(3000);
	  h.clicktickCampaign(); Thread.sleep(3000); h.clickmag(); Thread.sleep(4000);
	  SearchResults s = new SearchResults(driver); Thread.sleep(3000);
	  s.verifysearchresult(); }
	  
	  
	  
	  @Test(priority = 7) public static void deleteCampaignAlertAppears() throws
	  EncryptedDocumentException, InvalidFormatException, InterruptedException {
	  String un = Excel.getData(XL_PATH, LOGIN_SHEET, 1, 0); String
	  pwd=Excel.getData(XL_PATH, LOGIN_SHEET,1, 1); String cname
	  =Excel.getData(XL_PATH, HOMEPAGE_SHEET, 3, 0); LoginPage l = new
	  LoginPage(driver);l.login(un,pwd);
	  
	  HomePage h= new HomePage(driver); 
	  h.quickList(); h.selectCampaign();
	  Thread.sleep(4000); 
	  h.sendCName(cname); 
	  h.selectCType();
	  h.clickSave();
	  Thread.sleep(4000); 
	  h.moreClick(); 
	  Thread.sleep(3000); 
	  CampaignsPage cp = new CampaignsPage(driver); 
	  cp.clickCamp();
	  Thread.sleep(3000);
	  cp.tickcamptodel(); cp.clickdel(); Thread.sleep(3000);
	  cp.verifydelAlertmessage(driver, 10);
	  
	  }
	  
	  
	  @Test(priority = 8) public static void createCampaignbyNmae() throws
	  EncryptedDocumentException, InvalidFormatException, InterruptedException {
	  String un = Excel.getData(XL_PATH, LOGIN_SHEET, 1, 0); String
	  pwd=Excel.getData(XL_PATH, LOGIN_SHEET,1, 1); String cname
	  =Excel.getData(XL_PATH, HOMEPAGE_SHEET, 4, 0); LoginPage l = new
	  LoginPage(driver); l.login(un,pwd); HomePage h = new HomePage(driver);
	  h.moreClick(); Thread.sleep(3000); CampaignsPage cp = new
	  CampaignsPage(driver); cp.clickCamp(); Thread.sleep(2000); cp.clickPlus();
	  Thread.sleep(3000); cp.sendcanName(cname);
	  
	  h.selectCType(); Thread.sleep(3000); cp.clickcreateandSave();
	  cp.verifyCampaignName(driver, 10, cname);
	  
	  }
	 
	
	  
	  @Test(priority = 9) public static void searchCampaignbyName() throws
	  EncryptedDocumentException, InvalidFormatException, InterruptedException {
	  String un = Excel.getData(XL_PATH, LOGIN_SHEET, 1, 0); String
	  pwd=Excel.getData(XL_PATH, LOGIN_SHEET,1, 1); String cname
	  =Excel.getData(XL_PATH, HOMEPAGE_SHEET, 5, 0); LoginPage l = new
	  LoginPage(driver); l.login(un,pwd); HomePage h = new HomePage(driver);
	  h.moreClick(); Thread.sleep(3000); CampaignsPage cp = new
	  CampaignsPage(driver); cp.clickCamp(); Thread.sleep(2000); cp.clickPlus();
	  Thread.sleep(3000); cp.sendcanName(cname); h.selectCType();
	  Thread.sleep(3000); cp.clickcreateandSave(); cp.clickmoduleNme();
	  cp.search(cname); cp.selInsearchBy(); Thread.sleep(8000); SearchResults s =
	  new SearchResults(driver); s.verifysearchresultsINSearchBy(); }
	 
	/*
	 * @Test(priority = 10) public static void searchCampaignbyType() throws
	 * EncryptedDocumentException, InvalidFormatException, InterruptedException {
	 * String un = Excel.getData(XL_PATH, LOGIN_SHEET, 1, 0); String
	 * pwd=Excel.getData(XL_PATH, LOGIN_SHEET,1, 1); String cname
	 * =Excel.getData(XL_PATH, HOMEPAGE_SHEET, 6, 0); LoginPage l = new
	 * LoginPage(driver); l.login(un,pwd); HomePage h = new HomePage(driver);
	 * h.moreClick(); Thread.sleep(3000); CampaignsPage cp = new
	 * CampaignsPage(driver); cp.clickCamp(); Thread.sleep(2000); cp.clickPlus();
	 * Thread.sleep(3000); cp.sendcanName(cname); h.selectCType();
	 * Thread.sleep(3000); cp.clickcreateandSave(); cp.clickmoduleNme();
	 * cp.selInsearchBytype(); Thread.sleep(10000); SearchResults s = new
	 * SearchResults(driver); s.verifysearchresultsINSearchByType(); }
	 */
}

