package com.inetbanking.testcases;

import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.inetbanking.utilities.ReadConfig;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomrTest_003 extends BaseClass {

@Test
  public void addNewCustomer() throws InterruptedException, IOException
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.setUserName(username);
	  logger.info("user name provided");
	  lp.setPassword(password);
	  logger.info("password provided");

	  lp.clickSubmit();
	  
	  Thread.sleep(3000);
	  AddCustomerPage addcus=new AddCustomerPage(driver);
	  logger.info("Providing the customer details");

	  addcus.ClickAddNewCustomer();
	  addcus.custoname("cool");
	  addcus.Gender("male");
	  addcus.DOB("12", "25", "1995");
	  Thread.sleep(3000);
	  addcus.Address("india");
	  addcus.City("Nellore");
	  addcus.state("Andhra Pradesh");
	  addcus.Pin("5240022");
	  addcus.Mobile("258974563");  
	  String email=randomStringUtils()+"@gmail.com";
	  addcus.Email(email);
	  addcus.Password("dfdfgd");
	  addcus.Submit();
  
	Thread.sleep(3000);
	  logger.info("Validation is Started");

boolean d=	driver.getPageSource().contains("Customer Registered Successfully!!!");


if (d==true)		
{
	Assert.assertTrue(true);
	  logger.info("test case passed.... ");

}
else
{
	  logger.info("test case failed...");

  captureScreen(driver, "addNewCustomer");
  Assert.assertTrue(false);
}
}
  }
