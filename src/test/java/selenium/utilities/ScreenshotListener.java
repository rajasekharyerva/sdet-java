package selenium.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenshotListener implements ITestListener {

    //private WebDriver driver; // Initialize WebDriver as needed

    @Override
    public void onTestFailure(ITestResult result) {
        // Get the name of the failed test
        String testDescription = result.getMethod().getDescription();

        // Take a screenshot
        takeScreenshot(testDescription);
    }

    private void takeScreenshot(String testDescription) {
        WebDriver driver = DriverManager.getDriver();
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("target/screenshots/" + testDescription + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved for test: " + testDescription);
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Om Beem Bush");
        System.out.println("Starting test: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finished test: " + context.getName());
    }

    // You can override other methods if needed
}

