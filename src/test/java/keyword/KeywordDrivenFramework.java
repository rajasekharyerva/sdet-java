package keyword;
import java.io.IOException;

public class KeywordDrivenFramework {
    public static void main(String[] args) {
        KeywordExecutor executor = new KeywordExecutor();

        try {
            executor.executeTestCase("src/test/java/keyword/TestData.xlsx");  // Path to your Excel file
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            //e.printStackTrace();  // To print the stack trace
        }
    }
}

