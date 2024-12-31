package sdet.java.java8.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyPractice {

    public static void main(String[] args) {
        //streams();
        //replaceStringAll();
        //primeCheck();
        //missingElements();
        //targetSum();
        //System.out.println(containsDuplicate());
        //System.out.println(buySellStock());
        //anagram();
        //System.out.println(validParentheses());
        //contiguousMaxSumK(3);
        //productArrayExceptSelf();
        //deleteLastOccurence();
        //separateOddAndEvenNumber();
        //removeDuplicates();
        //findFrequencyOfCharacters();
        //findFrequencyOfElementsInArray();
        //reverseDecimalsList();
        //stringJoins();
        //printMultiplesOf5();
        //maxOrMin();
        mergeUnsortedArrays();

    }

    private static void mergeUnsortedArrays() {
        int[] a = new int[]{4, 2, 7, 1};
        int[] b = new int[]{8, 3, 9, 5};
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
        System.out.println(Arrays.toString(c));
    }

    private static void maxOrMin() {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        var max = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
        var min = listOfIntegers.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

    private static void printMultiplesOf5() {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        String output = listOfIntegers.stream().filter(n -> n % 5 == 0).map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(output);
    }

    private static void stringJoins() {
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        var output = listOfStrings.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(output);
    }

    private static void reverseDecimalsList() {
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        //decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        String result = decimalList.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static void findFrequencyOfElementsInArray() {
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> stationeryCountMap = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(stationeryCountMap);
    }

    private static void findFrequencyOfCharacters() {
        String inputString = "Java Concept Of The Day";
        Map<Character, Long> charCountMap = inputString.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCountMap);
    }

    private static void removeDuplicates() {
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<String> listWithOutDuplicates = listOfStrings.stream().distinct().collect(Collectors.toList());

    }

    private static void separateOddAndEvenNumber() {
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 2, 4, 2, 5));
        Map<Boolean, List<Integer>> oddEvenNumbersMap = listOfIntegers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        for (Map.Entry<Boolean, List<Integer>> entry : oddEvenNumbersMap.entrySet()) {
            if (entry.getKey())
                System.out.println("Even numbers");
            else
                System.out.println("Odd numbers");

            List<Integer> list = entry.getValue();
            list.stream().forEach(System.out::print);
            System.out.println();
        }
    }

    private static void deleteLastOccurence() {
        int[] arr = {1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 2, 4, 2, 5};
        int num = 2;
        int[] result = new int[arr.length - 1];
        int counter = arr.length - 2;
        boolean firstOccurance = true;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == num && firstOccurance) {
                firstOccurance = false;
                continue;
            }
            result[counter] = arr[i];
            counter--;
        }

        Arrays.stream(result).forEach(System.out::print);
    }

    private static void productArrayExceptSelf() {
        int[] integerArray = {2, 1, 3, 8, 6, 2};
        int[] result = new int[integerArray.length];
        result[0] = 1;
        for (int i = 1; i < integerArray.length; i++) {
            result[i] = result[i - 1] * integerArray[i - 1];
        }
        int suffix = 1;
        for (int j = integerArray.length - 1; j >= 0; j--) {
            result[j] = result[j] * suffix;
            suffix = suffix * integerArray[j];
        }
        System.out.println(Arrays.toString(result));
    }

    private static void contiguousMaxSumK(int n) {
        int[] integerArray = {2, 21, 3, 8, 6, 20};
        int max_sum = 0;
        for (int i = 0; i < n; i++) {
            max_sum += integerArray[i];
        }
        int win_sum = max_sum;
        for (int i = n; i < integerArray.length; i++) {
            win_sum += integerArray[i] - integerArray[i - n];
            max_sum = Math.max(max_sum, win_sum);
        }

    }

    private static boolean validParentheses() {
        String input = "[()]{}{[()(])]()}";
        //String input2 = "[(])";
        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();
        for (char ch : charArray) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char temp = stack.pop();
                    if (!isPair(ch, temp)) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isPair(char current, char check) {
        return (check == '{' && current == '}') || (check == '[' && current == ']') || (check == '(' && current == ')');
    }

    private static void anagram() {
        String str1 = "shsjalj";
        String str2 = "jjlsash";
        if (str1.length() != str2.length()) System.out.println("Not anagram strings");
        char[] charArray = str1.toCharArray();
        Arrays.sort(charArray);
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray2);
        System.out.println(Arrays.equals(charArray, charArray2));
    }

    private static int buySellStock() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            else
                maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    private static boolean containsDuplicate() {
        int[] arr = {1, 2, 3, 4, 5, 8, 9};
        Set<Integer> integerSet = new HashSet<>();

        for (int num : arr) {
            if (!integerSet.add(num))
                return true;
        }
        return false;
    }

    private static void targetSum() {
        int[] nums = {2, 7, 11, 15};
        int sum = 10;
        Set<Integer> pairSet = new HashSet<>();
        for (int num : nums) {
            int pair2 = sum - num; // pair 2 -
            if (!pairSet.contains(num))
                pairSet.add(pair2);
            else if (pairSet.contains(num)) {
                System.out.println("Pair: " + num + ", " + pair2);
            }
        }
        System.out.println("----");
    }

    private static void missingElements() {
        int[] arr = {1, 2, 3, 4, 7, 8, 10};
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            if (!set.contains(num))
                set.add(num);
        }
        for (int i = arr[0]; i <= arr[arr.length - 1]; i++) {
            if (!set.contains(i))
                System.out.print(i + " ");
        }

    }

    private static void primeCheck() {
        int input = 4;
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println(input + " is prime number? " + isPrime);
    }

    private static void replaceStringAll() {
        String input = "go to noo";
        System.out.println(input.replaceAll("o", "\\$"));
    }

    private static void streams() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("Rajasekhar", "Hethika", "Neethika", "Vishnupriya"));
        arrayList.stream().filter(name -> name.startsWith("N")).forEach(System.out::print);
    }
}
