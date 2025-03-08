package programs;

public class PalindromeCheck {
    public static void main(String[] args) {
        String input = "sfffs";
        StringBuilder inputStringBuilder = new StringBuilder(input);
        System.out.println(input.contentEquals(inputStringBuilder.reverse()));
    }
}
