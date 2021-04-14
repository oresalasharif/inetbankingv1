package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;


//dont forget
//when ever you create new test case MUSt Extend BaseClass ok(bcoz base class contains common resources ich is required
public class TC_LoginTest_001 extends BaseClass {
//creating only test methods here
//test case should contains only test methods

	
	
	
	@Test
	public void LoginTest() throws IOException
{
	//here implementing code for login

		logger.info("Url is opened");

	
LoginPage lp=new LoginPage(driver);//here we have created object for page object class by using this objetc we can just call this methods
lp.setUserName(username);
logger.info("Entered user name");
lp.setPassword(password);
logger.info("Entered password");
lp.clickSubmit();

//once click is done we need to go home page and verify title with expected
if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
{
	//Guru99 Bank Manager HomePage
Assert.assertTrue(true);
logger.info("Login Test Passed");
}
else
{
	
captureScreen(driver,"LoginTest");
Assert.assertTrue(false);
logger.info("login Test Failed");
}
}


//this is actual test case












}
