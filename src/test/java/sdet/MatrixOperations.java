package sdet;

import java.util.Scanner;

public class MatrixOperations {

    // Method for matrix addition
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    // Method for matrix multiplication
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        // Check if multiplication is possible
        if (cols1 != rows2) {
            System.out.println("Matrix multiplication is not possible. The number of columns in the first matrix must equal the number of rows in the second matrix.");
            return null;
        }

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    // Method for matrix transpose
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input matrix 1
        System.out.println("Enter number of rows and columns for matrix 1:");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();

        int[][] matrix1 = new int[rows1][cols1];
        System.out.println("Enter elements of matrix 1:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Input matrix 2
        System.out.println("Enter number of rows and columns for matrix 2:");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();

        int[][] matrix2 = new int[rows2][cols2];
        System.out.println("Enter elements of matrix 2:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Perform addition if matrices are of the same size
        if (rows1 == rows2 && cols1 == cols2) {
            int[][] additionResult = addMatrices(matrix1, matrix2);
            System.out.println("Matrix Addition Result:");
            printMatrix(additionResult);
        } else {
            System.out.println("Matrix addition is not possible. Matrices must have the same dimensions.");
        }

        // Perform multiplication if columns of matrix1 == rows of matrix2
        if (cols1 == rows2) {
            int[][] multiplicationResult = multiplyMatrices(matrix1, matrix2);
            System.out.println("Matrix Multiplication Result:");
            printMatrix(multiplicationResult);
        }

        // Perform transpose on both matrices
        int[][] transposeMatrix1 = transposeMatrix(matrix1);
        System.out.println("Transpose of Matrix 1:");
        printMatrix(transposeMatrix1);

        int[][] transposeMatrix2 = transposeMatrix(matrix2);
        System.out.println("Transpose of Matrix 2:");
        printMatrix(transposeMatrix2);

        scanner.close();
    }
}

