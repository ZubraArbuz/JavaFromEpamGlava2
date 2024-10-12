package org.example;

import java.util.Scanner;

public class B8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        String number = scanner.nextLine();

        System.out.print("Введите основание исходной системы счисления: ");
        int sourceBase = scanner.nextInt();

        System.out.print("Введите основание целевой системы счисления: ");
        int targetBase = scanner.nextInt();

        try {
            int decimalNumber = convertToDecimal(number, sourceBase);

            String result = convertFromDecimal(decimalNumber, targetBase);

            System.out.println("Число " + number + " в системе счисления с основанием " + targetBase + ": " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int convertToDecimal(String number, int base) {
        int decimalValue = 0;
        char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        number = number.toUpperCase();

        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            int value = -1;

            for (int j = 0; j < base; j++) {
                if (digits[j] == digit) {
                    value = j;
                    break;
                }
            }

            if (value == -1) {
                throw new IllegalArgumentException("Недопустимый символ для данной системы счисления: " + digit);
            }

            decimalValue = decimalValue * base + value;
        }

        return decimalValue;
    }

    public static String convertFromDecimal(int decimalNumber, int base) {
        StringBuilder result = new StringBuilder();
        char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        if (decimalNumber == 0) {
            return "0";
        }

        while (decimalNumber > 0) {
            int remain = decimalNumber % base;
            result.append(digits[remain]);
            decimalNumber /= base;
        }

        return result.reverse().toString();
    }

}
