package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class AccountPage {

	public AccountPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (id="welcome")
	public WebElement welcomeMessage;
	
	
	
	
	
	
	
	
}
