package sdet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class JsonIterator {
    public static void main(String[] args) throws JSONException {
        // Sample JSON
        String jsonString = """
                {
                    "name": "John",
                    "age": 30,
                    "skills": ["Java", "Selenium"],
                    "address": {
                        "street": "123 Main St",
                        "city": "New York"
                    },
                    "isActive": true
                }
                """;

        JSONObject jsonObject = new JSONObject(jsonString);
        iterateJson(jsonObject);
    }

    public static void iterateJson(Object obj) throws JSONException {
        if (obj instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) obj;
            for (Iterator it = jsonObject.keys(); it.hasNext(); ) {
                String key = (String) it.next();
                System.out.println("Key: " + key);
                Object value = jsonObject.get(key);
                checkValue(value);
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) obj;
            for (int i = 0; i < jsonArray.length(); i++) {
                System.out.println("Array Index: " + i);
                Object value = jsonArray.get(i);
                checkValue(value);
            }
        } else {
            System.out.println("Value: " + obj + " (Type: " + obj.getClass().getSimpleName() + ")");
        }
    }

    public static void checkValue(Object value) throws JSONException {
        if (value instanceof JSONObject) {
            System.out.println("Node: JSONObject");
            iterateJson(value);
        } else if (value instanceof JSONArray) {
            System.out.println("Node: JSONArray");
            iterateJson(value);
        } else {
            System.out.println("Value: " + value + " (Type: " + value.getClass().getSimpleName() + ")");
        }
    }
}