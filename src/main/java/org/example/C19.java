package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class C19 {
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
        System.out.println("Исходная матрица");
        printMatrix(matrix);

        arrangeMaxOnDeiagonal(matrix);

        System.out.println("Матрица после перестановки максимальных элементов на главную диагональ");
        printMatrix(matrix);
    }
    private static void arrangeMaxOnDeiagonal(int[][] matrix){
        int n = matrix.length;
        ArrayList<Integer> elements = new ArrayList<>();

        for(int[]row : matrix){
            for(int element : row){
                elements.add(element);
            }
        }

        elements.sort(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            matrix[i][i] = elements.get(i);
        }

        int idx = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n;j++){
                if(i != j){
                    matrix[i][j] = elements.get(idx++);
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix){
        for(int[] row :matrix){
            for(int value : row){
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
