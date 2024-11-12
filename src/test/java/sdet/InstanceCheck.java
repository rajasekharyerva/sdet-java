package sdet;

import sdet.oops.Singleton;

public class InstanceCheck {
    public static void main(String[] args) {
        System.out.println(new ClassB().toString());
        System.out.println(Singleton.getInstance());
        System.out.println(new ClassB().toString());
        System.out.println(Singleton.getInstance());
        System.out.println(new ClassB().toString());
        System.out.println(Singleton.getInstance());
        System.out.println(new ClassB().toString());
        System.out.println(Singleton.getInstance());
    }
}
