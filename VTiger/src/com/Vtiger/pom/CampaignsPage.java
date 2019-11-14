package com.Vtiger.pom;


import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CampaignsPage 
{
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement camp; 
	@FindBy(xpath="//td[text()='A']")
	private WebElement alphA;
	@FindBy(xpath="//td[text()='E']")
	private WebElement alphE;
	@FindBy(xpath="//td[@class='lvtCol']")
	private List<WebElement> res;
	@FindBy(xpath="//td/input[@name='search_text']")
	private WebElement searchCampaign;
	@FindBy(name="search_field")
	private WebElement selin;
	@FindBy(xpath="//td/input[@name='submit']")
	private WebElement searchNow;
	@FindBy(xpath="//td[@class='moduleName']")
	private WebElement moduleName;
	public CampaignsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void selInsearchBy()
	{
		Select s = new Select(selin);
		s.selectByValue("campaignname");
		searchNow.click();
	}
	public void selInsearchBytype()
	{
		Select s = new Select(selin);
		s.selectByValue("campaigntype");
		searchCampaign.sendKeys("Conference");
		searchNow.click();
	}

	public void search(String text)
	{
		searchCampaign.sendKeys(text);
	}
	public void clickmoduleNme() 
	{
	moduleName.click();	
	}
	public void clickCamp() 
	{
	camp.click();	
	}
	public void clickA()
	{
		alphA.click();
	}
	public void clickE()
	{
		alphE.click();
	}
	@FindBy(xpath ="//a[text()='Achieve']")
	private WebElement cname;
	@FindBy(xpath="//td[@width='2%']/input[@id='56']")
	private WebElement checktoDel;
	@FindBy(xpath="//td/a/img[@title='Create Campaign...']")
	private WebElement plus;
	@FindBy(xpath="//tr/td/input[@name='campaignname']")
	private WebElement camName;
	@FindBy(xpath="//div/input[@class='crmButton small save']")
	private WebElement createNsave;
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement cNameCreated;
	public void sendcanName(String text)
	{
		camName.sendKeys(text);
	}
	public void clickcreateandSave()
	{
		createNsave.click();
	}
	public void clickPlus()
	{
		plus.click();
	}
	public void tickcamptodel()
	{
		
		checktoDel.click();
	}
	@FindBy(xpath="//tbody/tr/td/input[@class='crmbutton small delete']")
	private WebElement delbutton;
	public void clickdel()
	{
		delbutton.click();
	}
	public void verifyCnameswithLetterA(WebDriver driver, long ETO)
	{
		String cNames = cname.getText();
		System.out.println(cNames);
		boolean res = cNames.contains("A");
		Assert.assertEquals(true, res);
		Reporter.log("Campaigns starting with letter A is displayed",true);
	}
	public void verifyCnameswithLetterE(WebDriver driver, long ETO)
	{
		String cNames = cname.getText();
		System.out.println(cNames);
		boolean res = cNames.contains("E");
		Assert.assertEquals(true, res);
		Reporter.log("Campaigns starting with letter E is displayed",true);
	}
	public void verifydelAlertmessage(WebDriver driver, long ETO)
			throws EncryptedDocumentException, InvalidFormatException {
		Alert a =driver.switchTo().alert();
		try {
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.alertIsPresent());
			a.accept();
			Reporter.log("Alert is present", true);
		} 
		catch (Exception e) 
		{
			Reporter.log("Alert message is not appeared ", true);
			Assert.fail();
		}
	}
	public void verifyCampaignName(WebDriver driver, long ETO, String title)
			throws EncryptedDocumentException, InvalidFormatException {
		try {
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.textToBePresentInElement(cNameCreated, title));
			Reporter.log("Campaign name matches", true);
		} 
		catch (Exception e) 
		{
			Reporter.log("Campaign name doesnt match", true);
			Assert.fail();
		}
	}
}
