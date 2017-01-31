package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helper.Locators.get;

/**
 * Created by HP on 1/24/2017.
 */
public class PageBase {
    public WebDriver driver;

    private static final By LOGOUT_BUTTON = get("AccountPage.LogOutButton");
    private static final By CREATE_PROJECT_BUTTON = get("AccountPage.CreateProjectButton");
    private static final By INBOX_TAB = get("AccountPage.InboxTab");

    public PageBase (WebDriver driver){
        this.driver = driver;
    }

    public void clearAndInsertData(By locator, String keys) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(keys);
    }

    public void goToInboxTab() {
        helper.Waiter.getWaiter(driver).until(ExpectedConditions.presenceOfElementLocated(INBOX_TAB));
        driver.findElement(INBOX_TAB).click();
    }

    public CreateNewProjectPage moveToNewProjectPage() {
        helper.Waiter.getWaiter(driver).until(ExpectedConditions.presenceOfElementLocated(CREATE_PROJECT_BUTTON));
        driver.findElement(CREATE_PROJECT_BUTTON).click();
        return new CreateNewProjectPage(driver);
    }

    public LoginPage logOut() {
        helper.Waiter.getWaiter(driver).until(ExpectedConditions.presenceOfElementLocated(LOGOUT_BUTTON));
        driver.findElement(LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }

    public boolean isLogOutButtonVisible() {
        helper.Waiter.getWaiter(driver).until(ExpectedConditions.presenceOfElementLocated(LOGOUT_BUTTON));
        WebElement logOutButton = driver.findElement(LOGOUT_BUTTON);
        return logOutButton.isDisplayed();
    }
}
