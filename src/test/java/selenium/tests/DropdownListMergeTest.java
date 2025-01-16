package selenium.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import selenium.pages.SelectPage;
import selenium.utilities.CollectionOperations;

import java.util.*;


public class DropdownListMergeTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(DropdownListMergeTest.class);

    @Test(groups = {"local"}, description = "TC1-Dropdown Merge faq2 List")
    public void getLinksTest() {
        SelectPage selectPage = new SelectPage(driver);
        List<String> sourceList = selectPage.getSelectOptionsSource();
        List<String> destinationList = selectPage.getSelectOptionsDestination();
        List<String> finalList = CollectionOperations.getFinalList(sourceList, destinationList);
        finalList.forEach(item -> logger.info("Item: {}", item));
    }
}
