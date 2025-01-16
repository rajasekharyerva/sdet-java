package sdet;

public class MainMethodOverload {

    // Standard main method (entry point)
    public static void main(String[] args) {
        System.out.println("Main method with String[] args");
        // Calling overloaded main methods
        main(10);  // Calls the overloaded main method with an int parameter
        main(10, 20);  // Calls the overloaded main method with two int parameters
    }

    // Overloaded main method with an integer parameter
    public static void main(int a) {
        System.out.println("Overloaded main method with int: " + a);
    }

    // Overloaded main method with two integer parameters
    public static void main(int a, int b) {
        System.out.println("Overloaded main method with two ints: " + a + ", " + b);
    }
}


