package org.example;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        B1();
        System.out.println();
        B5();
    }
    public static void B1(){
        int[][] a = new int[11][11];
        for(int i = 1; i<a.length;i++){
            for(int j = 0 ;j<a.length;j++){
                int b =i*j;
                System.out.print(b+" ");
            }
        }
    }

    public static void B2() {
        int[] array = {1, 2, 3, 4, 5};
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
    public static void B3() {
        int n = 2;
        int m = 5;
        int k = 3;
        if (k > n && k <= m) {
            System.out.println("k принадлежит интервалу (n, m]");
        } else {
            System.out.println("k не принадлежит интервалу (n, m]");
        }

        if (k >= n && k < m) {
            System.out.println("k принадлежит интервалу [n, m)");
        } else {
            System.out.println("k не принадлежит интервалу [n, m)");
        }

        if (k > n && k < m) {
            System.out.println("k принадлежит интервалу (n, m)");
        } else {
            System.out.println("k не принадлежит интервалу (n, m)");
        }

        if (k >= n && k <= m) {
            System.out.println("k принадлежит интервалу [n, m]");
        } else {
            System.out.println("k не принадлежит интервалу [n, m]");
        }
    }
    public static void B4() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) { // Проверяем, делится ли i на 3 без остатка
                System.out.print(i + " "); // Выводим число
            }
        }
    }
    public static void B5(){
        int num = 129;
        String binaryNum  = Integer.toBinaryString(num);
        int count = 0;
        char[] arr = binaryNum.toCharArray();
        for (int i = 0;i<binaryNum.length();i++){
            if(arr[i]=='0'){
                count+=1;
            }
        }
        System.out.println("Колличество 0 = "+count);
    }
    public static void B6(){
        int num = 81;
        int base = (int) Math.sqrt(num);
        System.out.println("Система счисления " +base);
    }

}
