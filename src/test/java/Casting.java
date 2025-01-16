class Parent {
    void display() {
        System.out.println("Child");
    }
}

class Child extends Parent {
    void display() {
        System.out.println("Child");
    }
}

public class Casting {
    public static void main(String[] args) {
        //Child c = (Child) new Parent();
        //c.display();
    }
}
