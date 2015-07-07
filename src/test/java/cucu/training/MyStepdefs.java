package cucu.training;

import appium.tutorial.android.page.AccessibilityPage;
import appium.tutorial.android.page.AnimationPage;
import appium.tutorial.android.page.HomePage;
import appium.tutorial.android.util.Helpers;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static appium.tutorial.android.util.Helpers.driver;
import static org.junit.Assert.*;

/**
 * Created by viktor.klymenko on 7/6/2015.
 */
public class MyStepdefs {

    protected HomePage home;
    protected AnimationPage animationPage;
    protected AccessibilityPage accessibilityPage;
    private static Date date = new Date();
    private Scenario scenario;

    @Before
    public void preparation(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^Start Application$")
    public void Start_Application() throws Throwable {
        scenario.write("Prepare driver");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformVersion", "4.3");

        // Set job name on Sauce Labs
        capabilities.setCapability("name", "Java Android tutorial " + date);
        String userDir = System.getProperty("user.dir");

        URL serverAddress;
        String localApp = "api.apk";
        String appPath = Paths.get(userDir, localApp).toAbsolutePath().toString();
        capabilities.setCapability("app", appPath);
        serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(serverAddress, capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Helpers.init(driver, serverAddress);
    }

    @When("^Click Accessibility$")
    public void click_Accessibility() throws Throwable {
        home.accessibilityClick();
    }

    @Then("^Accessibility Screen Is Displayed$")
    public void accessibility_Screen_Is_Displayed() throws Throwable {
        assertTrue("The animation screen is not displayed", accessibilityPage.isLoaded());
    }

    @When("^Click Animation$")
    public void click_Animation() throws Throwable {
        home.animationClick();
    }

    @Then("^Animation Screen Is Displayed$")
    public void animation_Screen_Is_Displayed() throws Throwable {
        assertTrue("The animation screen is not displayed", animationPage.isLoaded());
    }

    @After
    public void quitDriver() {
        scenario.write("Quit driver");
        if (driver != null) driver.quit();
    }


}
