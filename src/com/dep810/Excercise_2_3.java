package com.dep810;

import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 30.12.2017.
 */
public class Excercise_2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число m: ");
        Integer m = Integer.valueOf(scanner.next());

        int result = m;
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                while (m % i == 0) {
                    m /= i;
                }
                result -= result / i;
            }
        }
        if (m > 1) {
            result -= result / m;
        }
        System.out.println(result);
    }
}
