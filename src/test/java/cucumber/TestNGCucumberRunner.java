package cucumber;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features", // Path to the feature files
        glue = "cucumber/steps", // Package containing step definitions
        plugin = {"pretty", "json:target/cucumber.json"},
        dryRun = true,
        tags = "@BG", // Optional: specify tags to run specific scenarios
        //tags = "@smoke or @validLogin", // Run scenarios with either of the tags
        //tags = "@smoke and @validLogin", // Run scenarios with both tags
        //tags = "~@skip", // Exclude scenarios tagged with @skip
        monochrome = true  // Optional: makes console output more readable
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
}



