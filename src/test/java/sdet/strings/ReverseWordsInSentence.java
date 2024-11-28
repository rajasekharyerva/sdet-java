package sdet.strings;

public class ReverseWordsInSentence {
    public static void main(String args[]){
        String input = "I am a boy";

        // Split the string into words
        String[] words = input.split(" ");
        StringBuilder reversedOutput = new StringBuilder();

        // Reverse each word
        for (String word : words) {
            StringBuilder reverseWord = new StringBuilder(word);
            reversedOutput.append(reverseWord.reverse().toString()).append(" ");
        }

        // Trim the last space and print
        System.out.println("Reversed Characters in Words: " + reversedOutput.toString().trim());
    }
}
