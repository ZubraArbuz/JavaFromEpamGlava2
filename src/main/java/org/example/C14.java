package org.example;

import java.util.Random;
import java.util.Scanner;

public class C14 {
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

        // Нахождение седловых точек
        int saddlePointCount = countSaddlePoints(matrix);
        System.out.println("Количество седловых точек: " + saddlePointCount);
    }
    //Элемент матрицы A[i][j] является седловой точкой, если он является минимальным элементом в своей строке и максимальным элементом в своем столбце.
    private static int countSaddlePoints(int[][] matrix) {
        int count = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currentElement = matrix[i][j];
                boolean isMinInRow = true;
                for (int k = 0; k < n; k++) {
                    if (matrix[i][k] < currentElement) {
                        isMinInRow = false;
                        break;
                    }
                }

                boolean isMaxInColumn = true;
                for (int k = 0; k < n; k++) {
                    if (matrix[k][j] > currentElement) {
                        isMaxInColumn = false;
                        break;
                    }
                }
                if (isMinInRow && isMaxInColumn) {
                    count++;
                }
            }
        }

        return count;
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
