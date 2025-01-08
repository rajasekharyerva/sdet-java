package sdet.practice;

import java.util.*;

public class SDET {
    public static void main(String[] args) {
        //Move all zeros in an array to the end.
        //Example: Arr[] = {1,0,7,0,4,0,5,0} → Output: [1,7,4,5,0,0,0,0]
        //moveAllZerosToEnd();
        //2. Move all odd numbers to the front and even numbers to the end in an array.
        //Example: Arr[] = {1,2,3,4,5,6,7,8} → Output: [1,3,5,7,2,4,6,8]
        //moveOddToFrontEvenToEnd();
        //3. Reverse alternate words in a given string.
        //Example: str = "selenium cypress playwright webdriverio" → Output: "selenium sserpyc playwright iorevirdbew"
        //reverseAlternateWords();
        //6. Reverse an array in subsets of size N.
        //Example: If N=3, Arr[] = {1,2,3,4,5,6,7,8,9} → Output: [3,2,1,6,5,4,9,8,7]
        //reverseSubsetArray();
        //7. Print characters with their occurrence in a given string.
        //Example: str = "aabbbccccddddd" → Output: "a2b3c4d5"
        //printCharsOccurences();
        //10. Capitalize the first letter of each word in a given string.
        //Example: str = "i love coding" → Output: "I Love Coding"
        //capitalizeFirstLetters();
        //8. Map the position of elements from one list to another.
        //Example: list1 = {1,2,3,4,5,8}, list2 = {8,4,5,2,1,3} → Output: [4=1, 3=5, 5=2, 1=4, 2=3, 0=8]
        //mapPositions();
        //9. Find the first negative number in each sliding window of size N in an array.
        //Example: arr[] = {1, -1, 3, 4, -5, 6, -8, 5, -6}, N=3 → Output: [-1, -5, -8]
        firstNegativeNumberInWindow();

    }

    private static void firstNegativeNumberInWindow() {
        int[] input = {1, -1, 3, 4, -5, 6, -8, 5, -6};
        int k = 3;
        int start = 0;
        //check size
        for (int i = 0; i < input.length; i += k) {
            int left = i;
            // Calculate the right index for the current subset
            int right = Math.min(i + k - 1, input.length - 1);
            while (left < right) {
                if (input[left] < 0) {
                    System.out.println(input[left]);
                    break;
                }
                left++;
            }
        }

        //Arrays.stream(input).forEach(System.out::print);
    }

    private static void mapPositions() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 8);
        List<Integer> list2 = Arrays.asList(8, 4, 5, 2, 1, 3);

        for (int item : list) {
            System.out.println(item + " at " + list2.indexOf(item));
        }
    }

    private static void capitalizeFirstLetters() {
        var str = "i love coding";
        var strArr = str.split(" ");
        var output = new StringBuilder();
        for (String s : strArr) {
            output.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append(" ");
        }
        System.out.println(output.toString().trim());
    }

    private static void printCharsOccurences() {
        String input = "aabbbccccddddd";
        char[] chArr = input.toCharArray();
        Map<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (char ch : chArr) {
            linkedHashMap.put(ch, linkedHashMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder output = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : linkedHashMap.entrySet()) {
            output.append(entry.getKey()).append(entry.getValue());
        }
        System.out.println(output.toString());
    }

    private static void reverseSubsetArray() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        int start = 0;
        //check size
        for (int i = 0; i < input.length; i += k) {
            int left = i;
            // Calculate the right index for the current subset
            int right = Math.min(i + k - 1, input.length - 1);
            while (left < right) {
                int temp = input[left];
                input[left] = input[right];
                input[right] = temp;
                left++;
                right--;
            }
        }

        Arrays.stream(input).forEach(System.out::print);
    }

    private static void reverseAlternateWords() {
        var input = "selenium cypress playwright webdriverio";
        var inputArr = input.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < inputArr.length; i++) {
            if (i % 2 == 0) {
                output.append(inputArr[i]).append(" ");
            } else {
                StringBuilder temp = new StringBuilder(inputArr[i]);
                output.append(temp.reverse()).append(" ");
            }
        }
        System.out.println(output.toString().trim());
    }

    private static void moveOddToFrontEvenToEnd() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        int start = 0;
        int end = input.length - 1;
        int[] result = new int[input.length];
        var oddList = new ArrayList<Integer>();
        var evenList = new ArrayList<Integer>();
        for (int ch : input) {
            if (ch % 2 == 0) {
                //result[end] = ch;
                evenList.add(ch);
                //end--;
            } else {
                oddList.add(ch);
                //result[start] = ch;
                //start++;
            }
        }
        for (Integer ch : oddList) {
            result[start] = ch;
            start++;
        }
        for (Integer ch : evenList) {
            result[start] = ch;
            start++;
        }


        Arrays.stream(result).forEach(System.out::print);
    }

    private static void moveAllZerosToEnd() {
        int[] inputArray = {1, 0, 7, 0, 4, 0, 5, 0};
        int index = inputArray.length - 1;
        for (int i = inputArray.length - 1; i >= 0; i--) {
            if (inputArray[i] != 0) {
                inputArray[index] = inputArray[i];
                index--;
            }
        }
        while (index >= 0) {
            inputArray[index] = 0;
            index--;
        }

        Arrays.stream(inputArray).forEach(System.out::print);
    }
}
