package dev.simon.steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.simon.pages.TRMSIndex;
import dev.simon.runners.IndexRunner;
import junit.framework.Assert;

public class TRMSLoginLinkStepImpl {
	
	public static TRMSIndex trmsIndex = IndexRunner.trmsIndex;
	public static WebDriver driver = IndexRunner.driver;
	
	@Given("^The User is on the websites Index$")
	public void the_User_is_on_the_websites_Index(){
	    driver.get("http://localhost:8080/Project1/index.html");
	}

	@When("^The User clicks on the Login link$")
	public void the_User_clicks_on_the_Login_link(){
	    trmsIndex.loginLink.click();
	}

	@Then("^The User should be at the login page$")
	public void the_User_should_be_at_the_login_page(){
	    Assert.assertEquals("http://localhost:8080/Project1/login.html", driver.getCurrentUrl());

	}

}
