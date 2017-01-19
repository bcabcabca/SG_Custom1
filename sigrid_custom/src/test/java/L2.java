import Helper.Creds;
import Pages.AccountPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import testng.MyListener;

import java.util.concurrent.TimeUnit;

/**
 * Created by HP on 1/18/2017.
 */
@Listeners(MyListener.class)
public class L2 {
    private WebDriver driver;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private Creds creds;

    @BeforeMethod ()
    public void setUp (){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Creds.MAIN_URL);

    }
    @Test (dataProvider = "loginData")
    @TestCaseId("L-2")
    @Features("LogOut")
    @Stories("Story 2")
    @Description("Test verifies logout of different users")
    public void logOutAccountPage (String userName, String password){
        loginPage = new LoginPage(driver);
        loginPage.loginAccountPage(userName,password);

        accountPage = new AccountPage(driver);
        accountPage.logOut();
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "Log out failure");
    }

    @AfterMethod
    public void tearDown (){
        driver.close();
    }
    @DataProvider (name="loginData")
    public Object[][] entryData (){
        Object[][] data;
        creds = new Creds();
        data = creds.loginInput();
        return data;
    }
}
