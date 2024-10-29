package sdet;

public class OuterClass {

    // Static nested class
    public static class StaticNestedClass {
        public static void main(String[] args) {
            System.out.println("Inside Static Nested Class Main Method");
        }

        public void display() {
            System.out.println("Static Nested Class Display Method");
        }
    }

    // Non-static inner class
    public class InnerClass {
        public void display() {
            System.out.println("Inner Class Display Method");
        }

        /*public static void main(String[] args) {
            System.out.println("Inside Inner Class Main Method");
            OuterClass outer = new OuterClass();
            InnerClass inner = outer.new InnerClass();
            inner.display();
        }*/
    }

    public static void main(String[] args) {
        System.out.println("Inside Outer Class Main Method");

        // Access static nested class
        StaticNestedClass staticNested = new StaticNestedClass();
        staticNested.display();

        // Access non-static inner class
        OuterClass outer = new OuterClass();
        InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}
