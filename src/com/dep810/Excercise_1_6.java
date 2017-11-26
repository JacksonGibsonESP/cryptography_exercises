package com.dep810;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 26.11.2017.
 */
public class Excercise_1_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        BigInteger in = new BigInteger(scanner.next(), 2);

        boolean sub = in.testBit(0);
        for (int i = 1; i < in.bitLength(); i++) {
            sub = sub ^ in.testBit(i);
        }

        System.out.format("Результат: %s", sub ? 1 : 0);
    }
}
