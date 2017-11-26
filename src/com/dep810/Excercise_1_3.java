package com.dep810;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 26.11.2017.
 */
public class Excercise_1_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        BigInteger in = new BigInteger(scanner.next(), 2);
        System.out.print("Введите i-й байт: ");
        int i = scanner.nextInt();
        System.out.print("Введите j-й байт: ");
        int j = scanner.nextInt();

        BigInteger iByteMask = new BigInteger("255");
        BigInteger jByteMask = new BigInteger("255");

        iByteMask = iByteMask.shiftLeft(8 * i);
        jByteMask = jByteMask.shiftLeft(8 * j);

        iByteMask = in.and(iByteMask);
        jByteMask = in.and(jByteMask);

        in = in.xor(iByteMask);
        in = in.xor(jByteMask);

        iByteMask = iByteMask.shiftRight(8 * i);
        jByteMask = jByteMask.shiftRight(8 * j);

        iByteMask = iByteMask.shiftLeft(8 * j);
        jByteMask = jByteMask.shiftLeft(8 * i);

        in = in.or(iByteMask);
        in = in.or(jByteMask);

        System.out.format("Результат: %s\n", in.toString(2));
    }
}
