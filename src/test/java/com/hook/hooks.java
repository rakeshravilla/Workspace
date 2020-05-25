package com.hook;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.runner.RepositoryParser;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooks {
	static WebDriver driver;
	RepositoryParser parser;

	@Before
	public void Setup(Scenario name) {
		System.out.println("========Before Hook===========");
		System.out.println("Name : " + name.getName());
		System.out.println("Status : " + name.getStatus());
		try {
			parser = new RepositoryParser("src/test/resources/object.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rakesh.ravilla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		String isHeadLessBrowser = RepositoryParser.getBrowserInfo("headlessbrowser");
		System.out.println("isHeadLessBrowser" + " " + isHeadLessBrowser);
		if (isHeadLessBrowser.equalsIgnoreCase("yes")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless"); // headless browser
			driver = new ChromeDriver(options);
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();

	}

	@After
	public void after_scenario(Scenario scenario) throws Throwable {

		try {
			if (scenario.isFailed()) {

				final File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("src/test/java/Screenshots/Report.png"));
			}
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		} finally {
			driver.close();
		}
	}
//	public void tearDown(Scenario name) {
//		System.out.println("========After Hook===========");
//		System.out.println("Name : " + name.getName());
//		System.out.println("Status : " + name.getStatus());
//		
//	}


	public static WebDriver getDriver() {
		return driver;
	}

}
