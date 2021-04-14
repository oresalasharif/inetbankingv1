package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
//driver object creation
WebDriver ldriver;
//writing Constructor taking driver as parameter
 public LoginPage(WebDriver rdriver){
	ldriver=rdriver;//initiating driver
	PageFactory.initElements(rdriver, this);// specifying the page factory class with this keyword
	}// this is a constructor we created

//addding identified elements 

@FindBy(name="uid")
@CacheLookup        //optional
WebElement txtUsername;




@FindBy(name="password")
@CacheLookup
WebElement txtPassword;

@FindBy(name="btnLogin")
@CacheLookup
WebElement btnlogin;

@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
@CacheLookup
WebElement lnklogout;
//writing action methods for above elements 
//takes username as parameter (will pass this parameter from actual test case)

public void setUserName(String username)
{
	txtUsername.sendKeys(username);
}

public void setPassword(String password)
{
	txtPassword.sendKeys(password);
}

public void clickSubmit()
{
	btnlogin.click();
}
public void ClickLogout()
{
	lnklogout.click();
}
}
//with this we have done with the page objects class for login screen
//next creating test cases



//mngr319300
//amAzamA
