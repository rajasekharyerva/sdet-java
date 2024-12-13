package sdet;

public class WithoutMain {
    static {
        System.out.println("Running without main method!");
        System.exit(0); // Prevents `main` check failure.
    }

    public static void main(String[] args) {
        // This will ensure that the static block still runs when the class is loaded
        System.out.println("Running without main method!");
    }

}
