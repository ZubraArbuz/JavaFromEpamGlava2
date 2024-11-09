package org.example;

import java.util.*;
import java.util.Scanner;

public class C18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размер матрицы n:");
        int n = scan.nextInt();

        int[][] matrix = new int[n][n];
        Random rand = new Random();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = rand.nextInt(21)-10;
            }
        }
        System.out.print("Исходная матрица");
        printMatrix(matrix);

        int[][] sortedMatrix = sortColumnsByCharacteristics(matrix);

        System.out.println("Матрица после сортировки столбцов по характиристике: ");
        printMatrix(sortedMatrix);
    }

    private static int[][] sortColumnsByCharacteristics(int[][] matrix){
        int n = matrix.length;
        Integer[] columnIndex = new Integer[n];
        int[] columnCharacteristics = new int[n];

        for(int j = 0; j < n; j++) {
            columnIndex[j] = j;
            columnCharacteristics[j] = calculateColumnCharacteristics(matrix, j);
        }

        Arrays.sort(columnIndex, (a,b)->Integer.compare(columnCharacteristics[b],columnCharacteristics[a]));

        int[][] sortedMatrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sortedMatrix[i][j] = matrix[i][columnIndex[j]];
            }
        }
        return sortedMatrix;
    }
    private static int calculateColumnCharacteristics(int[][] matrix,int col){
        int sum = 0;
        for(int[] row : matrix){
            sum += Math.abs(row[col]);
        }
        return sum;
    }

    private static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int value : row){
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

}


