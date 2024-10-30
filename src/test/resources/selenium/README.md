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
    
