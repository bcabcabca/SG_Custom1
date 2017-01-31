package pages;

import static helper.Locators.get;

import helper.Creds;
import helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by HP on 1/17/2017.
 */
public class AccountPage extends PageBase {

    private static final By PROJECTS_TAB = get("AccountPage.Header_PROJECTS");
    private static final By SEARCH_BOX = get("AccountPage.SearchBox");
    private static final By PROJECT_ELEMENT = get("AccountPage.ProjectElement");
    private static final By INBOX_TAB = get("AccountPage.InboxTab");
    private static final By ORDER_BUTTON = get("AccountPage.PurchaseButton");
    private static final By ORDERED_TAB = get("AccountPage.OrderedTab");
    private static final By ORDERED_ITEM = get("AccountPage.OrderedProject");
    private static final By INBOX_ITEM = get("AccountPage.InboxItem");
//    private static final By EDIT_EQUIPMENT = get("AccountPage.EditEquipmentListButton");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean findProjectByNameInInbox(String projectName) {
        Waiter.getWaiter(driver).until(ExpectedConditions.presenceOfElementLocated(SEARCH_BOX));
        driver.findElement(SEARCH_BOX).sendKeys(projectName);
        String projectNameFound = driver.findElement(INBOX_ITEM).getText();
        return projectNameFound.contentEquals(projectName);
    }

    public ProjectPage findProjectInInbox(String projectName){
        driver.findElement(INBOX_TAB).click();
        driver.findElement(SEARCH_BOX).sendKeys(projectName);
        driver.findElement(By.xpath("//*[@id='inboxCPTable']/tbody/tr/td[6]/span")).click();
        return new ProjectPage(driver);
    }

    public ProjectPage findAndOpenProject(String projectName) {
        helper.Waiter.getWaiter(driver).until(ExpectedConditions.presenceOfElementLocated(PROJECTS_TAB));
        driver.findElement(PROJECTS_TAB).click();
        driver.findElement(SEARCH_BOX).sendKeys(projectName);
        driver.findElement(PROJECT_ELEMENT).click();
        return new ProjectPage(driver);
    }

    public ProjectPage orderProject(String projectName) {
        driver.findElement(SEARCH_BOX).sendKeys(projectName);
        helper.Waiter.getWaiter(driver).until(ExpectedConditions.presenceOfElementLocated(ORDER_BUTTON));
        driver.findElement(ORDER_BUTTON).click();
        return new ProjectPage(driver);
    }

    public boolean isProjectOrdered(String projectCreated) {
        helper.Waiter.getWaiter(driver).until(ExpectedConditions.presenceOfElementLocated(ORDERED_TAB));
        driver.findElement(ORDERED_TAB).click();

        WebElement orderedProject = driver.findElement(ORDERED_ITEM);
        String projectName = orderedProject.getText();
        return projectName.equals(projectCreated);
    }

    public boolean isProjectInInbox(String projectName) {
        helper.Waiter.getWaiter(driver).until(ExpectedConditions.presenceOfElementLocated(INBOX_TAB));
        driver.findElement(INBOX_TAB).click();
        driver.findElement(SEARCH_BOX).sendKeys(projectName);

        WebElement orderedProject = driver.findElement(ORDERED_ITEM);
        if (orderedProject.isDisplayed()) {
            return false;
        } else {
            return true;
        }
    }
}

