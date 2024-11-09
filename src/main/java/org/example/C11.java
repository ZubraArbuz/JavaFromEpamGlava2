package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class C11 {
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

        // Уплотнение матрицы
        int[][] compactedMatrix = compactMatrix(matrix);
        System.out.println("Матрица после уплотнения:");
        printMatrix(compactedMatrix);
    }

    // Метод для уплотнения матрицы
    private static int[][] compactMatrix(int[][] matrix) {
        int n = matrix.length;

        // Находим строки, заполненные нулями
        List<Integer> zeroRows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean isZeroRow = true;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    isZeroRow = false;
                    break;
                }
            }
            if (isZeroRow) {
                zeroRows.add(i);
            }
        }

        List<Integer> zeroCols = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            boolean isZeroCol = true;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] != 0) {
                    isZeroCol = false;
                    break;
                }
            }
            if (isZeroCol) {
                zeroCols.add(j);
            }
        }

        int newRows = n - zeroRows.size();
        int newCols = n - zeroCols.size();
        int[][] result = new int[newRows][newCols];

        for (int newRow = 0, oldRow = 0; oldRow < n; oldRow++) {
            if (zeroRows.contains(oldRow)) continue; // Пропускаем нулевую строку
            for (int newCol = 0, oldCol = 0; oldCol < n; oldCol++) {
                if (zeroCols.contains(oldCol)) continue; // Пропускаем нулевой столбец
                result[newRow][newCol++] = matrix[oldRow][oldCol];
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
