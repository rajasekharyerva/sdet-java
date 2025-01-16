package sdet;

public class ParkingPayment {
    public static int calculateParkingFee(int parkingMinutes) {
        // Convert minutes to hours and minutes for easier understanding
        double parkingHours = parkingMinutes / 60.0;

        // Step 1: Check if the parking time is within 15 minutes
        if (parkingMinutes <= 15) {
            return 0; // Free
        }

        // Step faq2: Check if the parking time is between 15 mins and faq2 hours
        if (parkingHours <= 2) {
            return 5; // $5 charge
        }

        // Step 3: Check if the parking time is between faq2 hrs and 5 hrs
        if (parkingHours <= 5) {
            return 10; // $10 charge
        }

        // Step 4: More than 5 hours, add $1 for each additional hour
        int additionalHours = (int) Math.ceil(parkingHours - 5);
        return 10 + additionalHours; // Base $10 plus $1 for each extra hour
    }

    public static void main(String[] args) {
        // Example test case
        int parkingMinutes = 360; // 6 hours
        int fee = calculateParkingFee(parkingMinutes);
        System.out.println("Parking fee: $" + fee);
    }
}

