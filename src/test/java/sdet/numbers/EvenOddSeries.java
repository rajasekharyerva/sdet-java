package sdet.numbers;

import java.util.Scanner;

public class EvenOddSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter the starting number: ");
        int startNumber = scanner.nextInt();
        System.out.print("Enter the count of numbers for each series: ");
        int count = scanner.nextInt();

        // Print the even numbers series including the starting number if it's even
        System.out.println("\nEven numbers series:");
        int evenCount = 0;
        int currentEven = startNumber;

        while (evenCount < count) {
            if (currentEven % 2 == 0) {
                System.out.print(currentEven + " ");
                evenCount++;
            }
            //System.out.println(currentEven);
            currentEven++;
        }

        // Print the odd numbers series including the starting number if it's odd
        System.out.println("\n\nOdd numbers series:");
        int oddCount = 0;
        int currentOdd = startNumber;

        while (oddCount < count) {
            if (currentOdd % 2 != 0) { // Ensure we are counting only odd numbers
                System.out.print(currentOdd + " ");
                oddCount++;
            }
            //System.out.println(currentOdd);
            currentOdd++;
        }

        // Close the scanner
        scanner.close();
    }
}
