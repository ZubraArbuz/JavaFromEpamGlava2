package org.example;

import java.util.Random;
import java.util.Scanner;

public class C16 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размер матрицы");
        int n = scan.nextInt();

        int[][] matrix = new int[n][n];
        Random random = new Random();
        for(int i = 0; i < n; i++){
            for(int j = 0; i < n; i++){
                matrix[i][j] = random.nextInt(21)-10;
            }
        }

        System.out.println("Исходная матрица");
        printMatrix(matrix);

        int localMinimaCount = countLocalMinima(matrix);
    }
    private static int countLocalMinima(int[][] matrix){
        int count = 0;
        int n = matrix.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (isLocalMinimum(matrix,i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isLocalMinimum(int[][] matrix, int row, int col){
        int n = matrix.length;
        int currentValue = matrix[row][col];

        for(int i = -1; i <= 1; i++){
            for(int j = -1 ;j <= 1; j++){
                if(i == 0 && j ==0) continue;

                int neighborRow = row + i;
                int neighborCol = col + j;

                if(neighborRow >= 0 && neighborRow < n && neighborCol >= 0 && neighborCol < n){
                    if (matrix[neighborRow][neighborCol] <= currentValue) {
                        return false;
                    }

                }
            }
        }
        return true;
    }

    private  static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int value : row){
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }


}
