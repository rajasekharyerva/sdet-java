package sdet;

import java.io.File;

public class GetFileNames {
    public static void main(String[] args) {
        // Specify the folder path
        File folder = new File("/Users/rajasekharreddyyerva/Downloads/Hethika");

        // List all files in the folder
        File[] listOfFiles = folder.listFiles();
        System.out.println(listOfFiles.length);
        // Check if folder is valid
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                // Print only filenames (excluding directories)
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Folder does not exist or is empty.");
        }
    }
}

