package sdet.numbers;

import java.util.*;
import java.util.regex.*;

public class HtmlTagCounter {
    public static void main(String[] args) {
        String html = "<html><body><h1>Title</h1><p>This is a paragraph.</p><p>This is another paragraph.</p></body></html>";

        // Step 1: Parse HTML and extract tags
        HashMap<String, Integer> tagCount = new HashMap<>();
        Stack<String> tagStack = new Stack<>();

        // Regex to match HTML tags
        Pattern tagPattern = Pattern.compile("</?([a-zA-Z1-6]+)[^>]*>");
        Matcher matcher = tagPattern.matcher(html);

        while (matcher.find()) {
            String tag = matcher.group(1);
            if (tag.startsWith("/")) {
                // Closing tag
                if (!tagStack.isEmpty() && tagStack.peek().equals(tag.substring(1))) {
                    tagStack.pop();  // Pop the matched opening tag
                } else {
                    System.out.println("Unbalanced closing tag: </" + tag.substring(1) + ">");
                }
            } else {
                // Opening tag
                tagCount.put(tag, tagCount.getOrDefault(tag, 0) + 1);
                tagStack.push(tag);  // Push opening tag to the stack
            }
        }

        // Step 2: Count occurrences of each tag
        System.out.println("Tag Count:");
        for (Map.Entry<String, Integer> entry : tagCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Step 3: Check if the tags are balanced
        if (!tagStack.isEmpty()) {
            System.out.println("Unbalanced opening tag: <" + tagStack.peek() + ">");
        } else {
            System.out.println("All tags are balanced.");
        }
    }
}

