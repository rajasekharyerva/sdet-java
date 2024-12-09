package sdet.numbers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class TypeCast {
    public static void main(String[] args) {
        typeCast();
        arrayStream();
        arrayListStream();
        wapToPrintPrimeNumber(50, 100);
        sqlConnection();


    }

    private static void sqlConnection() {
        // Database URL, username, and password
        String URL = "jdbc:mysql://";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "root_password");
            String sql = "SELECT COUNT(*) AS employee_count FROM employeeV2";
            ResultSet rs = connection.prepareStatement(sql).executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(""));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void wapToPrintPrimeNumber(int low, int high) {
        for(int i=low; i<=high; i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }

    private static boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    private static void arrayListStream() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.stream().filter(i -> i%2==0).forEach(System.out::println);
    }

    private static void arrayStream() {
        int[] intArray = {1,2,3,4,5};
        Arrays.stream(intArray).filter(i -> i%2==0).forEach(System.out::println);
    }

    private static void typeCast(){
        int x= 10;
        long y = x;
        System.out.println(y);
        double a = 9.9;
        int b = (int) a;
        System.out.println(b);
    }
}
