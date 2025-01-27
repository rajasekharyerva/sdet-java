package abstraction;

public class MainSample {
    public static void main(String[] args) {
        Sample sample = new Sample() {
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }
}
