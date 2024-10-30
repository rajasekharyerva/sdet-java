# TestNG
### parallel
    methods, tests, classes, instances
### thread-count
    thread-count=4
## Parameters
### XML Configuration
    <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
    <suite name="Suite1">
        <test name="Test1">
            <parameter name="username" value="testuser"/>
            <parameter name="password" value="testpass"/>
            <classes>
                <class name="your.package.TestClass"/>
            </classes>
        </test>
    </suite>

    @Parameters({"username", "password"})
    @Test
    public void loginTest(String username, String password) {
    //TO-DO:
    }

### DataProvider
    import org.testng.annotations.DataProvider;
    import org.testng.annotations.Test;

    public class TestClass {
    
        @DataProvider(name = "loginData", parallel = true)
        public Object[][] loginDataProvider() {
            return new Object[][] {
                {"testuser1", "testpass1"},
                {"testuser2", "testpass2"}
            };
        }
    
        @Test(dataProvider = "loginData")
        public void loginTest(String username, String password) {
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            // Add your test logic here
        }
    }

