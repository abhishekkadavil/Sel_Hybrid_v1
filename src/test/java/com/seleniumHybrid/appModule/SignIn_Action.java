package com.seleniumHybrid.appModule;

import com.seleniumHybrid.pageObject.SampWebHomePage;
import com.seleniumHybrid.pageObject.SampWebLogin;
import com.seleniumHybrid.testCase.BaseClass;
import com.seleniumHybrid.utils.Constant;
import com.seleniumHybrid.utils.ExcelUtils;

public class SignIn_Action extends BaseClass  
{

	public static void Execute(int testcaserow) throws Exception
	{
		String uname=ExcelUtils.getCellData(testcaserow, Constant.Col_UserName);
		String password=ExcelUtils.getCellData(testcaserow, Constant.Col_Password);
		
		SampWebHomePage home= new SampWebHomePage(driver);
		home.clickLoginButton();
		
//		SampWebLogin login= new SampWebLogin(driver);
//		login.setUserName(uname);
//		login.setPaswword(password);
//		login.clickSubmitButton();

	}

}
