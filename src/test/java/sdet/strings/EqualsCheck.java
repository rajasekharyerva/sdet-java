package sdet.strings;

public class EqualsCheck {
    public static void main(String[] args) {
        //== checks memory address for Objects, values for primitives
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        String s3 = s2;
        System.out.println(s1 == s2);
        System.out.println(s3 == s2);

    }
}
