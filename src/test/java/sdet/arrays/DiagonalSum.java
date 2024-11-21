package sdet.arrays;

public class DiagonalSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Diagonal Sum: " + getDiagonalSum(matrix));
    }

    public static int getDiagonalSum(int[][] matrix) {
        int n = matrix.length; // Assuming it's a square matrix (n x n)
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i]; // Adding primary diagonal element
            sum += matrix[i][n - 1 - i]; // Adding secondary diagonal element
        }

        // If n is odd, the center element gets added twice, so subtract it once
        if (n % 2 != 0) {
            sum -= matrix[n / 2][n / 2];
        }

        return sum;
    }
}

