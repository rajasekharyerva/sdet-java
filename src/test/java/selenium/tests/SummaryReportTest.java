package selenium.tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SummaryReportTest {
    private static final String CSV_FILE_PATH = "test-results.csv";

    @Test
    public void generateSummaryReport() {
        ExtentReports extent = ExtentManager.createExtentReports();
        ExtentTest summaryTest = extent.createTest("Test Summary");

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] results = line.split(",");
                String testName = results[0];
                String status = results[1];
                String timestamp = results[3];

                summaryTest.log(Status.INFO, "Test Name: " + testName + ", Status: " + status + ", Date: " + timestamp);
            }
        } catch (IOException e) {
            summaryTest.log(Status.WARNING, "Failed to read test results: " + e.getMessage());
        }

        extent.flush();
    }
}
