package selenium.pages;

public class BasePage {
    // Generic method for a small pause
    public void pause(int millis) {
        try {
            Thread.sleep(millis);  // Pause for 500ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Reset interrupt status
        }
    }
}
