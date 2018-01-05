package com.dep810;

import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 05.01.2018.
 */
public class Excercise_3_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int number1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int number2 = scanner.nextInt();

        int[] bin1 = new int[8];
        int[] bin2 = new int[8];
        for (int i = 0; i < 8; i++) {
            bin1[7 - i] = (number1 >> i) % 2;
            bin2[7 - i] = (number2 >> i) % 2;
        }

        int[] mult = new int [64];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mult[i * 8 + j] = bin1[i] * bin2[j];
            }
        }

        int[] res = new int [15];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                res[i + j] += mult[i * 8 + j];
                res[i + j] %= 2;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            builder.append(String.valueOf(res[i]));
        }
        int toreduce = Integer.valueOf(builder.toString(), 2);

        if (toreduce > 255) {
            int length = 8;
            while (toreduce >> length != 0) {
                length++;
            }
            while (length != 8) {
                if ((toreduce & (256 << (length - 9))) > 0) {
                    toreduce ^= 0x11b << (length - 9);
                }
                length--;
            }
        }

        int[] afterReduce = new int[8];
        for (int i = 0; i < 8; i++) {
            afterReduce[7 - i] = (toreduce >> i) % 2;
        }

        builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if (afterReduce[i] != 0) {
                builder.append(" + x^").append(String.valueOf(7 - i));
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
