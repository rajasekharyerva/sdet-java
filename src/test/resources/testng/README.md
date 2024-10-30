# TestNG
### Annotations / Order
    @BeforeSuite
    @BeforeClass
    @BeforeMethod
    @Test
    @DataProvider
    @AfterMethod
    @AfterClass
    @AfterSuite
### Depends on
    @Test(dependsOnMethods = {"testMethodA"})
    @Test(dependsOnGroups = {"group1"})

### parallel
    methods, tests, classes, instances
### thread-count
    thread-count=4
### Priority
    @Test(priority=1)
    default 0(same priority - order in code)
    lowest priority executes first(-1,0,1)
### Group
    @Test(groups = {"regression"})
    public void testA(){}

    @Test(groups = {"regression"})
    public void testB(){}

    <suite name="Sample Suite" verbose="1" parallel="false" thread-count="2">    
        <test name="RegressionTests">
            <groups>
                <run>
                    <include name="regression"/>
                </run>
            </groups>
            <classes>
                <class name="com.example.tests.MyTestClass"/>
            </classes>
            </test>
    </suite>
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

