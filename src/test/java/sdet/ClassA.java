package sdet;

public class ClassA {

    private static ClassA instance;

    private ClassA(){

    }

    public static ClassA getInstance(){
        if(instance == null){
            instance = new ClassA();
        }
        return instance;
    }
}
