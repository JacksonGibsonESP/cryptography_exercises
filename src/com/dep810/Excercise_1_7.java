package com.dep810;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 26.11.2017.
 */
public class Excercise_1_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        BigInteger in = new BigInteger(scanner.next(), 2);

        System.out.print("Введите число n: ");
        int n = scanner.nextInt();

        BigInteger out = BigInteger.ZERO;

        for (int i = 0; i < in.bitLength(); i++) {
            if (in.testBit(i)) {
                out = out.setBit((i - (n % in.bitLength()) + in.bitLength()) % in.bitLength());
            }
        }

        System.out.println("Результат циклического сдвига вправо: " + out.toString(2));

        out = BigInteger.ZERO;

        for (int i = 0; i < in.bitLength(); i++) {
            if (in.testBit(i)) {
                out = out.setBit((i + (n % in.bitLength())) % in.bitLength());
            }
        }

        System.out.println("Результат циклического сдвига влево: " + out.toString(2));
    }
}
