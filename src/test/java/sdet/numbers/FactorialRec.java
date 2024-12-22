package sdet.numbers;

public class FactorialRec {
    public static void main(String[] args) {
        int input = 5;
        int factorial = recursiveFact(5);
        System.out.println(factorial);
    }

    private static int recursiveFact(int i) {
        if (i == 1) {
            return 1;
        }
        return i * recursiveFact(i - 1);
    }
}
