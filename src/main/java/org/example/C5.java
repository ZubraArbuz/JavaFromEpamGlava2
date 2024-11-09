package org.example;
import java.util.*;
public class C5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение k: ");
        int k = scanner.nextInt();

        int n = (int) Math.ceil(Math.sqrt(k));
        int[][] matrix = new int[n][n];


        int number = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (number <= k) {
                    matrix[i][j] = number++;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println("Матрица:");
        printMatrix(matrix);
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
