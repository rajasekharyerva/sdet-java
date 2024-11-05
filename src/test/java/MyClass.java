import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyClass {
    /*public static void main(String [] args) {
        System.out.println("Hello, World!");
    }*/

    @Test
    public void testMethod(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("www.google.com");
    }
}
