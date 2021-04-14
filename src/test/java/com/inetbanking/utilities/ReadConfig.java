package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

public ReadConfig()//constructor
{
	File src=new File("./Configuartion/config.properties");
	
	try
	{		
	FileInputStream fis=new FileInputStream(src);
	pro=new Properties();
	pro.load(fis);
	}
	catch(Exception e)
	{
		System.out.println("Exception is "+e.getMessage());
	}
}


//creating method to all variable
public String getApplicationURL()
{
	String url=pro.getProperty("baseurl");
return url;
}
public String getUserName()
{
	String username=pro.getProperty("username");
return username;
}
public String getPassword()
{
	String password=pro.getProperty("password");
return password;
}
public String getChromePath()
{
	String chromepath=pro.getProperty("chromepath");
return chromepath;
}
public String getIEpath()
{
	String iepath=pro.getProperty("iepath");
return iepath;
}
public String getFireFoxpath()
{
String firefoxpath=pro.getProperty("firefoxpath");
return firefoxpath;
}
}
