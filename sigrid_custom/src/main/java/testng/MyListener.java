package testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by HP on 1/18/2017.
 */
public class MyListener implements ITestListener {
    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
//        captureScreenshot();
//        getInfo();
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }

//    @Attachment(value = "Screenshot", type = "image/png")
//    private byte[] captureScreenshot() {
//        TakesScreenshot takesScreenshot = (TakesScreenshot) TestBase.getDriver();
//        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
//    }
//
//    @Attachment(value = "Info", type = "text/plain")
//    private String getInfo() {
//        return "Hello world!\nYour test failed!";
//    }
}

