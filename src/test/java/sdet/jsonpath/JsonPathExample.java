package sdet.jsonpath;

import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class JsonPathExample {
    public static void main(String[] args) {
        String json = """
            {
              "store": {
                "book": [
                  {
                    "category": "reference",
                    "author": "Nigel Rees",
                    "title": "Sayings of the Century",
                    "price": 8.95
                  },
                  {
                    "category": "fiction",
                    "author": "Evelyn Waugh",
                    "title": "Sword of Honour",
                    "price": 12.99
                  },
                  {
                    "category": "fiction",
                    "author": "Herman Melville",
                    "title": "Moby Dick",
                    "price": 8.99
                  },
                  {
                    "category": "fiction",
                    "author": "J. R. R. Tolkien",
                    "title": "The Lord of the Rings",
                    "price": 22.99
                  }
                ],
                "bicycle": {
                  "color": "red",
                  "price": 19.95
                }
              }
            }
        """;

        // Extract all book titles
        List<String> bookTitles = JsonPath.read(json, "$.store.book[*].title");
        System.out.println("Book Titles: " + bookTitles);

        // Extract all book prices greater than 10
        List<Double> expensiveBooks = JsonPath.read(json, "$.store.book[?(@.price > 10)].price");
        System.out.println("Books priced above $10: " + expensiveBooks);

        // Extract the color of the bicycle
        String bicycleColor = JsonPath.read(json, "$.store.bicycle.color");
        System.out.println("Bicycle Color: " + bicycleColor);
    }
}

