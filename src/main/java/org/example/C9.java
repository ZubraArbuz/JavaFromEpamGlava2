package org.example;

import java.util.Random;
import java.util.Scanner;

public class C9 {
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

        double[][] resultMatrix = subtractMean(matrix);
        System.out.println("Матрица после вычитания средних арифметических:");
        printMatrix(resultMatrix);
    }

    // Метод для вычитания средних арифметических из каждой строки
    private static double[][] subtractMean(int[][] matrix) {
        int n = matrix.length;
        double[][] result = new double[n][n];

        for (int i = 0; i < n; i++) {
            double rowMean = calculateMean(matrix[i]);
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix[i][j] - rowMean;
            }
        }

        return result;
    }

    private static double calculateMean(int[] row) {
        double sum = 0;
        for (int value : row) {
            sum += value;
        }
        return sum / row.length;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.2f\t", value); // Форматирование до двух знаков после запятой
            }
            System.out.println();
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
