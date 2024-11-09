package org.example;

import java.util.Scanner;

public class B9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число от 1 до 12: ");
        int monthNumber = scanner.nextInt();

        String[] months = {
                "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
        };

        if (monthNumber >= 1 && monthNumber <= 12) {
            System.out.println("Месяц: " + months[monthNumber - 1]);
        } else {
            System.out.println("Ошибка: введите число от 1 до 12.");
        }
    }
}
