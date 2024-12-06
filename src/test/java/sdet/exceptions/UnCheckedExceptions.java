package sdet.exceptions;

public class UnCheckedExceptions {
    //NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException
    public static void main(String[] args) {
        String str = null; // Initialize with null

        try {
            // Attempt to call a method on a null object reference
            System.out.println(str.length()); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: Cannot invoke method on null object");
        }

        int[] numbers = {1, 2, 3}; // Array with 3 elements

        try {
            // Attempt to access an invalid index
            System.out.println(numbers[5]); // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: Invalid index access");
        }

        int a = 10;
        int b = 0; // Dividing by zero

        try {
            // Attempt to divide by zero
            int result = a / b; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Cannot divide by zero");
        }

    }

}
