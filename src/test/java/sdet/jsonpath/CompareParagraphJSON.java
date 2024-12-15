package sdet.jsonpath;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class CompareParagraphJSON {
    public static void main(String[] args) throws IOException {
        String paragraph = "To search for a book by its title or category in the provided JSON structure, you can query the store object, specifically the book array";
        String[] paragraphWords = paragraph.split(" ");
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(new File("src/test/resources/book.json"));
        fetchValuesFromJsonNode(jsonNode);
        for(String word : paragraphWords) {

            if(jsonNode.toString().contains(word)) {
                System.out.println("Word: " + word + " is present in JSON");
            } else {
                System.out.println("Word: " + word + " is not present in JSON");
            }
        }
    }

    public static void fetchValuesFromJsonNode(JsonNode node) {
        // If the node is an array, iterate through the array
        if (node.isArray()) {
            for (JsonNode arrayItem : node) {
                fetchValuesFromJsonNode(arrayItem); // Recursively process each item in the array
            }
        }
        // If the node is an object, iterate over its fields
        else if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                JsonNode value = field.getValue();

                // Recursively fetch values from nested objects or arrays
                fetchValuesFromJsonNode(value);
            }
        } else {
            // For leaf nodes, print the value (e.g., strings, numbers, booleans)
            System.out.println(node.asText());
        }
    }
}
