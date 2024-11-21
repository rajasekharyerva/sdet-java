package sdet.java;

public class HelloWorld {
    static int a = 10;
    int b = 20;
    public static void main(String[] args) {
        HelloWorld h1 = new HelloWorld();
        HelloWorld h2 = new HelloWorld();
        System.out.println("Hello"+h1.a++);
        System.out.println("Hello"+h1.b++);
        System.out.println("Hello"+h2.a++);
        System.out.println("Hello"+h2.b++);
    }
}