package files;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;

public class FileDownloadRobot {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();

        // Simulate pressing keys to download the file (e.g., Ctrl + S for Save As dialog)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Wait for the "Save As" dialog to open
        Thread.sleep(2000);

        // Type the destination file name and path
        String filePath = "C:\\path\\to\\save\\file.txt";

        for (char c : filePath.toCharArray()) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
        }

        // Press Enter to save the file
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}

