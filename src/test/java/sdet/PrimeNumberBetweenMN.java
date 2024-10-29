package sdet;

public class PrimeNumberBetweenMN {
    public static void main(String[] args) {
        int m = 2;
        int n = 7;
        for (int i = 3; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int i) {
        int sqrt = (int) Math.sqrt(i);
        for (int j = 2; j <= sqrt; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
