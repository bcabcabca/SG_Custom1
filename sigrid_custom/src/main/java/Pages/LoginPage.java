package pages;

import static helper.Locators.get;

import helper.Creds;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by HP on 1/17/2017.
 */
public class LoginPage {
    private WebDriver driver;

    private static final By EMAIL_INPUT = get("LogInPage.EmailInput");
    private static final By PASSWORD_INPUT = get("LogInPage.PasswordInput");
    private static final By LOGIN_BUTTON = get("LogInPage.LogInButton");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountPage login(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new AccountPage(driver);
    }

    public AccountPage logInAs (String position){
        if (position.equals("designer")) {
            login(Creds.DESIGNER_EMAIL,Creds.DESIGNER_PASSWORD);
        } else if (position.equals("manager")) {
            login(Creds.MANAGER_EMAIL,Creds.MANAGER_PASSWORD);
        } else if (position.equals("admin")) {
            login(Creds.ADMIN_EMAIL,Creds.ADMIN_PASSWORD);
        } else {
            System.out.println("Position not identified. Try once again later");
        }
    return new AccountPage(driver);
    }

    public AccountPage loginWithEnter(String email, String password) {
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
