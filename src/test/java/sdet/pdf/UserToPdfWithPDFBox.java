package sdet.pdf;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserToPdfWithPDFBox {

    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String JDBC_USER = "user";
    private static final String JDBC_PASSWORD = "user_password";

    public static void main(String[] args) {
        // Step 1: Read user data from the database
        List<Map<String, Object>> users = fetchUsersFromDatabase();

        if (users != null && !users.isEmpty()) {
            // Step 2: Generate PDF with the user data
            String pdfFilePath = "user_data.pdf";
            generatePdf(users, pdfFilePath);

            // Step 3: Validate the PDF contents (for simplicity, we'll just print to console here)
            validatePdfContent(pdfFilePath, users);
        }
    }

    // Step 1: Fetch users from the database
    private static List<Map<String, Object>> fetchUsersFromDatabase() {
        List<Map<String, Object>> users = new ArrayList<>();
        String query = "SELECT id, name, email FROM users";  // Adjust your query as needed

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Map<String, Object> user = new HashMap<>();
                user.put("id", rs.getInt("id"));
                user.put("name", rs.getString("name"));
                user.put("email", rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Step 2: Generate PDF using Apache PDFBox
    private static void generatePdf(List<Map<String, Object>> users, String filePath) {
        try {
            PDDocument document = new PDDocument();

            // Create A4 page
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 16); // Use Helvetica Bold font
            contentStream.newLineAtOffset(100, 750);
            contentStream.showText("User Data");
            contentStream.newLineAtOffset(0, -20);

            // Set font for table content (using Helvetica regular font)
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER), 12); // Use Helvetica regular font
            //contentStream.showText("ID\tName\tEmail");
            contentStream.showText("ID Name Email");
            contentStream.newLineAtOffset(0, -20);

            // Add table data from users
            for (Map<String, Object> user : users) {
                // contentStream.showText(user.get("id").toString() + "\t" + user.get("name") + "\t" + user.get("email"));
                contentStream.showText(user.get("id").toString() + " " + user.get("name") + " " + user.get("email"));
                contentStream.newLineAtOffset(0, -20);
            }

            contentStream.endText();
            contentStream.close();

            document.save(filePath);
            document.close();
            System.out.println("PDF generated successfully at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Step 3: Validate PDF content using Apache PDFBox
    private static void validatePdfContent(String pdfFilePath, List<Map<String, Object>> expectedData) {


            // Open the file using Files.newInputStream() to get an InputStream
            try{
                // Load the PDF document using InputStream
                PDDocument document = Loader.loadPDF(new File(pdfFilePath));

                // Extract text from the PDF
                PDFTextStripper stripper = new PDFTextStripper();
                String pdfText = stripper.getText(document);

                document.close();

                // Validate the content by checking each user's data
                for (Map<String, Object> user : expectedData) {
                    String userData = user.get("id") + " " + user.get("name") + " " + user.get("email");
                    if (pdfText.contains(userData)) {
                        System.out.println("Valid content found in PDF: " + userData);
                    } else {
                        System.out.println("Content mismatch for: " + userData);
                    }
                }
            }
         catch (IOException e) {
            e.printStackTrace();
        }
    }
}
