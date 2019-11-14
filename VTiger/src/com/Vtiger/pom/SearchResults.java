package com.Vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.Vtiger.genericmethods.BaseTest;
import com.Vtiger.genericmethods.Excel;

import org.junit.Assert;
public class SearchResults extends BaseTest{
	public SearchResults(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//td/a[@id='1']")
private WebElement searchres;
@FindBy(xpath="//td/span[@vtfieldname='campaignname']")
private WebElement searchinName;
@FindBy(xpath="//td/span[@vtfieldname='campaigntype']")
private WebElement searchInType;
@FindBy(xpath="//td/a[@title='Campaigns']")
private WebElement names;
public void verifysearchresult()
{
	String searchresult = searchres.getText(); 
	System.out.println(searchresult); 
	Assert.assertEquals("Excell", searchresult);
	Reporter.log("Search result verified",true);
}
public void verifysearchresultsINSearchBy() throws InterruptedException
{
	String searchresult = names.getText(); 
	Thread.sleep(6000);
	System.out.println(searchresult);
	Thread.sleep(6000);
	String cname =Excel.getData(XL_PATH, HOMEPAGE_SHEET, 5, 0); 
	Assert.assertEquals(cname, searchresult);
	Reporter.log("Search result verified",true);
}
public void verifysearchresultsINSearchByType() throws InterruptedException
{
	
	String searchresult = searchInType.getText(); 
	Thread.sleep(6000);
	System.out.println(searchresult);
	Thread.sleep(6000);
	String ctype =Excel.getData(XL_PATH, HOMEPAGE_SHEET, 7, 0); 
	System.out.println(ctype);
	Assert.assertEquals(ctype, searchresult);
	Reporter.log("Search result verified",true);
}
}