package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;



public class LoginTest {
	
	
	WebDriver driver;
	@Given("user launches application")
	public void user_launches_application() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
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
	  driver.findElement(By.id("txtUsername")).sendKeys(username);
	  driver.findElement(By.id("txtPassword")).sendKeys(password);
	 
	  
	  
	}
	@When("click login button")
	public void click_login_button() {
		 driver.findElement(By.id("btnLogin")).click();
		 
	}
	@Then("user is on  Account page")
	public void user_is_on_account_page() {
	 String message="Welcome Paul";
	 String actualMessage=driver.findElement(By.id("welcome")).getText();
	 Assert.assertEquals(message, actualMessage);
	 
	 
	}
	
	@When("user enters incorrect username {double} and {string}")
		public void user_enters_incorrect_username_and(Double userName, String passWord) {
		driver.findElement(By.id("txtUsername")).sendKeys(String.valueOf(userName));
		driver.findElement(By.id("txtPassword")).sendKeys(passWord);
		
	
	}


		

	@Then("user gets invalid error message {string}")
		public void user_gets_invalid_error_message(String errorMessage) {
     	String actualError = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(errorMessage, actualError);    
		
		
		
		}

	

		@When("user enters incorrect password {string} and {string}")
		public void user_enters_incorrect_password_and(String correctUsername, String incorrectPassword) {
			driver.findElement(By.id("txtUsername")).sendKeys(correctUsername);
			driver.findElement(By.id("txtPassword")).sendKeys(incorrectPassword);
			
			
			
		}




	
	
	
	
	
	
	
	
	
}
