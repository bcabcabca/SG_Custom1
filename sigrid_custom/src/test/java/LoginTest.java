import helper.Creds;
import pages.AccountPage;
import pages.LoginPage;
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
 * Created by HP on 1/17/2017.
 */
@Listeners(MyListener.class)
public class LoginTest {
    private AccountPage accountPage;
    private LoginPage loginPage;
    private WebDriver driver;
    private final String MAIN_URL = "http://localhost:8080/sd/#/login-register";

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(MAIN_URL);
        loginPage = new LoginPage(driver);

    }

    @Test(dataProvider = "loginData")
    @TestCaseId("L-1")
    @Features("Login")
    @Stories("Story 1")
    @Description("Test verifies login with multiple users")
    public void isUserLoggedIn(String userName, String password) {
        accountPage = loginPage.login(userName, password);
        Assert.assertTrue(accountPage.isLogOutButtonVisible(), "Login Failure");
    }

    @Test(dataProvider = "loginData")
    @TestCaseId("L-4")
    @Features("Login")
    @Stories("Story 3")
    @Description("Test verifies login with ENTER key")
    public void loginWithEnterKey(String userName, String password) {
        accountPage = loginPage.loginWithEnter(userName, password);
        Assert.assertTrue(accountPage.isLogOutButtonVisible(), "Login Failure");
    }

    @Test(dataProvider = "loginData")
    @TestCaseId("L-2")
    @Features("LogOut")
    @Stories("Story 2")
    @Description("Test verifies logout of different users")
    public void logOutAccountPage(String userName, String password) {
        accountPage = loginPage.login(userName, password);
        loginPage = accountPage.logOut();
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "Log out failure");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @DataProvider(name = "loginData")
    public Object[][] entryData() {
        Object[][] loginData = new Object[3][2];
        loginData[0][0] = "admi.sigrid@gmail.com";
        loginData[0][1] = "123";
        loginData[1][0] = "designer.sigrid@gmail.com";
        loginData[1][1] = "123";
        loginData[2][0] = "manager.sigrid@gmail.com";
        loginData[2][1] = "123";
        return loginData;
    }
}
