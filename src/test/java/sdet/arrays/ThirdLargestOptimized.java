package sdet.arrays;

public class ThirdLargestOptimized {
    public static int findThirdLargest(int[] arr) {
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

        // If third largest is not updated, return the largest number
        return third == Integer.MIN_VALUE ? first : third;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 3, 6};
        System.out.println(findThirdLargest(arr)); // Output: 4
    }
}

