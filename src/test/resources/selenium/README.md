# Selenium commands
| Command Name                       | Command                                                        |
|------------------------------------|----------------------------------------------------------------|

### Headless Mode
    // Configure ChromeOptions to enable headless mode
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");

    // Configure FirefoxOptions to enable headless mode
    FirefoxOptions options = new FirefoxOptions();
    options.setHeadless(true); // Enable headless mode