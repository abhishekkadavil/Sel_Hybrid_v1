package com.seleniumHybrid.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.seleniumHybrid.testCase.BaseClass;
import com.seleniumHybrid.utils.Log;

public class SampWebHomePage extends BaseClass {
	
	WebDriver Idriver;
	private WebElement btnSignIn=driver.findElement(By.xpath("//a[@class='login']"));
	
	public SampWebHomePage(WebDriver rdriver)
	{
		Idriver=rdriver;
		//PageFactory.initElements(rdriver, this);
	}
	
	public void clickLoginButton()
	{
		btnSignIn.click();
		Log.info("Sign in button clicked");
	}

}
