package sdet;

public class CommandLineArgsExample {
    public static void main(String[] args) {
        // Check if any arguments were passed
        if (args.length > 0) {
            System.out.println("Arguments passed:");
            // Loop through each argument
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("No arguments passed.");
        }
    }
}

