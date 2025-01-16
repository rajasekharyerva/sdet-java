package nested.jsonfiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJSON {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new FileInputStream(System.getProperty("user.dir") + "/src/test/java/nested/jsonfiles/file.json"));
        printJsonNodeValues(jsonNode);
    }

    private static void printJsonNodeValues(JsonNode node) {
        if (node.isObject()) {
            // If the node is an Object, iterate through fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                System.out.println("Key: " + field.getKey() + ", Value: " + field.getValue());
                printJsonNodeValues(field.getValue());
            }
        } else if (node.isArray()) {
            // If the node is an Array, iterate through elements
            for (JsonNode arrayElement : node) {
                printJsonNodeValues(arrayElement);
            }
        } else {
            // If the node is a value, print it
            System.out.println("Value: " + node.asText());
        }
    }
}
