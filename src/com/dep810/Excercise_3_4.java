package com.dep810;

import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 05.01.2018.
 */
public class Excercise_3_4 {

    static int[] gcd(int p, int q) {
        if (q == 0)
            return new int[] { p, 1, 0 };

        int[] vals = gcd(q, p % q);
        int d = vals[0];
        int a = vals[2];
        int b = vals[1] - (p / q) * vals[2];
        return new int[] { d, a, b };
    }

    static String convert(int number) {
        int[] bin = new int[8];
        for (int i = 0; i < 8; i++) {
            bin[7 - i] = (number >> i) % 2;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if (bin[i] != 0) {
                builder.append(" + x^").append(String.valueOf(7 - i));
            }
        }
        String polynom = builder.toString();

        if (number != 0) {
            polynom = polynom.substring(3, polynom.length());
        } else {
            polynom = "0";
        }

        return polynom;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int number1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int number2 = scanner.nextInt();

        int [] res = gcd(number1, number2);

        System.out.println("Первый полином: " + convert(number1));
        System.out.println("Второй полином: " + convert(number2));
        System.out.println("Наибольший общий делитель: " + convert(res[0]));
    }
}
