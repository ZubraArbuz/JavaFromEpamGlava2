package org.example;

public class B7 {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        int base = Integer.parseInt(args[1]);
        StringBuilder result = new StringBuilder();
        char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        while (num>0){
            int remain = num%base;
            result.append(digits[remain]);
            num/=base;
        }
        System.out.println(result.reverse().toString());
    }
}
