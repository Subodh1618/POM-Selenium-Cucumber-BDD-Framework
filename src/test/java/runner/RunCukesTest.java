package runner;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		
features = { 			 
				 "src/main/java/com/demo/cucumber/features/BookFlight.feature"
			
			}

 ,plugin = {"html:target/site/cucumber-pretty","json:target/cucumber.json",
		 	"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extentReport.html"}

 ,tags = {"@Run"}

 ,glue = {
			"com.demo.cucumber.stepDefinition"			
		}
)


public class RunCukesTest{

}

