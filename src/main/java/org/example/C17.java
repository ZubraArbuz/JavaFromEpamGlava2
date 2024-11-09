package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class C17 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размер матрицы");
        int n = scan.nextInt();

        int[][] matrix = new int[n][n];
        Random rand = new Random();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = rand.nextInt(21)-10;
            }
        }
        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        Integer smallestLocalMax = findSmallestLocalMaximum(matrix);

    }

    private static Integer findSmallestLocalMaximum(int[][] matrix){
        int n = matrix.length;
        List<Integer> localMaxima = new ArrayList<>();

        for(int i = 0 ;i < n; i++){
            for(int j = 0; j < n;j++){
                if(isLocalMaximum(matrix, i , j)){
                    localMaxima.add(matrix[i][j]);
                }
            }
        }

        if(!localMaxima.isEmpty()){
            return localMaxima.stream().min(Integer::compareTo).orElse(null);
        }else {
            return null;
        }
    }

    private static boolean isLocalMaximum(int[][] matrix, int row, int col){
        int n = matrix.length;
        int currentValue = matrix[row][col];

        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(i == 0 && j == 0) continue;

                int neighborRow = row + i;
                int neighbourCol = col + j;

                if(neighborRow >= 0 && neighborRow < n && neighbourCol >= 0 && neighbourCol < n){
                    if (matrix[neighborRow][neighbourCol] >= currentValue){
                        return false;
                    }
                }
            }
        }
        return true;
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
