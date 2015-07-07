package cucu.training;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static appium.tutorial.android.util.Helpers.find;

/**
 * Created by viktor.klymenko on 7/7/2015.
 */
public class StepDef2 {
    @When("^Click (.+) item$")
    public void Click_MenuItem_item(String item) throws Throwable {
        find(item).click();
    }

    @Given("^The (.+) is present$")
    public void The_Marker_is_present(String marker) throws Throwable {
        boolean result = false;
        try {
            find(marker);
            result = true;
        }catch(NoSuchElementException e) {

        }
        Assert.assertTrue("232323The element " + marker + " is not present", result);
    }
}
