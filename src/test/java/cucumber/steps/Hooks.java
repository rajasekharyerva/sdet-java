package cucumber.steps;

import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        System.out.println("This runs before each scenario.");
        // Example setup: Open browser, log in, etc.
    }
}

