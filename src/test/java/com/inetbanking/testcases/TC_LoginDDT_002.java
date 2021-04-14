package com.inetbanking.testcases;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass{

@Test(dataProvider="LoginData")
public void loginDDT(String user,String pwd) throws InterruptedException
{
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(user);
	logger.info("Username is Provided");
	lp.setPassword(pwd);
	logger.info("Password is Provided");
	lp.clickSubmit();
	
	Thread.sleep(3000);
	
if(isAlertPresent()==true)
{
	driver.switchTo().alert().accept();//login alert
	driver.switchTo().defaultContent();
	Assert.assertTrue(false);//my test case is false or wrong credentials given
	logger.warn("Login Failed");

}
else
{
	Assert.assertTrue(true);
	logger.warn("Login Passed");
	lp.ClickLogout();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();//logout alert
	driver.switchTo().defaultContent();

}
}



public boolean isAlertPresent()//userdefined method to create an check alert presen or not
{
	try
	{
	driver.switchTo().alert();//if alert present it executes
	return true;
	}
	catch(NoAlertPresentException e) //u can also put this in base class
	{
		return false;
	}
}


@DataProvider(name="LoginData")
String [][] getData() throws IOException
{
	String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/LoginData.xlsx";
	int rownum=XLUtils.getRowCount(path, "Sheet1");
	int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
	
	String logindata[][] =new String [rownum][colcount];

	for(int i=1;i<=rownum;i++)
{
	
	
	for(int j=0;j<colcount;j++)
	{
		logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//1 0
	}
}
return logindata;
}
}
