import Helper.Creds;
import Pages.AccountPage;
import Pages.CreateNewProjectPage;
import Pages.LoginPage;
import Pages.ProjectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import testng.MyListener;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by HP on 1/18/2017.
 */
@Listeners(MyListener.class)
public class D2 {
    private LoginPage loginPage;
    private AccountPage accountPage;
    private CreateNewProjectPage createNewProjectPage;
    private ProjectPage projectPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp (){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Creds.MAIN_URL);

        loginPage = new LoginPage(driver);
        loginPage.loginAccountPage(Creds.DESIGNER_EMAIL, Creds.DESIGNER_PASSWORD);

        accountPage = new AccountPage(driver);
        createNewProjectPage = accountPage.moveToNewProjectPage();
    }

    @Test
    @TestCaseId("D-2")
    @Features("Vefification")
    @Stories("Story 4")
    @Description("Test verifies if output is added to a project table")
    public void checkOutput () throws IOException {
        projectPage = createNewProjectPage.createNewProject();
        Assert.assertTrue(projectPage.isOutputAdded(), "Output Not Added");
    }

    @AfterMethod
    public void tearDown (){
        driver.close();
    }
}
