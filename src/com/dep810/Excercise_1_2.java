package com.dep810;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 26.11.2017.
 */
public class Excercise_1_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        BigInteger a = new BigInteger(scanner.next(), 2);
        int len = a.bitLength();
        System.out.print("Введите i: ");
        int i = scanner.nextInt();

        BigInteger mask = BigInteger.ZERO;
        mask = mask.setBit(i);
        BigInteger left = a.remainder(mask);
        BigInteger right = a.shiftRight(len - i).shiftLeft(i);

        System.out.format("Результат склейки: %s\n", left.or(right).toString(2));

        mask = BigInteger.ZERO.setBit(len - i);
        BigInteger sub = a.remainder(mask);

        System.out.format("Биты между: %s\n", sub.shiftRight(i).toString(2));
    }
}
