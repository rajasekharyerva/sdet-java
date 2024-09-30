package selenium.tests;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriterExample {
    public static void main(String[] args) {
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Data");

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create Header Cells
        headerRow.createCell(0).setCellValue("username");
        headerRow.createCell(1).setCellValue("password");

        // Create Sample Data
        Object[][] data = {
                {"rajasekhar", "Sekhar1@"},
        };

        // Populate the Data
        int rowNum = 1;
        for (Object[] rowData : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : rowData) {
                row.createCell(colNum++).setCellValue(field.toString());
            }
        }

        // Write the Output to a File
        try (FileOutputStream fileOut = new FileOutputStream("src/test/resources/data.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Closing the Workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

