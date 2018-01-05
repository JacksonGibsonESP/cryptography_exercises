package com.dep810;

import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 05.01.2018.
 */
public class Excercise_3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        if (number >= 0 && number < 256) {
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

            builder = new StringBuilder();

            for (int i = 0; i < 8; i++) {
                builder.append(String.valueOf(bin[i]));
            }
            int checkNumber = Integer.valueOf(builder.toString(), 2);

            System.out.println("В полиномиальной форме: " + polynom
                    + "\nВозврат к числовому представлению: " + checkNumber);
        } else {
            System.out.println("Вы вышли за границы");
        }
    }
}
