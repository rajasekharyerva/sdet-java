package sdet.params;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleParamTest {
    @Parameters({"env"})
    @BeforeMethod
    public void beforeTest(String env) {
        System.out.println("Parameter: " + env);
    }

    @Test(groups = "special")
    public void sampleTest() {
        System.out.println("Sample test:  " + System.getProperty("env"));
    }

    @Test(groups = "special2")
    public void sampleTest2() {
        System.out.println("Sample test2:  " + System.getProperty("env"));
    }
}
