package sdet.numbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberFinder {

    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        // Edge cases for numbers less than faq2
        if (num <= 1) {
            return false;
        }

        // Check if the number is divisible by any number from faq2 to sqrt(num)
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;  // Not a prime number
            }
        }

        return true;  // Prime number
    }

    // Function to find prime numbers in a list
    public static List<Integer> findPrimes(List<Integer> numbers) {
        List<Integer> primeNumbers = new ArrayList<>();

        // Loop through each number and check if it's prime
        for (int num : numbers) {
            if (isPrime(num)) {
                primeNumbers.add(num);
            }
        }

        return primeNumbers;
    }

    public static void main(String[] args) {
        // Sample list of numbers
        List<Integer> numbers = List.of(10, 15, 23, 28, 29, 33, 37, 40, 43);

        // Get the list of prime numbers
        List<Integer> primes = findPrimes(numbers);

        // Print the prime numbers
        System.out.println("Prime numbers in the list: " + primes);
    }
}

