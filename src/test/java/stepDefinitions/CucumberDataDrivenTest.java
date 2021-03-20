package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;



public class CucumberDataDrivenTest extends TestBase{
	
	WebDriver driver=Driver.getDriver();
	
	@Given("user launches browser")
	  public void user_launches_browser() {
	  
	    driver.get(ConfigReader.getProperty("url2"));
	  }

	  @Given("user is in main page")
	  public void user_is_in_main_page() {
	    String exTitle = "Editor | Editing for DataTables";
	    String acTitle = driver.getTitle();
	    Assert.assertEquals(exTitle, acTitle);
	  }

	  @When("user clicks new button")
	  public void user_clicks_new_button() throws Exception {
	    driver.findElement(By.xpath("//span[.=\"New\"]//..")).click();
	    Thread.sleep(2000);
	  }

	  @Then("new form opened")
	  public void new_form_opened() {
	    String acText = driver.findElement(By.className("DTE_Header_Content")).getText();
	    String exText = "Create new entry";
	    Assert.assertEquals(exText, acText);
	  }

	  @Then("user enters firstname {string}")
	  public void user_enters_firstname(String firstname) {
	    driver.findElement(By.id("DTE_Field_first_name")).sendKeys(firstname);
	  }

	  @Then("user enters lastname {string}")
	  public void user_enters_lastname(String lastname) {
	    driver.findElement(By.id("DTE_Field_last_name")).sendKeys(lastname);
	  }

	  @Then("user enters position {string}")
	  public void user_enters_position(String position) {
	    driver.findElement(By.id("DTE_Field_position")).sendKeys(position);
	  }

	  @Then("user enters office {string}")
	  public void user_enters_office(String office) {
	    driver.findElement(By.id("DTE_Field_office")).sendKeys(office);
	  }

	  @Then("user enters extension {string}")
	  public void user_enters_extension(String extension) {
	    driver.findElement(By.id("DTE_Field_extn")).sendKeys(extension);
	  }

	  @Then("user enters startdate {string}")
	  public void user_enters_startdate(String startdate) {
	    driver.findElement(By.id("DTE_Field_start_date")).sendKeys(startdate);
	  }

	  @Then("user enters salary {string}")
	  public void user_enters_salary(String salary) {
	    driver.findElement(By.id("DTE_Field_salary")).sendKeys(salary);
	  }

	  @Then("user clicks create button")
	  public void user_clicks_create_button() throws Exception {
	    driver.findElement(By.xpath("//button[@class='btn']")).click();
	    Thread.sleep(5000);
	  }

	  @Then("user validates fullname {string} {string}")
	  public void user_validates_fullname(String firstname, String lastname) throws Exception {
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(firstname+" "+lastname);
	    Thread.sleep(2000);
	        String actualFullname=driver.findElement(By.xpath("//tbody//tr//td[@class='sorting_1']")).getText();
	        String expectedFullname=firstname+" "+lastname;
	        Assert.assertEquals(expectedFullname,actualFullname);
	  }

}
