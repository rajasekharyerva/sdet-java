package sdet;

public class SampleTest {
    public static void main(String[] args) {
        missingNumbers();

    }

    private static void missingNumbers() {
        int[] intArray = {1, 2, 4, 7, 9};
        int start = intArray[0];
        int end = intArray[intArray.length - 1];
        int index = 1;
        for (int i = start; i < end; i++) {
            if (intArray[index] == i) {
                index++;
            } else {
                System.out.println(i);
            }
        }
    }
}
