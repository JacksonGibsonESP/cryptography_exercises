package com.dep810;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 26.11.2017.
 */
public class Excercise_1_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        BigInteger a = new BigInteger(scanner.next(), 2);

        int j = a.bitLength();

        if (j != 0) {
            System.out.format("Максимальная степень: %s", j - 1);
        } else {
            System.out.format("Максимальная степень: %s", 1);
        }
    }
}
