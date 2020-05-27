package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/com/features/demo.feature",
		glue= {"com.stepdef","com.hook"},
		tags="@test",
		//if it set as true, it means console output of cucumber test much more readable.
		monochrome=true,
		
		plugin="com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report3.html"
		)
public class Testrunner extends AbstractTestNGCucumberTests {
	
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/test/resources/config-extent.xml");
        Reporter.setSystemInfo("User Name", "Rakesh");
        Reporter.setSystemInfo("Application Name", "Demo Site");
        Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
        Reporter.setSystemInfo("Environment", "Production");
        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
    }

}
