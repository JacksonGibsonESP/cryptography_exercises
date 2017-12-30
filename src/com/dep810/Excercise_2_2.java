package com.dep810;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 30.12.2017.
 */
public class Excercise_2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число m: ");
        Integer m = Integer.valueOf(scanner.next());

        List<Integer> facts = new LinkedList<>();
        for (int i = 2; i < m; i++) {
            if (m % i == 0) {
                facts.add(i);
            }
        }

        for (int i = 1; i < m; i++) {
            boolean flag = false;
            for (int d :facts) {
                if (i % d == 0) {
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println(i);
            }
        }
    }
}
