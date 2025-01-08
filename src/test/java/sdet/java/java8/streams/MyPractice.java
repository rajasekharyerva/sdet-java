package sdet.java.java8.streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
        //mergeUnsortedArrays();
        //maximum3Minimum3();
        //stringAnagram();
        //duplicateStrean();
        //countOddAndEvenNumbers();
        //maxAndMin();
        //missingInteger();
        //missingIntegers();
        //firstLastOccurrences();
        //firstRepeating();
        //removeDuplicatesArrayList();
        //secondLargestInArray();
        //sortArray();
        //removeWhiteSpaces();
        //printFirstLetterOfEachWordString();
        //longestSubstring();
        //diffWaysIterateList();
        //reverseStringPreserveSpace();
        //fibonacciSeries();
        // reverseStringWithoutReverse();
        //initializeArrayAndFindMissing();
        webDriverWait();

    }

    private static void webDriverWait() {
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));

    }

    // Generic method to wait for an element using any locator
    public static WebElement waitForElement(WebDriver driver, By locator, long timeoutInSeconds, long pollingIntervalInMillis) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))   // Set total timeout
                .pollingEvery(Duration.ofMillis(pollingIntervalInMillis)) // Set polling interval
                .ignoring(NoSuchElementException.class); // Ignore exceptions while waiting

        // Wait until the element is visible
        return wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(locator);
                    if (element != null && element.isDisplayed()) {
                        return element; // Return element if it is visible
                    }
                } catch (NoSuchElementException e) {
                    // Element not found, continue waiting
                }
                return null; // If element is not found or not visible, return null
            }
        });
    }

    private static void initializeArrayAndFindMissing() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(10, 9, 2, 1));//3 elements
        int start = arrayList.get(0);
        // int end = arrayList.get(arrayList.size() - 1);
        int index = 0;

        while (start >= 0) {
            if (start == arrayList.get(index)) {
                index++;
            } else {
                System.out.println(start);
            }
            start--;
        }
    }

    private static void reverseStringWithoutReverse() {
        String input = "Test in Progress";
        for (int i = input.length() - 1; i >= 0; i--) {
            System.out.print(input.charAt(i));
        }
    }

    private static void fibonacciSeries() {
        int first = 0;
        int second = 1;
        int n = 5;
        for (int i = 1; i <= 5; i++) { //0,1,1,2,3,5,8
            int fib = first + second;
            first = second;
            second = fib;
            System.out.println(fib);
        }
    }


    private static void reverseStringPreserveSpace() {
        var input = "aandkd djnd";
        int start = 0;
        int end = input.length() - 1;
        char[] chArray = input.toCharArray();
        while (start < end) {
            if (' ' == chArray[start]) {
                start++;
            } else if (' ' == chArray[end]) {
                end--;
            } else {
                char temp = chArray[start];
                chArray[start] = chArray[end];
                chArray[end] = temp;
                start++;
                end--;
            }
        }
        System.out.println(new String(chArray));
    }

    private static void diffWaysIterateList() {
        List<String> list = List.of("Apple", "ball", "cat", "dog");
        //1
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //2
        for (String item : list) {
            System.out.println(item);
        }

        //3
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //4
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        list.stream().forEach(System.out::print);
    }

    private static void longestSubstring() {
        String s = "abcabcxbb";
        int left = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, i - left + 1);
            set.add(s.charAt(i));

        }
        System.out.println(maxLength);
    }

    private static void printFirstLetterOfEachWordString() {
        String input = "This is a sample sentence";
        var words = input.split("\\s+");
        for (var word : words) {
            System.out.print(word.charAt(0) + " ");
        }

    }

    private static void removeWhiteSpaces() {
        String input = "jnaln  wfnfnvw wvvknvnv vw  ";
        System.out.println(input.replaceAll("\\s+", ""));

    }

    private static void sortArray() {
        int[] numbers = {6, 1, 3, 2, 4, 7, 8, 9};
        //Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static void secondLargestInArray() {
        int[] numbers = {1, 2, 3, 2, 4, 5, 2, 6};
        var largest = Integer.MIN_VALUE;
        var secondLargest = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }
            if (num > secondLargest && num < secondLargest) {
                secondLargest = num;
            }
        }
        System.out.println(secondLargest);
    }

    private static void removeDuplicatesArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple");
        list.add("Orange");
        list.add("Banana");
        list.add("Grapes");

        Set<String> list1 = new HashSet<>(list);
        ArrayList<String> list2 = new ArrayList<>(list1);
        System.out.println(list2.toString());
    }

    private static void firstRepeating() {
        int[] numbers = {1, 2, 3, 2, 4, 5, 2, 6}; // Example array
        Set<Integer> seen = new HashSet<>();
        int firstRepeating = -1;
        for (int num : numbers) {
            if (seen.contains(num)) {
                firstRepeating = num;
                break;
            }
            seen.add(num);
        }
        System.out.println("First repeating: " + firstRepeating);
    }

    private static void firstLastOccurrences() {
        int[] numbers = {1, 2, 3, 2, 4, 5, 2, 6}; // Example array
        int target = 2; // Element to find first and last occurrence
        int firstOccurrence = -1;
        int lastOccurrence = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                firstOccurrence = i;
                break;
            }
        }
        for (int j = numbers.length - 1; j >= 0; j--) {
            if (numbers[j] == target) {
                lastOccurrence = j;
                break;
            }
        }

        System.out.println("First Occurrence: " + firstOccurrence);
        System.out.println("Last Occurrence: " + lastOccurrence);
    }

    private static void missingIntegers() {
        int[] numbers = {1, 3, 4, 6, 8};
        Set<Integer> set = new HashSet<>();
        for (int num : numbers) {
            set.add(num);
        }
        for (int i = numbers[0]; i < numbers[numbers.length - 1]; i++) {
            if (!set.contains(i))
                System.out.println("Missing: " + i);
        }
    }

    private static void missingInteger() {
        int[] numbers = {1, 2, 4, 5, 6};
        int n = numbers.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : numbers) {
            actualSum += num;
        }
        int missingNum = expectedSum - actualSum;
        System.out.println("Missing number: " + missingNum);
    }

    private static void maxAndMin() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3, 5);
        int max = numbers.get(0);
        int min = numbers.get(0);
        for (int num : numbers) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    private static void countOddAndEvenNumbers() {
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 2, 4, 2, 5));
        var evenCounts = 0;
        var oddCounts = 0;
        for (int num : listOfIntegers) {
            if (num % 2 == 0) evenCounts++;
            else oddCounts++;
        }
        System.out.println("Counts Even: " + evenCounts + ", Odd: " + oddCounts);
    }

    private static void duplicateStrean() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3, 5);
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = numbers.stream()
                .filter(n -> !seen.add(n))  // add returns false if the element is already present
                .collect(Collectors.toList());
        System.out.println(duplicates);
    }

    private static void stringAnagram() {
        String s1 = "RaceCar";
        String s2 = "CarRace";
        String o1 = Arrays.stream(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining(""));
        String o2 = Arrays.stream(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining(""));
        System.out.println(o1);
        System.out.println(o2);
    }

    private static void maximum3Minimum3() {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        String output = listOfIntegers.stream().sorted().limit(3).map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(output);
        listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::print);
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
