package appium.tutorial.android.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static appium.tutorial.android.util.Helpers.find;

/** Page object for the accessibility page **/
public abstract class AccessibilityPage {

    /** Verify the accessibility page has loaded **/
    public static void loaded() {
        find("Accessibility Node Provider");
    }

    public static boolean isLoaded() {
        try {
            WebElement el = find("Accessibility Node Provider");
        }catch(NoSuchElementException e) {
            return false;
        }
        return true;
    }
}