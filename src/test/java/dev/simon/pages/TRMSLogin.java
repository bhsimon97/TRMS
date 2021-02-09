package dev.simon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TRMSLogin {

	public WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"inputUsername\"]")
	public WebElement inputUsername;
	
	@FindBy(xpath="//*[@id=\"inputPassword\"]")
	public WebElement inputPassword;
	
	@FindBy(xpath="/html/body/main/div/div/div/div/div/button")
	public WebElement loginButton;
	
	public TRMSLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}