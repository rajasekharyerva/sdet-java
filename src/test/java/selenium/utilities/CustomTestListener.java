package selenium.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static selenium.tests.BaseTest.extent;

public class CustomTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getMethod().getMethodName());
        TestResultLogger.logResult(result.getMethod().getMethodName(), "PASS", "");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getMethod().getMethodName());
        System.out.println("Reason: " + result.getThrowable());
        TestResultLogger.logResult(result.getMethod().getMethodName(), "FAIL", "");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("All tests finished...");
        //
        System.out.println("Ekkadiki pothav chinnavada");
        extent.flush();
    }

    // You can also override other methods like onStart, onConfigurationSuccess, etc.
}
