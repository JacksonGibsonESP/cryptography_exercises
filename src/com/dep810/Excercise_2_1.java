package com.dep810;

import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 30.12.2017.
 */
public class Excercise_2_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число m: ");
        Integer m = Integer.valueOf(scanner.next());

        Boolean sieve[] = new Boolean[m + 1];
        for (int i = 0; i <= m; i++) {
            sieve[i] = false;
        }

        for (int x = 1; x <= (int) Math.sqrt(m); x++) {
            for (int y = 1; y <= (int) Math.sqrt(m); y++) {
                int n = 4 * x * x + y * y;
                if ((n <= m) && ((n % 12 == 1) || (n % 12 == 5))) {
                    sieve[n] = !sieve[n];
                }
                n = 3 * x * x + y * y;
                if ((n <= m) && (n % 12 == 7)) {
                    sieve[n] = !sieve[n];
                }
                n = 3 * x * x - y * y;
                if ((x > y) && (n <= m) && (n % 12 == 11)) {
                    sieve[n] = !sieve[n];
                }
            }
        }
        for (int x = 5; x < (int) Math.sqrt(m); x++) {
            if (sieve[x]) {
                for (int y = x * x; y <= m; y += x * x) {
                    sieve[y] = false;
                }
            }
        }
        System.out.println(2);
        System.out.println(3);
        System.out.println(5);
        for (int p = 6; p <= m; p++) {
            if (sieve[p] && (p % 3 != 0) && (p % 5 != 0)) {
                System.out.println(p);
            }
        }
    }
}