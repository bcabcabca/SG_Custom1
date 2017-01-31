package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by HP on 1/24/2017.
 */
public class Waiter {

    public static WebDriverWait getWaiter(WebDriver driver) {
        return new WebDriverWait(driver, 15);
    }
}
