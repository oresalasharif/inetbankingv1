package com.inetbanking.testcases;
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

import com.inetbanking.utilities.ReadConfig;


public class BaseClass {
	
	
ReadConfig readconfig =new ReadConfig();	
	
//common variables or things required for every testcase
public String baseurl=readconfig.getApplicationURL();
public String username=readconfig.getUserName();
public String password=readconfig.getPassword();
public static WebDriver driver;//webdriver object initiated
public static Logger logger;


@Parameters("browser")
@BeforeClass
public void setup(String br) throws InterruptedException
{//specifying the system.set property
	
	logger=Logger.getLogger("ebanking");//logger is class object
//here we initiated the logger object by using Logger.getlogger
	PropertyConfigurator.configure("Log4j.properties");

	if(br.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());//currently using chrome browser and complete path of driver
	driver=new ChromeDriver();//instantiation here
	}
	else if(br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxpath());
		driver=new FirefoxDriver();
	}
	else if(br.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
		driver=new InternetExplorerDriver();
	}
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(baseurl);//once open the page url need to use pageobject and call these methods
driver.manage().window().maximize();


}//this is our set up method

//
@AfterClass//executes after completion of our test case
public void tearDown()
{

	driver.quit();//this cmd close browser at end of u r testcase
}



public void captureScreen(WebDriver driver,String tname) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+ "/Screenshots/" +tname+ ".png");
	FileUtils.copyFile(source,target);
	System.out.println("Screenshot taken");
}

public String randomStringUtils()
{
String randomname=RandomStringUtils.randomAlphabetic(8);
return randomname;
}

public String randomnumber()
{
  String randomnum=RandomStringUtils.randomAlphanumeric(8);
  return randomnum;
}


}




