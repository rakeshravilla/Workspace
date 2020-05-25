package com.runner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public  class RepositoryParser {
    
    public FileInputStream stream;
    public  String RepositoryFile;
    public static Properties propertyFile = new Properties();
    
    public  RepositoryParser(String fileName) throws IOException
    {
    this.RepositoryFile = fileName;
    stream = new FileInputStream(RepositoryFile);
    propertyFile.load(stream);
    }
    
    public static String getBrowserInfo(String fieldName) {
    	String fieldValue = propertyFile.getProperty(fieldName);
    	
    	return fieldValue;
    }
    public static String getUrlInfo(String urlName) {
    	String urlValue = propertyFile.getProperty(urlName);
    	return urlValue;
    }
    
    public static By getbjectLocator(String locatorName)
    {
    String locatorProperty = propertyFile.getProperty(locatorName);
    
    System.out.println(locatorProperty.toString());
    String locatorType = locatorProperty.split(":")[0];
    System.out.println("Print locator type:"+ locatorType);
    String locatorValue = locatorProperty.split(":")[1];
    System.out.println("Print locator value:"+ locatorValue);
    By locator = null;
    switch(locatorType)
    {
    case "id":
    locator = By.id(locatorValue);
    break;
    case "Name":
    locator = By.name(locatorValue);
    break;
    case "CssSelector":
    locator = By.cssSelector(locatorValue);
    break;
    case "LinkText":
    locator = By.linkText(locatorValue);
    break;
    case "PartialLinkText":
    locator = By.partialLinkText(locatorValue);
    break;
    case "TagName":
    locator = By.tagName(locatorValue);
    break;
    case "xpath":
    locator = By.xpath(locatorValue);
   
    break;
    }
    return locator;
    }
   }
