package com.Vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(name="user_name")
	private WebElement userName;
	@FindBy(name="user_password")
	private WebElement passWord;
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void login(String un,String pwd) {
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
		loginBtn.click();
	}

	
}
