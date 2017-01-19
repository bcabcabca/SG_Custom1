package Pages;
import static Helper.Locators.get;

import Helper.Creds;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by HP on 1/17/2017.
 */
public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By EMAIL_INPUT = get("LogInPage.EmailInput");
    private final By PASSWORD_INPUT = get("LogInPage.PasswordInput");
    private final By LOGIN_BUTTON = get("LogInPage.LogInButton");

    public AccountPage loginAccountPage(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new AccountPage(driver);
    }

    public AccountPage loginAccountPageWithEnter(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).sendKeys(Keys.ENTER);
        return new AccountPage(driver);
    }
    public boolean isLoginButtonVisible() {
        WebElement logInButton = driver.findElement(LOGIN_BUTTON);
        return logInButton.isDisplayed();
    }
}
