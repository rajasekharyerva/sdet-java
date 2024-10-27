package selenium.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createExtentReports() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}

