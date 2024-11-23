package sdet.java.java11;

import io.gatling.recorder.internal.bouncycastle.jcajce.provider.keystore.BC;

public class Record {
    public record Point(int x, int y) {}
        public static void main(String[] args) {
            Point point = new Point(3, 5);
            System.out.println(point.x()); // Accessor methods
            System.out.println(point);    // Automatically generated toString()
            BC bc=new BC();
            int day = 3;
            String dayType = switch (day) {
                case 1, 2, 3, 4, 5 -> "Weekday";
                case 6, 7 -> "Weekend";
                default -> "Invalid";
            };
            System.out.println(dayType);
        }

}
