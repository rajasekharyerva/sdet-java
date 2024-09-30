package selenium.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import selenium.pages.HomePage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GetLinksTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @Test(groups = {"sanity"}, testName = "TC1-Merge 2 List")
    public void getLinksTest() {
        HomePage homePage = new HomePage(webDriver);
        List<String> sourceList = homePage.getSelectOptionsSource();
        List<String> destinationList = homePage.getSelectOptionsDestination();
        List<String> finalList = getFinalList(sourceList, destinationList);
        finalList.forEach(item -> logger.info("Item: {}", item));
    }

    @Test(groups = {"e2e"}, testName = "TC2-Sample E2E Test")
    public void e2eTest() {
        System.out.println("Only getLinks2");
    }

    @Test(groups = {"tbd"}, testName = "TC3-TBD Tets")
    public void dummyTest() {
    }

    @Test
    public void specificTest() {
    }

    private List<String> getFinalList(List<String> sourceList, List<String> destinationList) {
        // Create a Set to store unique elements
        Set<String> uniqueElements = new HashSet<>();

        // Add all elements from both lists to the Set
        uniqueElements.addAll(sourceList);
        uniqueElements.addAll(destinationList);

        // Convert the Set back to a List
        return new ArrayList<>(uniqueElements);
    }
}
