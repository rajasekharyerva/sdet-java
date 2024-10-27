package selenium.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestResultLogger {
    private static final String FILE_PATH = "test-results.csv";

    public static void logResult(String testName, String status, String details) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.printf("%s,%s,%s,%s%n", testName, status, details, System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

