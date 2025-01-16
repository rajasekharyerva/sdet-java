package selenium.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Listeners({AllureTestNg.class})
public class TestCaseReadWriteTest {
    private static final String FILE_PATH = "test_data/excel/data.xlsx";

    @Test(description = "Create - Excel - Test Case Sheet")
    @Feature("Create Test Case Sheet")
    public void testCaseSheet() throws IOException {
        createTestCaseSheet();
        readTestCaseSheet();
    }

    @Step("read test case sheet")
    public void readTestCaseSheet() throws IOException {
        try (FileInputStream fileIn = new FileInputStream(FILE_PATH)) {
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sheet = workbook.getSheet("TestCases");

            // Iterate over rows and print each cell value
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.getStringCellValue() + "\t");
                }
                System.out.println();
            }
            workbook.close();
        }
    }

    @Step("create test case sheet")
    public void createTestCaseSheet() throws IOException {
        // Create Workbook, Sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("TestCases");

        // Headers
        String[] headers = {"Test Case ID", "Test Case Title", "Description", "Preconditions",
                "Test Steps", "Expected Result", "Actual Result", "Status",
                "Priority", "Notes"};

        // Create header row
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Add sample test case data
        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue("TC-01");
        dataRow.createCell(1).setCellValue("Login with valid creds");
        dataRow.createCell(2).setCellValue("Verify that users can log in with valid credentials");
        dataRow.createCell(3).setCellValue("User must have a valid account");
        dataRow.createCell(4).setCellValue("1. Open login page\nfaq2. Enter valid creds\n3. Click 'Login'");
        dataRow.createCell(5).setCellValue("User is redirected to the dashboard");
        dataRow.createCell(6).setCellValue("Pass");
        dataRow.createCell(7).setCellValue("High");
        dataRow.createCell(8).setCellValue("None");

        // Write
        try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    @BeforeMethod
    public void setUp() {

    }

    @AfterMethod
    public void tearDown() {

    }
}
