package dev.simon.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import dev.simon.pages.TRMSLogin;
import dev.simon.runners.IndexRunner;


public class TRMSLoginStepImpl {
	
	public static TRMSLogin trmsLogin = IndexRunner.trmsLogin;
	public static WebDriver driver = IndexRunner.driver;

	@Given("^The Guest is on the Login Page$")
	public void the_Guest_is_on_the_Login_Page(){
		driver.get("http://localhost:8080/Project1/login.html");
	}

	@When("^The user types in \"([^\"]*)\" in the Username form$")
	public void the_user_types_in_in_the_Username_form(String username) throws InterruptedException{
		Thread.sleep(200);
		trmsLogin.inputUsername.sendKeys(username);
	}

	@When("^The user types in \"([^\"]*)\" in the Password form$")
	public void the_user_types_in_in_the_Password_form(String password){
		trmsLogin.inputPassword.sendKeys(password);
	}

	@When("^The user clicks the Login button$")
	public void the_user_clicks_the_Login_button(){
		trmsLogin.loginButton.click();
	}

	@Then("^The user should be at reimbursement\\.html$")
	public void the_user_should_be_at_home_html() throws InterruptedException{
		Thread.sleep(500);
		Assert.assertEquals("http://localhost:8080/Project1/reimbursement.html", driver.getCurrentUrl());
	}

}
