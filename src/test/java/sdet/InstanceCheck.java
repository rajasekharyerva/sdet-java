package sdet;

public class InstanceCheck {
    public static void main(String[] args) {
        System.out.println(new ClassB().toString());
        System.out.println(ClassA.getInstance());
        System.out.println(new ClassB().toString());
        System.out.println(ClassA.getInstance());
        System.out.println(new ClassB().toString());
        System.out.println(ClassA.getInstance());
        System.out.println(new ClassB().toString());
        System.out.println(ClassA.getInstance());
    }
}
