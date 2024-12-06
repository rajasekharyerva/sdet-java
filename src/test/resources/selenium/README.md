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

### JavaScriptExecutor
    Interacting with Hidden Elements
    Scrolling the Page
    Manipulating DOM Elements
    Waiting for Elements to Load
    Extracting Information
    Firing Events
    Handling Alerts and Pop-ups
    Performance Testing and Profiling

### XPath Axes Overview
    Child (/): Selects children of the current node
    Parent (..): Selects the parent of the current node
    Descendant (//): Selects all descendants (children, grandchildren, etc.) of the current node
    Ancestor (/..): Selects all ancestors (parent, grandparent, etc.) of the current node
    Following Sibling (following-sibling::): Selects siblings after the current node
    Preceding Sibling (preceding-sibling::): Selects siblings before the current node
### Handling SSL Certificates in Chrome (ChromeDriver)
    //Create ChromeOptions object
    ChromeOptions options = new ChromeOptions();

    // Add argument to ignore SSL certificate errors
    options.addArguments("--ignore-certificate-errors");


### Window
    // Get the current window handle
    String currentWindow = driver.getWindowHandle();

    // Get all window handles
    Set<String> windowHandles = driver.getWindowHandles();
    driver.switchTo().window(windowHandle);

    // Now you are in the new window, you can perform actions in it
    // For example, to close the new window and switch back to the original window:
    driver.close();
    driver.switchTo().window(currentWindow);



### Frame
    // Switch to the first frame
    driver.switchTo().frame(0);
    
    // Switch to frame by name or id
    driver.switchTo().frame("frameNameOrId");
    
    // Switch to a frame by WebElement
    WebElement frameElement = driver.findElement(By.id("frameId"));
    driver.switchTo().frame(frameElement);
    
    driver.switchTo().defaultContent();

