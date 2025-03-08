package programs;

public class LargestSmallest {
    public static void main(String[] args) {
        int[] inputArray = {2, 38, 9, 21, 9, 34};
        int largest = inputArray[0];
        int smallest = inputArray[0];
        for (int element : inputArray) {
            if (element > largest)
                largest = element;
            if (element < smallest)
                smallest = element;
        }
        System.out.println("Smallest: " + smallest);
        System.out.println("Smallest: " + largest);
    }
}
