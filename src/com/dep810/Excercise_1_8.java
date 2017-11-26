package com.dep810;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 26.11.2017.
 */
public class Excercise_1_8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        BigInteger a = new BigInteger(scanner.next(), 2);

        System.out.print("Введите перестановку слитно, без запятых и скобок: ");
        BigInteger perm = new BigInteger(scanner.next());

        BigInteger out = BigInteger.ZERO;

        for (int i = 0; i < a.bitLength(); i++) {
            BigInteger index = perm.remainder(BigInteger.TEN);
            perm = perm.divide(BigInteger.TEN);
            if(a.testBit(index.intValue())) {
                out = out.setBit(i);
            }
        }

        System.out.println("Результат: " + out.toString(2));
    }
}
