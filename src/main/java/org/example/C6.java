package org.example;

import java.util.Random;
import java.util.Scanner;

public class C6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы n: ");
        int n = scanner.nextInt();

        // Создание и заполнение матрицы случайными вещественными значениями
        double[][] matrix = new double[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextDouble() * (2 * n) - n; // Заполнение значениями от -n до n
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        // Округление элементов матрицы
        int[][] roundedMatrix = roundMatrix(matrix);

        System.out.println("Матрица после округления:");
        printMatrix(roundedMatrix);
    }

    // Метод для округления элементов матрицы
    private static int[][] roundMatrix(double[][] matrix) {
        int n = matrix.length;
        int[][] roundedMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                roundedMatrix[i][j] = (int) Math.round(matrix[i][j]);
            }
        }
        return roundedMatrix;
    }

    // Метод для вывода матрицы
    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.2f\t", value);
            }
            System.out.println();
        }
    }

    // Перегруженный метод для вывода матрицы целых чисел
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
