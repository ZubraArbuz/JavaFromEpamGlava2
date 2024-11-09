package org.example;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] arr = {123,333,434,454};
//        for (int i = 0; i < num; i++) {
//            int a = rand.nextInt(1001);
//            arr[i] = a;
//            System.out.print(arr[i] + " ");
//        }
        System.out.println();

        int shortesnum = A1short(arr);
        int longestnum = A1long(arr);
        System.out.println("A1.Самое короткое число: " + shortesnum + " с длиной: " + String.valueOf(shortesnum).length());
        System.out.println("A1.Самое длинное число: " + longestnum + " с длиной: " + String.valueOf(longestnum).length());

        int[] sortedArr = A2(arr);
        System.out.println("A2.Упорядоченные числа по длине: " + Arrays.toString(sortedArr));
        System.out.print("A3.");
        A3(arr);

        int minUniqueDigitsNum = A4(arr);
        System.out.println("A4.Число с минимальным количеством различных цифр: " + minUniqueDigitsNum);
        System.out.print("A5.");
        A5(arr);

        int increasingNum = A6(arr);
        System.out.println("A6.Число с цифрами в строгом порядке возрастания: " + increasingNum);

        int uniqueDigitsNum = A7(arr);
        System.out.println("A7.Число с уникальными цифрами: " + uniqueDigitsNum);


        System.out.println("A8.Числа-палиндром: ");
        A8(arr);
    }

    public static int A1short(int[] arr) {
        int shortnum = arr[0];
        for (int num : arr) {
            if (String.valueOf(num).length() < String.valueOf(shortnum).length()) {
                shortnum = num;
            }
        }
        return shortnum;
    }

    public static int A1long(int[] arr) {
        int longnum = arr[0];
        for (int num : arr) {
            if (String.valueOf(num).length() > String.valueOf(longnum).length()) {
                longnum = num;
            }
        }
        return longnum;
    }

    public static int[] A2(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(n -> String.valueOf(n).length())).mapToInt(i -> i).toArray();
    }

    public static void A3(int[] arr) {
        double avgLength = Arrays.stream(arr).mapToDouble(n -> String.valueOf(n).length()).average().orElse(0);
        System.out.println("Средняя длина: " + avgLength);
        System.out.println("Числа с длиной меньше средней:");
        for (int num : arr) {
            if (String.valueOf(num).length() < avgLength) {
                System.out.println(num + " (длина: " + String.valueOf(num).length() + ")");
            }
        }
        System.out.println("Числа с длиной больше средней:");
        for (int num : arr) {
            if (String.valueOf(num).length() > avgLength) {
                System.out.println(num + " (длина: " + String.valueOf(num).length() + ")");
            }
        }
    }

    public static int A4(int[] arr) {
        int result = arr[0];
        int minUniqueDigits = uniqueDigitCount(arr[0]);

        for (int num : arr) {
            int uniqueDigits = uniqueDigitCount(num);
            if (uniqueDigits < minUniqueDigits) {
                minUniqueDigits = uniqueDigits;
                result = num;
            }
        }
        return result;
    }

    public static int uniqueDigitCount(int num) {
        String numStr = String.valueOf(num);
        return (int) numStr.chars().distinct().count();
    }

    public static void A5(int[] arr) {
        int evenDigitsOnlyCount = 0;
        int evenOddEqualCount = 0;

        for (int num : arr) {
            String numStr = String.valueOf(num);
            boolean allEven = numStr.chars().allMatch(ch -> (ch - '0') % 2 == 0);
            if (allEven) {
                evenDigitsOnlyCount++;
                long evenCount = numStr.chars().filter(ch -> (ch - '0') % 2 == 0).count();
                long oddCount = numStr.length() - evenCount;
                if (evenCount == oddCount) {
                    evenOddEqualCount++;
                }
            }
        }

        System.out.println("Чисел с только четными цифрами: " + evenDigitsOnlyCount);
        System.out.println("Чисел с равным количеством четных и нечетных цифр: " + evenOddEqualCount);
    }

    public static int A6(int[] arr) {
        for (int num : arr) {
            String numStr = String.valueOf(num);
            boolean increasing = true;
            for (int i = 1; i < numStr.length(); i++) {
                if (numStr.charAt(i) <= numStr.charAt(i - 1)) {
                    increasing = false;
                    break;
                }
            }
            if (increasing) {
                return num;
            }
        }
        return -1;
    }

    public static int A7(int[] arr) {
        for (int num : arr) {
            String numStr = String.valueOf(num);
            if (numStr.chars().distinct().count() == numStr.length()) {
                return num;
            }
        }
        return -1;
    }

    public static void A8(int[] arr) {
        int count = 0;
        for (int num : arr) {
            String numStr = String.valueOf(num);
            if (numStr.equals(new StringBuilder(numStr).reverse().toString())) {
                count++;
                System.out.println(num);
                if(count == 2){
                    break;
                }
            }
        }
    }
}
