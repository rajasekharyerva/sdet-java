package sdet.files;

import java.io.*;
import java.util.*;

public class TailF {
    // Function to get the last n lines from the file
    public static List<String> tailF(String filePath, int n) throws IOException {
        List<String> result = new LinkedList<>(); // Linked list to store lines

        RandomAccessFile file = new RandomAccessFile(filePath, "r"); // Open file in read mode
        long fileLength = file.length(); // Get the length of the file
        long pos = fileLength - 1; // Set the initial position to the end of the file
        int linesCount = 0;

        // Read the file from the end to start
        while (pos >= 0 && linesCount < n) {
            file.seek(pos); // Move the cursor to the current position
            char c = (char) file.readByte(); // Read the character

            if (c == '\n') { // Count the lines
                linesCount++;
            }

            pos--; // Move the cursor back
        }

        // Move to the next line if we counted too many lines
        if (pos > 0) {
            file.seek(pos + 2);
        }

        String line;
        // Add the lines to the list
        while ((line = file.readLine()) != null) {
            result.add(line);
        }

        file.close(); // Close the file

        return result; // Return the list of lines
    }

    public static void main(String[] args) throws IOException {
        // File path to the log file
        String filePath = "test.log";
        int numOfLines = 5; // Number of lines to fetch from the file

        List<String> lastLines = tailF(filePath, numOfLines); // Get the last lines
        for (String line : lastLines) {
            System.out.println(line); // Print the lines
        }
    }
}

