package AEM.AEM.hooks;

import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * A helper class that can create a screenshot file and gather additional data.
 */
public class FinishReport {

  @Inject
  private WebDriver webDriver;

  /**
   * Creates screenshot and gathers additional information, embeds it in the scenario and closes webDriver.
   */
  @After
  public void addDataAndClose(Scenario scenario) {
    if (scenario.isFailed()) {
      if(webDriver instanceof TakesScreenshot){
        addScreenshot(scenario);
      }
      addPageLink(scenario);
    }
    webDriver.quit();
  }

  private void addPageLink(Scenario scenario) {
    scenario.log("Test page: " + "<a href=" + webDriver.getCurrentUrl() + ">link</a>");
  }

  private void addScreenshot(Scenario scenario) {
    byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot, "image/png","Error");
  }

}
