package Pages;
import static Helper.Locators.get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by HP on 1/18/2017.
 */
public class ProjectPage {

    private WebDriver driver;
    public ProjectPage(WebDriver driver) {
        this.driver=driver;
    }

    private final By OUTPUT_ITEM = get("ProjectPage.Output");

    public boolean isOutputAdded (){
        WebElement output = driver.findElement(OUTPUT_ITEM);
        return output.isDisplayed();
    }
}
