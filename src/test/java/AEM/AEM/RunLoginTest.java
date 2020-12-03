package AEM.AEM;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/features/login", plugin = { "pretty",
		"html:target/cucumber-login-html-report", "json:target/cucumber-login-report.json" })
public class RunLoginTest {
	// empty
}
