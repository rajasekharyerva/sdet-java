package keyword;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class KeywordExecutor {
    KeywordActions actions = new KeywordActions();
    WebDriver driver;

    // Method to execute a test case from Excel
    public void executeTestCase(String excelFilePath) throws IOException {
        FileInputStream file = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet

        // Iterate through the rows of the sheet
        // Skip the first row (header) by starting from row index 1
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            String keyword = row.getCell(1).getStringCellValue();
            String param1 = row.getCell(2).getStringCellValue();
            String param2 = row.getCell(3) != null ? row.getCell(3).getStringCellValue() : "";

            // Execute the corresponding method based on the keyword
            switch (keyword) {
                case "Open Browser":
                    actions.openBrowser(param1);
                    break;
                case "Navigate":
                    actions.navigate(param1);
                    break;
                case "Enter Text":
                    actions.enterText(param1, param2);
                    break;
                case "Click":
                    actions.click(param1);
                    break;
                case "Verify Text":
                    actions.verifyText(param1, param2);
                    break;
                case "Close Browser":
                    actions.closeBrowser();
                    break;
                default:
                    System.out.println("Unknown keyword: " + keyword);
                    break;
            }
        }
        file.close();
    }
}

