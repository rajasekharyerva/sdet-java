package sdet.collections;

public class FindSecondLargestList {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 4, 4};
        if(numbers.length<2) {
            throw new IllegalArgumentException("Array length should >=2");
        }

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest  = Integer.MIN_VALUE;

        for(int number: numbers) {
            if(number >firstLargest ) {
                secondLargest =firstLargest;
                firstLargest = number;
            } else if(number > secondLargest  && number < firstLargest){
                secondLargest = number;
            }
        }

        System.out.println(firstLargest);
        System.out.println(secondLargest);

    }
}
