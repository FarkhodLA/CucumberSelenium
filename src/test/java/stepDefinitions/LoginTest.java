package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AccountPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;



public class LoginTest extends TestBase {
	
	
	WebDriver driver=Driver.getDriver();
	HomePage hp=new HomePage();
	AccountPage ap=new AccountPage();
	
	@Given("user launches application")
	public void user_launches_application() {
		
		driver.get(ConfigReader.getProperty("url1"));
	    System.out.println("I launched the application");
	}
	@Given("user is in homepage")
	public void user_is_in_homepage() {
	    
		String title=driver.getTitle();
		if (title.equals("OrangeHRM")) {
			System.out.println("I'm in the home page");
		}else {
			System.out.println("Application got diverted");
		}
	
	}
	
	@When("user enters correct {string} and {string}")
	public void user_enters_correct_and(String username, String password) {
    hp.user.sendKeys(username);
    hp.password.sendKeys(password);
		
//	  driver.findElement(By.id("txtUsername")).sendKeys(username);
//	  driver.findElement(By.id("txtPassword")).sendKeys(password);
	 
	  
	  
	}
	@When("click login button")
	public void click_login_button() {
		
    hp.loginButton.click();
		 
	}
	@Then("user is on  Account page")
	public void user_is_on_account_page() {
	 String message="Welcome Paul";
	 String actualMessage=ap.welcomeMessage.getText();
	 Assert.assertEquals(message, actualMessage);
	 
	 
	}
	
	@When("user enters incorrect username {double} and {string}")
		public void user_enters_incorrect_username_and(Double userName, String passWord) {
		hp.user.sendKeys(String.valueOf(userName));
		hp.password.sendKeys(passWord);
		
	
	}

     @Then("user gets invalid error message {string}")
		public void user_gets_invalid_error_message(String errorMessage) {
     	String actualError = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(errorMessage, actualError);    
		
		
		
		}

	 @When("user enters incorrect password {string} and {string}")
		public void user_enters_incorrect_password_and(String correctUsername, String incorrectPassword) {
		 
		 hp.user.sendKeys(correctUsername);
		 hp.password.sendKeys(incorrectPassword);
			
		}




	
	
	
	
	
	
	
	
	
}
