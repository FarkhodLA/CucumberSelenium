package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="txtUsername")
   public WebElement user;

    @FindBy(id="txtPassword")
   public WebElement password;
    
    @FindBy(id="spanMessage")
   public  WebElement errorMessage;
    
    @FindBy(id="btnLogin")
   public WebElement loginButton;
    
    





}