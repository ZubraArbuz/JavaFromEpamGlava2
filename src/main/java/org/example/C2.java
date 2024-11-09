package org.example;

import java.util.Random;
import java.util.Scanner;

public class C2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы n: ");
        int n = scanner.nextInt();
        System.out.print("Введите количество позиций для сдвига k: ");
        int k = scanner.nextInt();
        System.out.print("Введите направление сдвига (right, left, up, down): ");
        String direction = scanner.next();

        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        switch (direction) {
            case "right" -> shiftRight(matrix, k);
            case "left" -> shiftLeft(matrix, k);
            case "up" -> shiftUp(matrix, k);
            case "down" -> shiftDown(matrix, k);
            default -> System.out.println("Ошибка: неверное направление.");
        }

        System.out.println("Матрица после сдвига " + direction + " на " + k + " позиций:");
        printMatrix(matrix);
    }

    private static void shiftRight(int[][] matrix, int k) {
        int n = matrix.length;
        k %= n; // Учёт цикличности
        for (int i = 0; i < n; i++) {
            int[] newRow = new int[n];
            for (int j = 0; j < n; j++) {
                newRow[(j + k) % n] = matrix[i][j];
            }
            matrix[i] = newRow;
        }
    }

    private static void shiftLeft(int[][] matrix, int k) {
        int n = matrix.length;
        k %= n;
        for (int i = 0; i < n; i++) {
            int[] newRow = new int[n];
            for (int j = 0; j < n; j++) {
                newRow[j] = matrix[i][(j + k) % n];
            }
            matrix[i] = newRow;
        }
    }

    private static void shiftUp(int[][] matrix, int k) {
        int n = matrix.length;
        k %= n;
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[i][j] = matrix[(i + k) % n][j];
            }
        }
        // Обновление исходной матрицы
        for (int i = 0; i < n; i++) {
            matrix[i] = newMatrix[i];
        }
    }

    private static void shiftDown(int[][] matrix, int k) {
        int n = matrix.length;
        k %= n;
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[(i + k) % n][j] = matrix[i][j];
            }
        }
        // Обновление исходной матрицы
        for (int i = 0; i < n; i++) {
            matrix[i] = newMatrix[i];
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
