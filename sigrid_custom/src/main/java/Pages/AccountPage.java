package Pages;
import static Helper.Locators.get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by HP on 1/17/2017.
 */
public class AccountPage {
    private WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By LOGOUT_BUTTON = get("AccountPage.LogOutButton");
    private final By CREATE_PROJECT_BUTTON = get("AccountPage.CreateProjectButton");

    public LoginPage logOut (){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON));
        driver.findElement(LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }


    public CreateNewProjectPage moveToNewProjectPage () {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(CREATE_PROJECT_BUTTON));
        driver.findElement(CREATE_PROJECT_BUTTON).click();
        return new CreateNewProjectPage(driver);
    }


    public boolean isLogOutButtonVisible(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON));
        WebElement logOutButton = driver.findElement(LOGOUT_BUTTON);
        return logOutButton.isDisplayed();
    }
}

