package dev.simon.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dev.simon.pages.TRMSIndex;
import dev.simon.pages.TRMSLogin;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",glue = "dev.simon.steps")
public class IndexRunner {
	
	public static WebDriver driver;
	public static TRMSIndex trmsIndex;
	public static TRMSLogin trmsLogin;
	
	@BeforeClass
	public static void setUp() {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		trmsIndex = new TRMSIndex(driver);
		trmsLogin = new TRMSLogin(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
