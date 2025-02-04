package sdet.oops;

public abstract class Animal {
    // Abstract method (implicitly public and abstract)
    void performAction() {
    }

    abstract void sound();

    // Default method (with implementation, optional for implementing classes to override)
    void defaultMethod() {
        System.out.println("This is a default method in an interface.");
    }

    // Static method (can be called on the interface directly)
    static void staticMethod() {
        System.out.println("This is a static method in an interface.");
    }
}
