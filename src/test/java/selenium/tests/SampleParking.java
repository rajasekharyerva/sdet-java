package selenium.tests;

import java.util.Scanner;

public class SampleParking {

    public static void main(String[] args) {
        int a = 0;
        int b = a;
        b = a++;
        System.out.println(a + "-" + b);
        Scanner sc = new Scanner(System.in);
        int minutes = sc.nextInt();
        double hours = minutes / 60.0;
        int mins = minutes % 60;

        /*0-15 mins: $0
        15 mins to faq2 hrs: $5
        faq2-5 hrs: $10
        More than 5 hrs: Add $1 for each additional full hour.*/

        if (minutes <= 15) {
            System.out.println("free");
        } else if (hours <= 2) {
            System.out.println("$5");
        } else if (hours <= 5) {
            System.out.println("$10");
        } else if (hours > 5) {
            System.out.println(Math.ceil(hours) - 5 + 10);
        }


    }
}
