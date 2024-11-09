package org.example;

import java.util.Random;
import java.util.Scanner;

public class C7 {
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

        System.out.print("Введите угол поворота (90, 180 или 270): ");
        int angle = scanner.nextInt();
        int[][] rotatedMatrix;

        switch (angle) {
            case 90:
                rotatedMatrix = rotate90(matrix);
                break;
            case 180:
                rotatedMatrix = rotate180(matrix);
                break;
            case 270:
                rotatedMatrix = rotate270(matrix);
                break;
            default:
                System.out.println("Некорректный угол поворота.");
                return;
        }

        System.out.println("Матрица после поворота на " + angle + " градусов:");
        printMatrix(rotatedMatrix);
    }

    // Метод для поворота матрицы на 90 градусов против часовой стрелки
    private static int[][] rotate90(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[n - j - 1][i] = matrix[i][j]; // Транспонирование и переворот
            }
        }
        return rotated;
    }

    // Метод для поворота матрицы на 180 градусов
    private static int[][] rotate180(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[n - i - 1][n - j - 1] = matrix[i][j]; // Две строки и два столбца
            }
        }
        return rotated;
    }

    // Метод для поворота матрицы на 270 градусов против часовой стрелки
    private static int[][] rotate270(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j]; // Поворот на 90 градусов по часовой стрелке
            }
        }
        return rotated;
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
