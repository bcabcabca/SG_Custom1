package Pages;

import Helper.Creds;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Helper.Locators.get;

/**
 * Created by HP on 1/18/2017.
 */
public class CreateNewProjectPage {
    private WebDriver driver;
    public CreateNewProjectPage (WebDriver driver){
        this.driver = driver;
    }

    private final By PROJECT_NAME_INPUT = get("CreateNewProjectPage.ProjectName");
    private final By MANAGER_NAME_INPUT = get("CreateNewProjectPage.SelectManagerDropdown");
    private final By NUMBER_OF_INPUT = get("CreateNewProjectPage.NumberOfInputs");
    private final By BROWSE_BUTTON = get("CreateNewProjectPage.BrowseButton");
    private final By UPLOAD_BUTTON = get("CreateNewProjectPage.UploadButton");
    private final By CREATE_PROJECT_BUTTON = get("CreateNewProjectPage.CreateProjectButton");


    public ProjectPage createNewProject () throws IOException {
        driver.findElement(PROJECT_NAME_INPUT).sendKeys(Creds.PROJECT_NAME);
        driver.findElement(MANAGER_NAME_INPUT).click();
        driver.findElement(NUMBER_OF_INPUT).sendKeys(Creds.NUMBER_OF_INPUTS);
        driver.findElement(BROWSE_BUTTON).click();
        Runtime.getRuntime().exec(Creds.FILE_PATH);
        driver.findElement(UPLOAD_BUTTON).click();
        driver.findElement(CREATE_PROJECT_BUTTON).click();
        return new ProjectPage(driver);
    }
}
