package arrays;

public class Fact {
    public static void main(String[] args) {
        int x = 5;
        System.out.println(fact(5));
    }

    private static int fact(int i) {
        if (i == 1) {
            return 1;
        }
        return i * fact(i - 1);
    }
}
