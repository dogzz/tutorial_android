package appium.tutorial.android;

import appium.tutorial.android.util.AppiumTest;
import org.junit.Test;

import static appium.tutorial.android.util.Helpers.back;

public class PageObjectPatternTest extends AppiumTest {

    @Test
    public void pageObject() throws Exception {
        home.accessibilityClick();
        back();

        home.animationClick();
        back();
    }
}