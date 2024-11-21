package sdet.java;

import java.util.regex.Pattern;

public class EmailValidator {
    // Define regex for email validation
    private static final String EMAIL_REGEX = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        // Check for null or empty string
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Use the regex pattern to match the email
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static void main(String[] args) {
        // Test emails
        String[] testEmails = {
                "example@domain.com",        // valid
                "user.name@domain.co.in",    // valid
                "user@domain",               // invalid, no TLD
                "user@domain.c",             // valid (if considering single-character TLDs)
                "user@.domain.com",          // invalid, starts with dot in domain
                "user@domain..com",          // invalid, double dot in domain
                "user@domain.corporate",     // valid (if corporate TLDs allowed)
                "user@domain!.com",          // invalid, special character in domain
                "user@domain.c0m",           // invalid, number in TLD
                "user@domain@example.com",   // invalid, multiple @ signs
                "",                          // invalid, empty string
                null                         // invalid, null value
        };

        for (String email : testEmails) {
            System.out.printf("Email: %s - Valid: %b%n", email, isValidEmail(email));
        }
    }
}

