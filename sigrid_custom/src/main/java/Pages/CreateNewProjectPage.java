package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static helper.Locators.get;

/**
 * Created by HP on 1/18/2017.
 */
public class CreateNewProjectPage extends PageBase {
    private PageBase pageBase;

    private static final By PROJECT_NAME_INPUT = get("CreateNewProjectPage.ProjectName");
    private static final By MANAGER_NAME_INPUT = get("CreateNewProjectPage.SelectManagerDropdown");
    private static final By NUMBER_OF_INPUT = get("CreateNewProjectPage.NumberOfInputs");
    private static final By BROWSE_BUTTON = get("CreateNewProjectPage.BrowseButton");
    private static final By UPLOAD_BUTTON = get("CreateNewProjectPage.UploadButton");
    private static final By CREATE_PROJECT_BUTTON = get("CreateNewProjectPage.CreateProjectButton");
    private static final By PA_INPUT = get("CreateNewProjectPage.PActiveInput");
    private static final By P_FULL_INPUT = get("CreateNewProjectPage.PFul");
    private static final By COS_INPUT = get("CreateNewProjectPage.Cos");
    private static final By D_FACTOR_INPUT = get("CreateNewProjectPage.DFactor");
    private static final By UB_INPUT = get("CreateNewProject.PageU(B)");
    private static final By ADD_BUTTON = get("CreateNewProjectPage.AddButton");
    private final String FILE_PATH = "C:\\Users\\HP\\Desktop\\uploadDocument.exe";

    public CreateNewProjectPage(WebDriver driver) {
        super(driver);
    }

    public ProjectPage createNewProject(String projectName) throws IOException {
        pageBase = new PageBase(driver);
        driver.findElement(PROJECT_NAME_INPUT).sendKeys(projectName);
        driver.findElement(MANAGER_NAME_INPUT).click();
        driver.findElement(NUMBER_OF_INPUT).sendKeys("1");
        driver.findElement(BROWSE_BUTTON).click();
        Runtime.getRuntime().exec(FILE_PATH);
        driver.findElement(UPLOAD_BUTTON).click();

        pageBase.clearAndInsertData(PA_INPUT, "1");
        pageBase.clearAndInsertData(P_FULL_INPUT,"1");
        pageBase.clearAndInsertData(COS_INPUT,"1");
        pageBase.clearAndInsertData(D_FACTOR_INPUT,"1");
        pageBase.clearAndInsertData(UB_INPUT,"381");
        driver.findElement(ADD_BUTTON).click();
        driver.findElement(CREATE_PROJECT_BUTTON).sendKeys(Keys.ENTER);
        return new ProjectPage(driver);
    }
}
