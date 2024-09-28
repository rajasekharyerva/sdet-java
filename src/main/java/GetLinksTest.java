import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetLinksTest extends BaseTest {


    @Test(testName = "getLinks", groups = {"sanity"})
    public void getLinks() {
        HomePage homePage = new HomePage(webDriver);
        List<String> sourceList = homePage.getSelectOptionsSource();
        List<String> destinationList = homePage.getSelectOptionsDestination();
        List<String> finalList = getFinalList(sourceList, destinationList);
        finalList.forEach(System.out::println);
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


    public void getList() {
        List<WebElement> listElements = webDriver.findElements(By.xpath("//div[@class=\"navigation\"]/ul[1]/li"));
        for (WebElement webElement : listElements) {
            System.out.println(webElement.getText());
        }
    }


}
