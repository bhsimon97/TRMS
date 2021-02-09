package dev.simon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TRMSIndex {

	public WebDriver driver;
	
	@FindBy(id="loginLink")
	public WebElement loginLink;
	
	public TRMSIndex(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
