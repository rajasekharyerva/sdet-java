package sdet.date;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtilExample {
    public static void main(String[] args) {
        // Get the current date and time
        Date currentDate = new Date();
        System.out.println(currentDate.getTime());
        // Define the format
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Format the date
        String formattedDate = formatter.format(currentDate);

        // Print the formatted date and time
        System.out.println("Current Date and Time: " + formattedDate);
    }
}

