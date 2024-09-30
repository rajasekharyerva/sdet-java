package selenium.utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionOperations {

    public static List<String> getFinalList(List<String> sourceList, List<String> destinationList) {
        // Create a Set to store unique elements
        Set<String> uniqueElements = new HashSet<>();

        // Add all elements from both lists to the Set
        uniqueElements.addAll(sourceList);
        uniqueElements.addAll(destinationList);

        // Convert the Set back to a List
        return new ArrayList<>(uniqueElements);
    }
}
