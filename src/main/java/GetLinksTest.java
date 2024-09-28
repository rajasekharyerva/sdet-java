import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GetLinksTest {


    @Test(groups = {"sanity"})
    public void getLinks() {
//        HomePage homePage = new HomePage(webDriver);
//        List<String> sourceList = homePage.getSelectOptionsSource();
//        List<String> destinationList = homePage.getSelectOptionsDestination();
//        List<String> finalList = getFinalList(sourceList, destinationList);
//        finalList.forEach(System.out::println);
        System.out.println("Only getLinks1");
    }

    @Test(groups = {"sanity2"})
    public void getLinks2() {
        System.out.println("Only getLinks2");
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




    @BeforeGroups
    public void setUp(){
        System.out.println("setUp");
    }

    @AfterGroups
    public void tearDown(){
        System.out.println("tearDown");
    }

    @BeforeMethod
    public void setUp1(){
        System.out.println("setUp1");
    }

    @AfterMethod
    public void tearDown1(){
        System.out.println("tearDown1");
    }


}
