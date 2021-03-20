package apiTesting;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
     features="src/test/resources/Features/Create_Get_Laptop.feature",		
     glue="apiTesting",    //package name
     dryRun=false,    //if true, then web browser won't open
     monochrome=true,
    //tags="@Login",
    			plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",  //json is a report form
    					 "junit:target/cucumber-reports/Cucumber.xml",
    					 "html:target/cucumber-reports/report.html",
                         "rerun:target/rerun.txt"} //creates a file for failed scenarios
     
		)
    

public class APItest {

}
