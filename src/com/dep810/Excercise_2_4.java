package com.dep810;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 30.12.2017.
 */
public class Excercise_2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите g: ");
        Integer g = Integer.valueOf(scanner.next());
        System.out.print("Введите a: ");
        Integer a = Integer.valueOf(scanner.next());
        System.out.print("Введите m: ");
        Integer m = Integer.valueOf(scanner.next());

        System.out.println("В кольцах вычетов:");
        for (int i = 1; i < m; i++) {
            if ((int) Math.pow(g, i) % m == a) {
                System.out.println("x = " + i);
            }
        }

        int N = 1 + (int) Math.sqrt(m);
        Map<Integer, Integer> littleSteps = new HashMap<>();
        int littleStep = 1;
        for (int i = 0; i <= N; i++) {
            littleSteps.put(littleStep, i);
            littleStep = littleStep * g % m;
        }
        int bigJump = BigInteger.valueOf(g).modPow(BigInteger.valueOf((m - 2) * N), BigInteger.valueOf(m)).intValue();
        int bigStep = a;
        for (int i = 0; i <= N; i++) {
            if (littleSteps.containsKey(bigStep)) {
                System.out.println("В полях Галуа:");
                System.out.println("x = " + (i * N + littleSteps.get(bigStep)));
                return;
            } else {
                bigStep = bigStep * bigJump % m;
            }
        }
    }
}