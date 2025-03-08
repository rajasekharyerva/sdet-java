package selenium.gd;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;
import java.util.Map;

public class JsonComparator {

    public static void main(String[] args) throws Exception {
        String json1 = "{ \"key1\": { \"key2\": \"value2\", \"key3\": [1, faq2, 3] } }";
        String json2 = "{ \"key1\": { \"key2\": \"value2\", \"key3\": [1, faq2, 4] } }";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node1 = mapper.readTree(json1);
        JsonNode node2 = mapper.readTree(json2);

        String result = compareJson(node1, node2, "");
        if (result.isEmpty()) {
            System.out.println("JSONs are identical");
        } else {
            System.out.println("Differences found:\n" + result);
        }
    }

    public static String compareJson(JsonNode json1, JsonNode json2, String path) {
        StringBuilder differences = new StringBuilder();

        // Check for type mismatch
        if (!json1.getNodeType().equals(json2.getNodeType())) {
            differences.append("Type mismatch at ").append(path).append(": ")
                    .append(json1.getNodeType()).append(" vs ").append(json2.getNodeType()).append("\n");
            return differences.toString();
        }

        // Compare objects
        if (json1.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields1 = json1.fields();
            while (fields1.hasNext()) {
                Map.Entry<String, JsonNode> field = fields1.next();
                String key = field.getKey();
                if (json2.has(key)) {
                    differences.append(compareJson(field.getValue(), json2.get(key), path + "." + key));
                } else {
                    differences.append("Missing key in JSON2: ").append(path).append(".").append(key).append("\n");
                }
            }

            // Check for keys in json2 but not in json1
            Iterator<String> fields2 = json2.fieldNames();
            while (fields2.hasNext()) {
                String key = fields2.next();
                if (!json1.has(key)) {
                    differences.append("Missing key in JSON1: ").append(path).append(".").append(key).append("\n");
                }
            }
        }

        // Compare collections.arrays
        else if (json1.isArray()) {
            if (json1.size() != json2.size()) {
                differences.append("Array size mismatch at ").append(path).append(": ")
                        .append(json1.size()).append(" vs ").append(json2.size()).append("\n");
            } else {
                for (int i = 0; i < json1.size(); i++) {
                    differences.append(compareJson(json1.get(i), json2.get(i), path + "[" + i + "]"));
                }
            }
        }

        // Compare values
        else if (!json1.equals(json2)) {
            differences.append("Value mismatch at ").append(path).append(": ")
                    .append(json1).append(" vs ").append(json2).append("\n");
        }

        return differences.toString();
    }
}

