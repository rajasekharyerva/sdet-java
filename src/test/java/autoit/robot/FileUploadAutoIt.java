package autoit.robot;// Import necessary classes

import java.io.*;

public class FileUploadAutoIt {
    public static void main(String[] args) throws IOException {
        // Run the AutoIt script from Java
        String autoItScriptPath = "C:\\path_to_your_script\\fileUploadScript.exe";
        Process process = Runtime.getRuntime().exec(autoItScriptPath);


        /*
        AutoIt script to handle file upload
        WinWaitActive("File Upload") ; Wait for the file upload window
        Send("C:\path\to\your\file.txt") ; Send the file path
        Send("{ENTER}") ; Hit enter to upload the file
         */
    }
}

