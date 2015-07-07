package appium.tutorial.android.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static appium.tutorial.android.util.Helpers.find;

/** Page object for the animation page **/
public abstract class AnimationPage {

    /** Verify the animation page has loaded **/
    public static void loaded() {
        find("Bouncing Balls");
    }

    public static boolean isLoaded() {
        try {
            WebElement el = find("Bouncing Balls");
        }catch(NoSuchElementException e) {
            return false;
        }
        return true;
    }
}