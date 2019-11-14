package com.Vtiger.pom;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath="//a[text()='More']")
	private WebElement more;
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaign;
	@FindBy(id="qccombo")
	private WebElement quickList;
	@FindBy(name="campaignname")
	private WebElement cName;
	@FindBy(name="campaigntype")
	private WebElement cType;
	@FindBy(name="button")
	private WebElement save;
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement createdCname;
	@FindBy(className="searchBox")
	private WebElement search;
	@FindBy(xpath="//td[@onclick='UnifiedSearch_SelectModuleForm(this);']")
	private WebElement searchdrop;
	@FindBy(xpath="//td[text()='Campaigns']")
	private WebElement tickCam;
	@FindBy(xpath="//td/input[@class='searchBtn']")
	private WebElement mag;
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void moreClick() 
	{
		more.click();
	}
	public void clickCampaign()
	{
		campaign.click();
	}
	public void selectCampaign()
	{
		Select s = new Select(quickList);
		s.selectByValue("Campaigns");
	}
	public void sendCName(String text)
	{
		cName.sendKeys(text);
	}
	public void selectCType()
	{
		Select s = new Select(cType);
		s.selectByValue("Conference");
	}
    public void clickSave()
    {
    	save.click();
    }
    public void quickList()
    {
    	quickList.click();
    }
    public void searchSend()
    {
    	search.sendKeys("Excell");
    }
    public void clicksearchdrop()
	{
		searchdrop.click();
	}
    public void clicktickCampaign()
	{
		tickCam.click();
	}
    public void clickmag()
	{
		mag.click();
	}
	public void verifyCampaignName(WebDriver driver, long ETO, String title)
			throws EncryptedDocumentException, InvalidFormatException {
		try {
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.textToBePresentInElement(createdCname, title));
			Reporter.log("Campaign name matches", true);
		} 
		catch (Exception e) 
		{
			Reporter.log("Campaign name doesnt match", true);
			Assert.fail();
		}
	}
	public void verifyCampaignwithoutNameisCreated(WebDriver driver, long ETO)
			throws EncryptedDocumentException, InvalidFormatException {
		Alert a =driver.switchTo().alert();
		try {
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.alertIsPresent());
			a.accept();
			Reporter.log("Enter name for campaign", true);
		} 
		catch (Exception e) 
		{
			Reporter.log("Alert message is not appeared ", true);
			Assert.fail();
		}
	}
	
	  public void verifyCampaignwithoutNameisCreatedAlertMsge(WebDriver driver, long ETO)
	  { 
		  
		  try {
			  WebDriverWait ww = new WebDriverWait(driver, ETO);
			  Alert a=driver.switchTo().alert();
			  ww.until(ExpectedConditions.alertIsPresent());
			  String act = a.getText();
			  String exp="Campaign Name cannot be empty";
			  Thread.sleep(5000);
			  a.accept();
			  Assert.assertEquals(act, exp);
			  Reporter.log("Alert message text matches is as expected",true);
		  }
		  catch(Exception e)
		  { 
			  Reporter.log("Alert message is innapropriate",true); 
		  Assert.fail();
		  }


	  }
	  
	 
	  
}
