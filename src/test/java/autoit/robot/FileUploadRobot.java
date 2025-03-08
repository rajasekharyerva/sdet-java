package autoit.robot;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;

public class FileUploadRobot {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();

        // Simulate keyboard events to open the file dialog
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Wait for the file dialog to appear
        Thread.sleep(2000);

        // Type the file path
        String filePath = "C:\\path\\to\\your\\file.txt";

        for (char c : filePath.toCharArray()) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
        }

        // Press ENTER to upload the file
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}

