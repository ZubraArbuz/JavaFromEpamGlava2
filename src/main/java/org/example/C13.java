package org.example;

import java.util.Random;
import java.util.Scanner;

public class C13 {
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

        // Преобразование матрицы
        moveZerosToEnd(matrix);
        System.out.println("Матрица после перемещения нулей:");
        printMatrix(matrix);
    }

    private static void moveZerosToEnd(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int[] resultRow = new int[row.length];
            int index = 0;

            // Сначала добавляем ненулевые элементы
            for (int value : row) {
                if (value != 0) {
                    resultRow[index++] = value;
                }
            }

            // Затем добавляем нули
            while (index < resultRow.length) {
                resultRow[index++] = 0;
            }

            // Копируем измененную строку обратно в матрицу
            matrix[i] = resultRow;
        }
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
