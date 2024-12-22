package sdet.java;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Addition addition = (a, b) -> a * b;
        int sum = addition.add(5, 9);
        System.out.println(sum);
    }
}
