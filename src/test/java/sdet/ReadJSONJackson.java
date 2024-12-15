package sdet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJSONJackson {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File("src/test/resources/book.json"));
        traverseNode(rootNode);


    }

    private static void traverseNode(JsonNode rootNode) {
        if (rootNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                JsonNode value = field.getValue();
                traverseNode(value);
            }
        } else if (rootNode.isArray()) {
            for (JsonNode arrayItem : rootNode) {
                traverseNode(arrayItem);
            }
        } else {
            System.out.println(rootNode.asText());
        }
    }
}
