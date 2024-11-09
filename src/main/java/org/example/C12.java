package org.example;

import java.util.Random;
import java.util.Scanner;

public class C12 {
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
        System.out.print("Введите строку (0-" + (n - 1) + ") для перемещения минимального элемента: ");
        int targetRow = scanner.nextInt();
        System.out.print("Введите столбец (0-" + (n - 1) + ") для перемещения минимального элемента: ");
        int targetCol = scanner.nextInt();

        // Перемещение минимального элемента
        moveMinElement(matrix, targetRow, targetCol);
        System.out.println("Матрица после перемещения минимального элемента:");
        printMatrix(matrix);
    }

    // Метод для нахождения минимального элемента и его перемещения
    private static void moveMinElement(int[][] matrix, int targetRow, int targetCol) {
        int n = matrix.length;
        int minElement = Integer.MAX_VALUE;
        int minRow = -1;
        int minCol = -1;

        // Находим минимальный элемент и его координаты
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }

        // Перемещение минимального элемента на заданную позицию
        // Меняем местами строки
        for (int j = 0; j < n; j++) {
            int temp = matrix[targetRow][j];
            matrix[targetRow][j] = matrix[minRow][j];
            matrix[minRow][j] = temp;
        }

        // Меняем местами столбцы
        for (int i = 0; i < n; i++) {
            int temp = matrix[i][targetCol];
            matrix[i][targetCol] = matrix[i][minCol];
            matrix[i][minCol] = temp;
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
