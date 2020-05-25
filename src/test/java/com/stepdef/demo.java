package com.stepdef;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hook.hooks;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.runner.RepositoryParser;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class demo {
	static WebDriver driver = hooks.getDriver();
	RepositoryParser parser;
	ExtentTest test;
	ExtentReports report;

	public demo() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\htmlreport.html");
		System.out.println(System.getProperty("user.dir") + "\\report.html");
		test = report.startTest("demoreport");
	}

	@Given("^User launch the browser and navigate to demo site$")
	public void user_launch_the_browser_and_navigate_to_demo_site() throws Throwable {
		driver.get(RepositoryParser.getUrlInfo("demoSiteUrl"));
		parser = new RepositoryParser("src/test/resources/object.properties");
	}

	@Then("^User will enter all the required fields$")
	public void user_will_enter_all_the_required_fields(DataTable table) throws Throwable {
		try {
			List<List<String>> data = table.raw();
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input"))
					.sendKeys(data.get(0).get(0));
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input"))
					.sendKeys(data.get(0).get(1));
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea"))
					.sendKeys(data.get(0).get(2));
			driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys(data.get(0).get(3));
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input"))
					.sendKeys(data.get(0).get(4));
			test.log(LogStatus.PASS,
					"the step is passed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo23.png")));
			test.log(LogStatus.INFO, "All the required fields where filled");
		} catch (Exception e) {
			System.out.println(e);
			test.log(LogStatus.FAIL,
					"The step is failed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo2.png")));
		}

	}

	@Given("^click on \"([^\"]*)\" and \"([^\"]*)\"$")
	public void click_on_and(String data, String inputtextlocator) throws Throwable {
		try {
			List<WebElement> radiobuttons = driver.findElements(RepositoryParser.getbjectLocator(inputtextlocator));
			System.out.println(radiobuttons.size());
			for (int i = 0; i < radiobuttons.size(); i++) {
				String getgender = radiobuttons.get(i).getAttribute("value");
				System.out.println("print getgender:" + getgender);
				System.out.println(getgender + " " + data);
				if (getgender.equalsIgnoreCase(data)) {
					radiobuttons.get(i).click();
				}
			}
			test.log(LogStatus.PASS,
					"the step is passed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo24.png")));
		} catch (Exception e) {
			System.out.println(e);
			test.log(LogStatus.FAIL,
					"the step is failed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo3.png")));
		}
	}

	@Given("^select languange in the list$")
	public void select_languange_in_the_list() throws Throwable {
		try {
			driver.findElement(By.id("msdd")).click();
			driver.findElement(
					By.xpath("/html/body/section/div/div/div[2]/form/div[7]/div/multi-select/div[2]/ul/li[2]")).click();
			test.log(LogStatus.PASS,
					"the step is passed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo25.png")));
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"the step is failed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo4.png")));
		}

	}

	@Given("^also select \"([^\"]*)\" from dropdown of \"([^\"]*)\" field$")
	public void also_select_from_dropdown_of_field(String data, String inputtextlocator) throws Throwable {
		try {
			WebElement textfield = driver.findElement(RepositoryParser.getbjectLocator(inputtextlocator));
			Select skill = new Select(textfield);
			skill.selectByVisibleText(data);
			test.log(LogStatus.PASS,
					"the step is passed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo26.png")));
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"the step is failed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo5.png")));
		}
	}

	@Given("^Enter the \"([^\"]*)\" by \"([^\"]*)\" the column and \"([^\"]*)\"$")
	public void enter_the_by_the_column_and(String arg1, String arg2, String arg3) throws Throwable {
		try {
			driver.findElement(RepositoryParser.getbjectLocator(arg2)).click();
			driver.findElement(RepositoryParser.getbjectLocator(arg3)).sendKeys(arg1, Keys.ENTER);
			test.log(LogStatus.PASS,
					"the step is passed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo26.png")));
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"the step is failed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo5.png")));
		}
	}

	@Given("^Enter the password and confirm password$")
	public void enter_the_password_and_confirm_password(DataTable table) throws Throwable {
		try {
			List<List<String>> data = table.raw();
			driver.findElement(By.id("firstpassword")).sendKeys(data.get(0).get(0));
			driver.findElement(By.id("secondpassword")).sendKeys(data.get(0).get(1));
			test.log(LogStatus.PASS,
					"the step is passed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo27.png")));
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"the step is failed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo6.png")));
		}

	}

	@Then("^click on the \"([^\"]*)\" button$")
	public void click_on_the_button(String dataobjectlocator) throws Throwable {
		try {
			WebElement textfield = driver.findElement(RepositoryParser.getbjectLocator(dataobjectlocator));
			textfield.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The title of the page ======");
			System.out.println(driver.getCurrentUrl());
			report.endTest(test);
			report.flush();
			test.log(LogStatus.PASS,
					"the step is passed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo27.png")));
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"the step is failed" + test.addScreenCapture(takeSnapShot(driver, "C:\\report//demo6.png")));
		}

	}

	@Then("^take a screen shot and validate the scenario$")
	public void take_a_screen_shot_and_validate_the_scenario() throws Throwable {
		demo.takeSnapShot(driver, "C:\\report//demo1.png");
	}

	public static String takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
		return fileWithPath;
	}

}
