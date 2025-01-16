package sdet.cc;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class URLParser {
    public static void main(String[] args) {
        try {
            String input = "https://abc.in/api/users?page=2";

            // Create a URL object
            URL url = new URL(input);

            // Extract protocol
            String protocol = url.getProtocol();
            System.out.println(protocol);  // Output: https

            // Extract domain (host)
            String domain = url.getHost();
            System.out.println(domain);  // Output: abc.in

            // Extract path
            String path = url.getPath();
            String[] pathParts = path.split("/");
            // Skip the empty first element due to leading slash
            List<String> pathList = Arrays.asList(pathParts).subList(1, pathParts.length);
            for (String part : pathList) {
                System.out.println(part);  // Output: api, users
            }

            // Extract query parameters
            String query = url.getQuery();
            if (query != null) {
                String[] queryParams = query.split("&");
                Map<String, String> queryMap = new HashMap<>();
                for (String param : queryParams) {
                    String[] keyValue = param.split("=");
                    queryMap.put(keyValue[0], keyValue[1]);
                }
                System.out.println(queryMap);  // Output: {page=faq2}
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

