package selenium.tests;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String randomPhoneNumber = faker.phoneNumber().cellPhone().replace("-", "");
        System.out.println("Random Phone Number: " + randomPhoneNumber);
    }
}

