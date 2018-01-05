package com.dep810;

import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 05.01.2018.
 */
public class Excercise_3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int number1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int number2 = scanner.nextInt();

        int[] bin1 = new int[32];
        int[] bin2 = new int[32];
        for (int i = 0; i < 32; i++) {
            bin1[31 - i] = (number1 >> i) % 2;
            bin2[31 - i] = (number2 >> i) % 2;
        }

        int[] mult = new int [1024];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                mult[i * 32 + j] = bin1[i] * bin2[j];
            }
        }

        int[] res = new int [63];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                res[i + j] += mult[i * 32 + j];
                res[i + j] %= 2;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 63; i++) {
            if (res[i] != 0) {
                builder.append(" + x^").append(String.valueOf(62 - i));
            }
        }
        String polynom = builder.toString();

        if (number1 != 0 && number2 != 0) {
            polynom = polynom.substring(3, polynom.length());
        } else {
            polynom = "0";
        }

        System.out.println("Результат: " + polynom);
    }
}
