package az;

public class PalindromeCheck {
    public static void main(String[] args) {
        String input = "sfffs";
        StringBuilder inputStringBuilder = new StringBuilder(input);
        System.out.println(input.equals(inputStringBuilder.reverse().toString()));
    }
}
