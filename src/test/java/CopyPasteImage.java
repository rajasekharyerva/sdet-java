import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class CopyPasteImage {
    public static void main(String[] args) throws AWTException, IOException {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to the desired website
        driver.get("https://example.com");

        // Locate the image element
        WebElement imageElement = driver.findElement(By.xpath("//img[@alt='image_to_copy']"));

        // Copy the image to the clipboard
        String imageUrl = imageElement.getAttribute("src");
        File imageFile = new File("path_to_download_folder/image.png"); // Download image locally first (if needed)

        // Use Toolkit to copy to clipboard
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        Image img = toolkit.getImage(imageUrl); // Replace with locally downloaded image path
        clipboard.setContents(new TransferableImage(img), null);

        // Paste the image (using Robot for Ctrl+V)
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        driver.quit();
    }

    // Helper class to enable transferring image to clipboard
    static class TransferableImage implements Transferable {
        private final Image image;

        public TransferableImage(Image image) {
            this.image = image;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{DataFlavor.imageFlavor};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return DataFlavor.imageFlavor.equals(flavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
            if (!isDataFlavorSupported(flavor)) {
                throw new UnsupportedFlavorException(flavor);
            }
            return image;
        }
    }
}
