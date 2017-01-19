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
 * Created by HP on 1/17/2017.
 */
@Listeners(MyListener.class)
public class L1 {
    private AccountPage accountPage;
    private LoginPage loginPage;
    private WebDriver driver;
    private Creds creds;

    @BeforeMethod
    public void setUp (){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Creds.MAIN_URL);
        loginPage = new LoginPage(driver);

    }
    @Test (dataProvider = "loginData")
    @TestCaseId("L-1")
    @Features("Login")
    @Stories("Story 1")
    @Description("Test verifies login with multiple users")
    public void isUserLoggedIn (String userName, String password){
        loginPage.loginAccountPage(userName, password);
        accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isLogOutButtonVisible(), "Login Failure");
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
