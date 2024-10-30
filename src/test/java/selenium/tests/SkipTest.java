package selenium.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class SkipTest {

    @Feature("Skip")
    @Description("Test disabled")
    @Test(description = "Test A", enabled = false)
    public void testA() {
        System.out.println("Test A");
    }

    @Feature("Skip")
    @Description("Test enable/disable")
    @Test(description = "Test A")
    public void testB() {
        System.out.println("Test B");
    }
}
