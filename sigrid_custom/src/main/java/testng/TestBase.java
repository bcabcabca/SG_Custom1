package testng;

import org.openqa.selenium.WebDriver;

/**
 * Created by HP on 1/18/2017.
 */
public class TestBase {

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }
}