package arrays;

public class ThirdLargestElementOptimized {

    public static int findThirdLargest(int[] arr) {
        if (arr.length < 3) {
            throw new IllegalArgumentException("Array must have at least 3 elements.");
        }

        // Initialize the top 3 largest elements
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }

        return third;
    }

    public static void main(String[] args) {
        int[] arr = {12, 45, 2, 10, 34, 50};
        int thirdLargest = findThirdLargest(arr);
        System.out.println("The 3rd largest element is: " + thirdLargest);
    }
}
