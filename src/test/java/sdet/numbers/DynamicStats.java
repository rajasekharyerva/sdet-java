package sdet.numbers;

import java.util.*;

public class DynamicStats {
    private List<Integer> numbers;
    private double mean;
    private double median;

    public DynamicStats() {
        numbers = new ArrayList<>();
        mean = 0;
        median = 0;
    }

    // Add a number
    public void addNumber(int num) {
        numbers.add(num);
        Collections.sort(numbers);
        calculateMean();
        calculateMedian();
    }

    // Remove a number
    public void removeNumber(int num) {
        if (numbers.contains(num)) {
            numbers.remove(Integer.valueOf(num));
            calculateMean();
            calculateMedian();
        } else {
            System.out.println("Number not found in the list.");
        }
    }

    // Calculate mean
    private void calculateMean() {
        if (numbers.isEmpty()) {
            mean = 0;
            return;
        }
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        mean = sum / numbers.size();
    }

    // Calculate median
    private void calculateMedian() {
        if (numbers.isEmpty()) {
            median = 0;
            return;
        }
        int size = numbers.size();
        if (size % 2 == 0) {
            median = (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2.0;
        } else {
            median = numbers.get(size / 2);
        }
    }

    // Getters for mean and median
    public double getMean() {
        return mean;
    }

    public double getMedian() {
        return median;
    }

    // Display the numbers
    public void displayNumbers() {
        System.out.println("Numbers: " + numbers);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DynamicStats stats = new DynamicStats();

        while (true) {
            System.out.println("Choose an operation: \n1. Add Number \n2. Remove Number \n3. Show Mean \n4. Show Median \n5. Show Numbers \n6. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter number to add:");
                    int numToAdd = scanner.nextInt();
                    stats.addNumber(numToAdd);
                    break;
                case 2:
                    System.out.println("Enter number to remove:");
                    int numToRemove = scanner.nextInt();
                    stats.removeNumber(numToRemove);
                    break;
                case 3:
                    System.out.println("Mean: " + stats.getMean());
                    break;
                case 4:
                    System.out.println("Median: " + stats.getMedian());
                    break;
                case 5:
                    stats.displayNumbers();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
