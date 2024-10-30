package selenium.tests.tdd;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataUtil {

    // Method to get all test data from the specified Excel file
    public static Object[][] getTestData(String filePath, String testCase) {
        Object[][] data = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
            int rowCount = sheet.getPhysicalNumberOfRows();
            data = new Object[rowCount - 1][1]; // Exclude header row

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row.getCell(0).getStringCellValue().equals(testCase)) {
                    Map<String, String> rowData = new HashMap<>();

                    rowData.put("testCase", row.getCell(0).getStringCellValue());
                    rowData.put("username", row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "");
                    rowData.put("password", row.getCell(2) != null ? row.getCell(2).getStringCellValue() : "");
                    rowData.put("lastName", row.getCell(3) != null ? row.getCell(3).getStringCellValue() : "");
                    rowData.put("city", row.getCell(4) != null ? row.getCell(4).getStringCellValue() : "");
                    rowData.put("firstName", row.getCell(5) != null ? row.getCell(5).getStringCellValue() : "");
                    rowData.put("dob", row.getCell(6) != null ? row.getCell(6).getStringCellValue() : "");

                    data[i - 1][0] = rowData; // Store the map in the array
                    break; // Exit loop after finding the specific test case
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
