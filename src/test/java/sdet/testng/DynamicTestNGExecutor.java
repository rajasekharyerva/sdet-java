package sdet.testng;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DynamicTestNGExecutor {
    // java DynamicTestNGExecutor com.example.tests SampleTest testMethod1
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java DynamicTestNGExecutor <package> <class> <method>");
            return;
        }

        // Step 1: Read and validate arguments
        String packageName = args[0];
        String className = args[1];
        String methodName = args[2];

        // Step 2: Create TestNG instance
        TestNG testng = new TestNG();

        // Step 3: Create XmlSuite
        XmlSuite suite = new XmlSuite();
        suite.setName("DynamicSuite");

        // Step 4: Create XmlTest
        XmlTest test = new XmlTest(suite);
        test.setName("DynamicTest");

        // Step 5: Create XmlClass with dynamic input and method
        XmlClass xmlClass = new XmlClass(packageName + "." + className);
        List<XmlInclude> methods = new ArrayList<>();
        methods.add(new XmlInclude(methodName)); // Include the method passed as runtime argument
        xmlClass.setIncludedMethods(methods);

        // Step 6: Add XmlClass to XmlTest
        test.setXmlClasses(Collections.singletonList(xmlClass));

        // Step 7: Set the suite and run TestNG
        testng.setXmlSuites(Collections.singletonList(suite));
        testng.run();
    }
}

