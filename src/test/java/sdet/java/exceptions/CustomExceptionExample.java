package sdet.java.exceptions;

// Custom checked exception class
class InvalidAgeException extends Exception {
    // Constructor to pass a custom error message
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {

    // Method that throws a custom exception
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is less than 18. Invalid age!");
        } else {
            System.out.println("Age is valid.");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15);  // This will throw InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());  // Handle the exception and print the message
        }
    }
}

