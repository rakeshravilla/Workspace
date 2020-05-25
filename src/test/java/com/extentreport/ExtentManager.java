//package com.extentreport;
//
//import java.io.File;
//
//import com.relevantcodes.extentreports.ExtentReports;
//
//
//
//public class ExtentManager
//{
//	private static ExtentReports extent;
//
//	public static ExtentReports getReporter()
//
//	{
//	extent = new ExtentReports(System.getProperty("user.dir")+"/cucumber/test-output/myreport.html",true);
//	extent.addSystemInfo("Host Name", "LocalHost");
//	extent.addSystemInfo("Environment", "QA");
//	extent.addSystemInfo("User Name", "Rakesh");
//	extent.loadConfig(new File("C:\\Users\\rakesh.ravilla\\eclipse-workspace\\cucumber\\config-extent.xml"));
//
//	return extent;
//
//	}
//}
//
