package multi_thread;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestListener implements ITestListener {

    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static ExtentReports extentReports;

    @Override
    public void onTestStart(ITestResult result) {
        extentTest.set(extentReports.createTest(result.getMethod().getMethodName()));
        //test = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optionally log failed tests within success percentage
    }

    @Override
    public void onStart(ITestContext context) {
        // You can initialize the ExtentReports here for each suite
        if (extentReports == null) {
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/test-output/extent-report.html");

            //ExtentReports extent = ExtentManager.getExtentReports();
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
        }
        //ExtentReports extent = new ExtentReports();
        //ExtentManager.setExtentReports(extent);
    }

    @Override
    public void onFinish(ITestContext context) {
        // After all tests, flush the reports for each thread
        //ExtentReports extent = ExtentManager.getExtentReports();
        extentReports.flush();
        //ExtentManager.removeExtentReports();
    }
}

