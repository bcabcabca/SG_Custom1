package pages;

import static helper.Locators.get;

import helper.Waiter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by HP on 1/18/2017.
 */
public class ProjectPage extends PageBase{

    private static final By OUTPUT_ITEM = get("ProjectPage.Output");
    private static final By EQUIPMENT_LIST_TAB = get("ProjectPage.EquipmentList");
    private static final By SUBMIT_PROJECT_BUTTON = get("ProjectPage.SubmitProjectButton");
    private static final By COMMERCIAL_PROPOSAL_BUTTON = get("ProjectPage.CommercialProposalButton");
    private static final By SUBMIT_PROPOSAL_BUTTON = get("ProjectPage.SubmitCommercialProposalButton");
    private static final By ORDER_PROJECT = get("ProjectPage.OrderButton");
    private static final By BASIC_PARAMETERS_TAB = get("ProjectPage.BasicParametersButton");
    private static final By TABLE_OUTPUT1 = get("ProjectPage.TableOutput1");
    private static final By TABLE_OUTPUT2 = get("ProjectPage.TableOutput2");
    private static final By TABLE_OUTPUT3 = get("ProjectPage.TableOutput3");
    private static final By TABLE_OUTPUT5 = get("ProjectPage.TableOutput5");
    private static final By TABLE_OUTPUT6 = get("ProjectPage.TableOutput6");
    private static final By POP_UP = get("ProjectPage.PopUps");
    private static final By TABLE_INPUT1 = get("ProjectPage.TableInput1");
    private static final By TABLE_INPUT2 = get("ProjectPage.TableInput2");
    private static final By TABLE_INPUT3 = get("ProjectPage.TableInput3");
    private static final By TABLE_INPUT5 = get("ProjectPage.TableInput5");
    private static final By TABLE_INPUT6 = get("ProjectPage.TableInput6");
    private static final By ELEMENT_OUTPUT = get("ProjectPage.ElementOutput");
    private static final By TRANSFORMATOR_ELEMENT = get("ProjectPage.Transformator");
    private static final By TRANSFORMATOR_EQUIPMENT_LIST = get("ProjectPage.FirstTableEquipment");
    private static final By EQUIPMENT_SPECIFICATIONS = get("ProjectPage.ElementSpecifications");
    private static final By EQUIPMENT_SERISAL_NUMBER = get("ProjectPage.EquipmentSerialNumber");


    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public void changeData (){
        driver.findElement(ELEMENT_OUTPUT).click();
        clearAndInsertData(TABLE_INPUT1,".5");
        clearAndInsertData(TABLE_INPUT2,".5");
        clearAndInsertData(TABLE_INPUT3,".5");
        clearAndInsertData(TABLE_INPUT5,".5");
        clearAndInsertData(TABLE_INPUT6,"383");
    }
    public CreateNewProjectPage goToBasicParametersPage (){
        Waiter.getWaiter(driver).until(ExpectedConditions.presenceOfElementLocated(BASIC_PARAMETERS_TAB));
        driver.findElement(BASIC_PARAMETERS_TAB).click();
        return new CreateNewProjectPage(driver);
    }
    public String[] dataFromTable() {

        WebElement output1 = driver.findElement(TABLE_OUTPUT1);
        String str1 = output1.getText();

        WebElement output2 = driver.findElement(TABLE_OUTPUT2);
        String str2 = output2.getText();

        WebElement output3 = driver.findElement(TABLE_OUTPUT3);
        String str3 = output3.getText();

        WebElement output5 = driver.findElement(TABLE_OUTPUT5);
        String str4 = output5.getText();

        WebElement output6 = driver.findElement(TABLE_OUTPUT6);
        String str5 = output6.getText();

        String[] outputs = {str1, str2, str3, str4, str5};
        return outputs;
    }

    public boolean isOutputAdded() {
        WebElement output = driver.findElement(OUTPUT_ITEM);
        return output.isDisplayed();
    }
    public String getSerialNumber (){
        String EQUIPMENT_NUMBER = driver.findElement(EQUIPMENT_SPECIFICATIONS).getText();
        return EQUIPMENT_NUMBER;
    }

    public AccountPage submitProject (){
        driver.findElement(SUBMIT_PROJECT_BUTTON).click();
        Waiter.getWaiter(driver).until(ExpectedConditions.invisibilityOfElementLocated(POP_UP));
        return new AccountPage(driver);
    }

    public void addEquipment_Transformator(){
        driver.findElement(TRANSFORMATOR_ELEMENT).click();
        driver.findElement(EQUIPMENT_LIST_TAB).click();
        driver.findElement(TRANSFORMATOR_EQUIPMENT_LIST).click();
        driver.findElement(EQUIPMENT_SPECIFICATIONS).click();
    }
    public void makeCommercialProposal() {
        driver.findElement(COMMERCIAL_PROPOSAL_BUTTON).click();
        driver.findElement(SUBMIT_PROPOSAL_BUTTON).click();
        Waiter.getWaiter(driver).until(ExpectedConditions.invisibilityOfElementLocated(POP_UP));
    }

    public void sentNewProject()  {
        Waiter.getWaiter(driver).until(ExpectedConditions.presenceOfElementLocated(EQUIPMENT_LIST_TAB));
        driver.findElement(EQUIPMENT_LIST_TAB).click();
        driver.findElement(SUBMIT_PROJECT_BUTTON).click();
        Waiter.getWaiter(driver).until(ExpectedConditions.invisibilityOfElementLocated(POP_UP));
    }

    public boolean checkIfEquipmentWasAdded() {
        String number = driver.findElement(EQUIPMENT_SERISAL_NUMBER).getText();
        return number.contentEquals(getSerialNumber());
    }

    public AccountPage orderProject() {
        Waiter.getWaiter(driver).until(ExpectedConditions.presenceOfElementLocated(ORDER_PROJECT));
        driver.findElement(ORDER_PROJECT).click();
        return new AccountPage(driver);
    }
}
