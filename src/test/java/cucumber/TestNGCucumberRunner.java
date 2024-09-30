package cucumber;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber/steps", // Replace with your package name containing ApiSteps
        plugin = {"pretty", "json:target/cucumber.json"}
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
}

