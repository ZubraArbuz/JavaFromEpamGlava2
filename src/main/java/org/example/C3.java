package org.example;

import java.util.Random;
import java.util.Scanner;

public class C3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы n: ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        // Нахождение максимального количества подряд идущих возрастающих и убывающих элементов
        int maxIncreasing = findMaxSequence(matrix, true);
        int maxDecreasing = findMaxSequence(matrix, false);

        System.out.println("Наибольшее количество возрастающих элементов подряд: " + maxIncreasing);
        System.out.println("Наибольшее количество убывающих элементов подряд: " + maxDecreasing);
    }

    // Метод для нахождения максимальной последовательности в заданном направлении
    private static int findMaxSequence(int[][] matrix, boolean increasing) {
        int n = matrix.length;
        int maxLength = 0;

        // Проверка всех направлений (вправо, вниз, вправо-вниз, влево-вниз)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, countSequence(matrix, i, j, 1, 0, increasing)); // Вправо
                maxLength = Math.max(maxLength, countSequence(matrix, i, j, 0, 1, increasing)); // Вниз
                maxLength = Math.max(maxLength, countSequence(matrix, i, j, 1, 1, increasing)); // Вправо-вниз (диагональ)
                maxLength = Math.max(maxLength, countSequence(matrix, i, j, 1, -1, increasing)); // Влево-вниз (диагональ)
            }
        }

        return maxLength;
    }

    // Подсчет длины последовательности для одного направления
    private static int countSequence(int[][] matrix, int row, int col, int rowDir, int colDir, boolean increasing) {
        int n = matrix.length;
        int length = 1;

        while (row + rowDir >= 0 && row + rowDir < n && col + colDir >= 0 && col + colDir < n) {
            if ((increasing && matrix[row + rowDir][col + colDir] > matrix[row][col]) || (!increasing && matrix[row + rowDir][col + colDir] < matrix[row][col])) {
                length++;
                row += rowDir;
                col += colDir;
            } else {
                break;
            }
        }

        return length;
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
