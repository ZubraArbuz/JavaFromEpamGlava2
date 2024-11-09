package org.example;

import java.util.Random;
import java.util.Scanner;

public class C10 {
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

        int[][] resultMatrix = removeMaxElement(matrix);
        System.out.println("Матрица после удаления строк и столбцов с максимальным элементом:");
        printMatrix(resultMatrix);
    }

    private static int[][] removeMaxElement(int[][] matrix) {
        int n = matrix.length;
        int maxElement = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        int newRows = n - 1;
        int newCols = n - 1;
        int[][] result = new int[newRows][newCols];

        for (int i = 0, newRow = 0; i < n; i++) {
            if (i == maxRow) continue;
            for (int j = 0, newCol = 0; j < n; j++) {
                if (j == maxCol) continue;
                result[newRow][newCol++] = matrix[i][j];
            }
            newRow++;
        }

        return result;
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
