package collections.arrays;

public class MagicSquare {

    public static void main(String[] args) {
        // 3x3 Magic Square
        int[][] magicSquare = new int[3][3];

        // Filling the magic square with predefined values for 3x3
        int[] numbers = {2, 7, 6, 9, 5, 1, 4, 3, 8}; // Predefined solution to a 3x3 magic square
        int index = 0;

        // Loop to fill the magic square with numbers
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                magicSquare[i][j] = numbers[index++];
            }
        }

        // Display the magic square
        System.out.println("3x3 Magic Square:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(magicSquare[i][j] + "\t");
            }
            System.out.println();
        }

        // Validate the sum of rows, columns, and diagonals
        validateMagicSquare(magicSquare);
    }

    public static void validateMagicSquare(int[][] square) {
        int targetSum = 15; // Magic sum for a 3x3 magic square

        // Check sum of each row
        for (int i = 0; i < 3; i++) {
            int rowSum = 0;
            for (int j = 0; j < 3; j++) {
                rowSum += square[i][j];
            }
            if (rowSum != targetSum) {
                System.out.println("Row " + (i + 1) + " sum is not " + targetSum);
            }
        }

        // Check sum of each column
        for (int i = 0; i < 3; i++) {
            int colSum = 0;
            for (int j = 0; j < 3; j++) {
                colSum += square[j][i];
            }
            if (colSum != targetSum) {
                System.out.println("Column " + (i + 1) + " sum is not " + targetSum);
            }
        }

        // Check sum of diagonals
        int diag1Sum = 0, diag2Sum = 0;
        for (int i = 0; i < 3; i++) {
            diag1Sum += square[i][i]; // Primary diagonal
            diag2Sum += square[i][2 - i]; // Secondary diagonal
        }

        if (diag1Sum != targetSum) {
            System.out.println("Primary diagonal sum is not " + targetSum);
        }
        if (diag2Sum != targetSum) {
            System.out.println("Secondary diagonal sum is not " + targetSum);
        }

        System.out.println("Magic Square is valid!");
    }
}

