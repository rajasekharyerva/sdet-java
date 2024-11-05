package sdet.numbers;

public class LargestAndSmallest {
    public static void findLargestAndSmallest(int[] nums) {
        // Check for an empty array or an array with less than 2 elements
        if (nums.length == 0) {
            System.out.println("Array is empty.");
            return;
        }
        if (nums.length == 1) {
            System.out.println("Array has only one element: " + nums[0]);
            return;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        //System.out.println(secondSmallest);
        //System.out.println(secondLargest);

        for (int num : nums) {
            // Finding the largest and second largest
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }

            // Finding the smallest and second smallest
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num > smallest) {
                secondSmallest = num;
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
        System.out.println("Smallest: " + smallest);
        System.out.println("Second Smallest: " + secondSmallest);
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 8, 7, 2, 4};
        findLargestAndSmallest(nums);
    }
}

