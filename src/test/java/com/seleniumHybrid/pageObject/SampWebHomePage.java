package com.seleniumHybrid.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.seleniumHybrid.testCase.BaseClass;

public class SampWebHomePage extends BaseClass {
	
	WebDriver Idriver;
	private WebElement btnSignIn=driver.findElement(By.className("login"));
	
	public SampWebHomePage(WebDriver rdriver)
	{
		Idriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void clickLoginButton()
	{
		btnSignIn.click();
		logger.info("Sign in button clicked");
	}

}
