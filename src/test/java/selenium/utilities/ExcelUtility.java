package selenium.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {
    public static void writer() {
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
        try (FileOutputStream fileOut = new FileOutputStream("test_data/excel/data.xlsx")) {
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

    public static String[] reader(){
        String filePath = "src/test/resources/data.xlsx"; // Path to your Excel file
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each row
            for (Row row : sheet) {
                // Iterate through each cell in the row
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("Unknown Cell Type\t");
                    }
                }
                System.out.println(); // Move to the next line after each row
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{"rajasekhar", "Sekhar1@"};
    }
}
