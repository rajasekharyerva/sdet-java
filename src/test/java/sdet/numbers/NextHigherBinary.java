package sdet.numbers;

public class NextHigherBinary {
    public static void main(String[] args) {
        int input = 3; // Example input
        int result = findNextHigherWithSameOnes(input);
        System.out.println("Input: " + input + " (" + Integer.toBinaryString(input) + ")");
        System.out.println("Output: " + result + " (" + Integer.toBinaryString(result) + ")");
    }

    private static int findNextHigherWithSameOnes(int num) {
        int countOnes = Integer.bitCount(num); // Count the number of 1's in binary representation

        while (true) {
            num++;
            if (Integer.bitCount(num) == countOnes) {
                return num; // Return the number if it has the same count of 1's
            }
        }
    }
}
