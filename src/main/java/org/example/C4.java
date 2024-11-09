package org.example;

import java.util.Random;
import java.util.Scanner;

public class C4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы n: ");
        int n = scanner.nextInt();

        // Создание и заполнение матрицы случайными значениями от -n до n
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        for (int i = 0; i < n; i++) {
            int sum = calculateSumBetweenPositives(matrix[i]);
            System.out.println("Сумма элементов между первым и вторым положительными в строке " + i + ": " + sum);
        }
    }

    // Метод для подсчета суммы элементов между первым и вторым положительными элементами строки
    private static int calculateSumBetweenPositives(int[] row) {
        int firstPositiveIndex = -1;
        int secondPositiveIndex = -1;

        // Поиск первого и второго положительных элементов
        for (int j = 0; j < row.length; j++) {
            if (row[j] > 0) {
                if (firstPositiveIndex == -1) {
                    firstPositiveIndex = j;
                } else {
                    secondPositiveIndex = j;
                    break;
                }
            }
        }

        if (firstPositiveIndex != -1 && secondPositiveIndex != -1) {
            int sum = 0;
            for (int j = firstPositiveIndex + 1; j < secondPositiveIndex; j++) {
                sum += row[j];
            }
            return sum;
        }


        return 0;
    }

    // Метод для вывода матрицы
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
