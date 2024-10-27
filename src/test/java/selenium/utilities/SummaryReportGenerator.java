package selenium.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SummaryReportGenerator {
    private static final String FILE_PATH = "test-results.csv";
    //ExtentReports extent = ExtentManager.createExtentReports();
    //ExtentTest summaryTest = extent.createTest("Test Summary");

    public static void generateSummaryReport() {
        Map<String, Integer> statusCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String testName = parts[0];
                String status = parts[1];

                statusCount.put(status, statusCount.getOrDefault(status, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //ExtentTest summaryTest = extent.createTest("Summary Report");
        System.out.println("Summary Report:");
        for (Map.Entry<String, Integer> entry : statusCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        //extent.flush();
    }
}

