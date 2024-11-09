package org.example;

import java.util.Random;
import java.util.Scanner;

public class C8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы n: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(21) - 10;
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        int determinant = calculateDeterminant(matrix);
        System.out.println("Определитель матрицы: " + determinant);
    }

    private static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;
        for (int j = 0; j < n; j++) {
            determinant += Math.pow(-1, j) * matrix[0][j] * calculateDeterminant(getMinor(matrix, 0, j));
        }

        return determinant;
    }

    private static int[][] getMinor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];

        for (int i = 0, minorRow = 0; i < n; i++) {
            if (i == row) continue; // пропускаем строку
            for (int j = 0, minorCol = 0; j < n; j++) {
                if (j == col) continue; // пропускаем столбец
                minor[minorRow][minorCol++] = matrix[i][j];
            }
            minorRow++;
        }

        return minor;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
