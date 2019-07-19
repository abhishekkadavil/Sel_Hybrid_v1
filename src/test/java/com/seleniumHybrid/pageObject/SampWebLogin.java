package com.seleniumHybrid.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumHybrid.testCase.BaseClass;
import com.seleniumHybrid.utils.Log;

public class SampWebLogin extends BaseClass {
	
	WebDriver Idriver;
	
	public SampWebLogin(WebDriver rdriver)
	{
		Idriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="email")
	@CacheLookup
	private WebElement txtUserName;
	
	@FindBy(name="passwd")
	@CacheLookup
	private WebElement txtPassword;
	
	@FindBy(name="SubmitLogin")
	@CacheLookup
	private WebElement btnLogin;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
		Log.info("username entered");
	}
	
	public void setPaswword(String password)
	{
		txtUserName.sendKeys(password);
		Log.info("password entered");
	}
	
	public void clickSubmitButton()
	{
		btnLogin.click();
		Log.info("login button clicked");
	}

}
