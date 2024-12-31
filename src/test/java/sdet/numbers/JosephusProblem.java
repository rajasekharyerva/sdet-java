package sdet.numbers;

public class JosephusProblem {
    public static int josephus(int n, int k) {
        // Base case: when only one person is left
        if (n == 1) {
            return 0; // Returning 0-based index
        }
        // Recursive case
        return (josephus(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        int n = 7; // Number of people
        int k = 3; // Step size
        int survivor = josephus(n, k) + 1; // Convert 0-based to 1-based index
        System.out.println("The survivor is at position: " + survivor);
    }
}

