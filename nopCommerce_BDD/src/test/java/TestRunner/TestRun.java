package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="", features= {"src/main/resources/features/Customer.feature"},
glue= {"step_definition"}, dryRun=false,
plugin= {"pretty", "html:target/htmlreports.html"})



public class TestRun extends AbstractTestNGCucumberTests {
	

	

}
