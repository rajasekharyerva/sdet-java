package selenium.utilities;

import org.testng.annotations.Test;

public class RepeatTest {
    @Test(invocationCount = 5, threadPoolSize = 3)
    public void repeatTest() {
        System.out.println("Running Test - " + Thread.currentThread().getId());
    }

}
