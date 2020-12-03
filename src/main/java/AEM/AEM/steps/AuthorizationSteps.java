package AEM.AEM.steps;

import AEM.AEM.pages.TestPage;
import com.cognifide.qa.bb.aem.core.api.AemActions;
import com.cognifide.qa.bb.api.actions.ActionException;
import com.cognifide.qa.bb.api.actions.ActionsController;
import com.cognifide.qa.bb.page.BobcatPageFactory;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Properties;

import static org.junit.Assert.assertTrue;

/**
 * This is an implementation of steps in the "Login" scenario.
 * <p/>
 * You can leave it as it is, as long as you don't modify the login scenario.
 */

@ScenarioScoped
public class AuthorizationSteps {

	private TestPage testPage;

	@Inject
	private Properties properties;

	@Inject
	private ActionsController controller;

	@Inject
	private BobcatPageFactory bobcatPageFactory;

	@Given("^I have opened test page$")
	public void I_have_opened_login_page() {
		testPage = bobcatPageFactory.create("/content/we-retail/us/en.html", TestPage.class);
	}

	@When("^I login$")
	public void I_press_login_button() throws ActionException {
		controller.execute(AemActions.LOG_IN);
	}

	@Then("^I should see test page$")
	public void I_should_see_welcome_page() {
		assertTrue(testPage.open().isDisplayed());
	}

}
