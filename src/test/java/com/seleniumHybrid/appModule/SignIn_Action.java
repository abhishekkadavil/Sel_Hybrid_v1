package com.seleniumHybrid.appModule;

import org.openqa.selenium.WebDriver;

import com.seleniumHybrid.pageObject.SampWebHomePage;
import com.seleniumHybrid.pageObject.SampWebLogin;

public class SignIn_Action   {

	WebDriver Idriver;
	public SignIn_Action(WebDriver rdriver) 
	{
		Idriver=rdriver;
	}

	public void Execute(String uname, String password)
	{
		SampWebHomePage home= new SampWebHomePage(Idriver);
		home.clickLoginButton();
		
		SampWebLogin login= new SampWebLogin(Idriver);
		login.setUserName(uname);
		login.setPaswword(password);
		login.clickSubmitButton();
	}

}
