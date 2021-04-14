package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

WebDriver ldriver;


public AddCustomerPage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
@CacheLookup
WebElement LnkAddNewCustomer;

@FindBy(how=How.NAME, using="name")
@CacheLookup
WebElement AddCustomerName;

@FindBy(how=How.NAME, using="rad1")
@CacheLookup
WebElement rdgender;

@FindBy(how=How.NAME, using="dob")
@CacheLookup
WebElement Adddob;


@FindBy(how=How.NAME, using="addr")
@CacheLookup
WebElement Addaddress;

@FindBy(how=How.NAME, using="city")
@CacheLookup
WebElement AddCity;

@FindBy(how=How.XPATH,using="/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")
@CacheLookup
WebElement Addstate;

@FindBy(how=How.NAME, using="pinno")
@CacheLookup
WebElement AddPin;

@FindBy(how=How.NAME, using="telephoneno")
@CacheLookup
WebElement AddMobileNumber;

@FindBy(how=How.NAME, using="emailid")
@CacheLookup
WebElement AddEmail;

@FindBy(how=How.XPATH, using="/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input")
@CacheLookup
WebElement AddPassword;

@FindBy(how=How.NAME, using="sub")
@CacheLookup
WebElement AddSubmit;


public void ClickAddNewCustomer()
{
	LnkAddNewCustomer.click();
}

public void custoname(String cname)
{
	AddCustomerName.sendKeys(cname);
}

public void Gender(String cgender)
{
	rdgender.click();
}

public void DOB(String mm,String dd,String yyyy)
{
	Adddob.sendKeys(mm);
	Adddob.sendKeys(dd);
	Adddob.sendKeys(yyyy);
}

public void Address(String address)
{
	Addaddress.sendKeys(address);
}

public void City(String city)
{
	AddCity.sendKeys(city);
}

public void state(String state)
{
	Addstate.sendKeys(state);
}

public void Pin(String pin)
{
	AddPin.sendKeys(pin);
}

public void Mobile(String mobile)
{
	AddMobileNumber.sendKeys(mobile);
}

public void Email(String Email)
{
	AddEmail.sendKeys(Email);
}
public void Password(String Pwd)
{
	AddPassword.sendKeys(Pwd);
}
public void Submit()
{
	AddSubmit.click();
}








}
