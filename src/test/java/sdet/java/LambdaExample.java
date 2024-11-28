package sdet.java;

public class LambdaExample {

    public static void main(String[] args) {
        // Using a lambda expression to implement the Calculator interface
        Calculator add = (a, b) -> a + b;   // Adds two numbers
        Calculator subtract = (a, b) -> a - b;  // Subtracts second number from the first
        Calculator multiply = (a, b) -> a * b;  // Multiplies two numbers
        Calculator divide = (a, b) -> a / b;    // Divides first number by the second

        // Using the lambda expressions to perform operations
        System.out.println("Addition: " + performOperation(add, 5, 3));
        System.out.println("Subtraction: " + performOperation(subtract, 5, 3));
        System.out.println("Multiplication: " + performOperation(multiply, 5, 3));
        System.out.println("Division: " + performOperation(divide, 6, 3));
    }

    // Method that takes a Calculator implementation and two integers
    public static int performOperation(Calculator calculator, int a, int b) {
        return calculator.calculate(a, b);
    }
}

