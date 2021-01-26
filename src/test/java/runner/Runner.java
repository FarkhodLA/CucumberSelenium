package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
     features="/Users/farkhodsabirov/eclipse-workspace/CucumberSelenium/Features",		
     glue="stepDefinitions",
     dryRun=false,    //if true, then web browser won't open
     monochrome=true,
     tags="@incorrectPassword"
		
		)
    
     
     
public class Runner {

	
	
	
	
	
	
	
}
