import helper.Creds;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.CreateNewProjectPage;
import pages.LoginPage;
import pages.ProjectPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import testng.MyListener;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by HP on 1/18/2017.
 */
@Listeners(MyListener.class)
public class DesignerTest {
    private LoginPage loginPage;
    private AccountPage accountPage;
    private CreateNewProjectPage createNewProjectPage;
    private ProjectPage projectPage;
    private WebDriver driver;
    private final String MAIN_URL = "http://localhost:8080/sd/#/login-register";
    private String ProjectName;
    private static Random random = new Random();
    private static double value = random.nextInt(1000);
    private String manager = "manager", designer="designer", admin="admin";
    private String[] expectedData;
    private String[] expectedData2;

    @BeforeMethod
    public void setUp() {
        expectedData = new String[]{"1", "1", "1", "1", "381"};
        expectedData2 = new String[]{".5", ".5", ".5", ".5", "383"};
        ProjectName = "EXAMPLE_" + value;
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(MAIN_URL);
        loginPage = new LoginPage(driver);
    }

    @Test
    @TestCaseId("D-2")
    @Features("Vefification")
    @Stories("Story 4")
    @Description("Test verifies if output element was added to a project table")
    public void checkOutput() throws IOException {
        accountPage = loginPage.logInAs(designer);
        createNewProjectPage=accountPage.moveToNewProjectPage();
        projectPage = createNewProjectPage.createNewProject(ProjectName);
        Assert.assertTrue(projectPage.isOutputAdded(), "Output Not Added");
    }

    @Test
    @TestCaseId("D-4")
    @Features("Notification")
    @Stories("Story 7")
    @Description("Test verifies the ability to make commercial proposal and buy a project")
    public void isProjectAvailable() throws IOException{
// Create new project and send it to a manager
        loginPage = new LoginPage(driver);
        accountPage = loginPage.logInAs(designer);
        createNewProjectPage = accountPage.moveToNewProjectPage();
        projectPage = createNewProjectPage.createNewProject(ProjectName);
        projectPage.sentNewProject();
        loginPage=projectPage.logOut();
//Login as manager and make commercial proposal
        accountPage = loginPage.logInAs(manager);
        projectPage = accountPage.findAndOpenProject(ProjectName);
        projectPage.makeCommercialProposal();
        loginPage=projectPage.logOut();
//Login as designer and order a project
        accountPage = loginPage.logInAs(designer);
        accountPage.goToInboxTab();
        projectPage = accountPage.orderProject(ProjectName);
        accountPage = projectPage.orderProject();
        Assert.assertTrue(accountPage.isProjectInInbox(ProjectName), "Project is still in inbox");
        Assert.assertTrue(accountPage.isProjectOrdered(ProjectName), "Project not ordered");
    }

    @Test
    @TestCaseId("D-6")
    @Features("Notification")
    @Stories("Story 5")
    @Description("Test verifies notifications to manager")
    public void isNewProjectCreated() throws IOException{
//Create and send project to manager
        accountPage = loginPage.logInAs(designer);
        createNewProjectPage = accountPage.moveToNewProjectPage();
        projectPage = createNewProjectPage.createNewProject(ProjectName);
        projectPage.sentNewProject();
        loginPage=projectPage.logOut();
//Login as manager and find a project in inbox
        accountPage = loginPage.logInAs(manager);
        Assert.assertTrue(accountPage.findProjectByNameInInbox(ProjectName), "Project was not saved");
    }

    @Test
    @TestCaseId("D-7")
    @Features("Data table")
    @Stories("Story 6")
    @Description("Test verifies table data output")
    public void checkDataOutput() throws IOException {
        accountPage = loginPage.logInAs(designer);
        createNewProjectPage=accountPage.moveToNewProjectPage();
        projectPage = createNewProjectPage.createNewProject(ProjectName);
        createNewProjectPage=projectPage.goToBasicParametersPage();
        Assert.assertEquals(projectPage.dataFromTable(), expectedData);
    }

    @Test
    @TestCaseId("D-8")
    @Features("Data Table")
    @Stories("Story 8")
    @Description("Test verifies if data changed in a table is saved")
    public void isDataChanged () throws IOException {
        accountPage=loginPage.logInAs(designer);
        createNewProjectPage=accountPage.moveToNewProjectPage();
        projectPage = createNewProjectPage.createNewProject(ProjectName);
        projectPage.changeData();
        createNewProjectPage=projectPage.goToBasicParametersPage();
        Assert.assertEquals(projectPage.dataFromTable(), expectedData2);
    }

//    @Test
//    @TestCaseId("D-9")
//    @Features("Equipment list")
//    @Stories("Story 9")
//    @Description("Test verifies if equipment list is changed")
//    public void isEquipmentListChanged () throws IOException {
//// Create new project and send it to a manager
//        loginPage = new LoginPage(driver);
//        accountPage = loginPage.logInAs(designer);
//        createNewProjectPage = accountPage.moveToNewProjectPage();
//        projectPage = createNewProjectPage.createNewProject(ProjectName);
//        projectPage.sentNewProject();
//        loginPage=projectPage.logOut();
////Login as manager and make commercial proposal and add equipment
//        accountPage = loginPage.logInAs(manager);
//        projectPage = accountPage.findAndOpenProject(ProjectName);
//        projectPage.addEquipment_Transformator();
//        projectPage.getSerialNumber();
//        projectPage.submitProject();
//        loginPage=projectPage.logOut();
////Login as designer and check equipment list
//        accountPage = loginPage.logInAs(designer);
//        projectPage = accountPage.findProjectInInbox(ProjectName);
//        Assert.assertTrue(projectPage.checkIfEquipmentWasAdded(), "Equipment was not added");
//    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
