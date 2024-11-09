package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class C15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы n: ");
        int n = scanner.nextInt();

        // Создание и заполнение матрицы случайными значениями
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(21) - 10; // Заполнение значениями от -10 до 10
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        // Перестройка матрицы по сумме строк
        int[][] sortedMatrix = sortMatrixByRowSum(matrix);
        System.out.println("Матрица после сортировки по сумме строк:");
        printMatrix(sortedMatrix);
    }

    // Метод для сортировки матрицы по сумме строк
    private static int[][] sortMatrixByRowSum(int[][] matrix) {
        int n = matrix.length;
        int[][] sortedMatrix = new int[n][];
        int[] rowSums = new int[n];

        // Вычисление суммы для каждой строки
        for (int i = 0; i < n; i++) {
            rowSums[i] = Arrays.stream(matrix[i]).sum();
            sortedMatrix[i] = matrix[i]; // Копируем строки в новый массив
        }

        // Сортировка строк по сумме с использованием компаратора
        Arrays.sort(sortedMatrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] row1, int[] row2) {
                return Integer.compare(Arrays.stream(row1).sum(), Arrays.stream(row2).sum());
            }
        });

        return sortedMatrix;
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
