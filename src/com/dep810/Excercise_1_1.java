package com.dep810;

import java.math.BigInteger;
import java.util.Scanner;

public class Excercise_1_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        BigInteger a = new BigInteger(scanner.next(), 2);
        System.out.print("Введите k-й бит: ");

        int k = scanner.nextInt();
        if (a.testBit(k)) {
            System.out.format("Значение выбранного бита: %s\n", 1);
            System.out.format("Снимем k-й бит: %s\n", a.flipBit(k).toString(2));
        } else {
            System.out.format("Значение выбранного бита: %s\n", 0);
            System.out.format("Установим k-й бит: %s\n", a.setBit(k).toString(2));
        }

        System.out.print("Введите i-й бит: ");
        int i = scanner.nextInt();
        System.out.print("Введите j-й бит: ");
        int j = scanner.nextInt();

        if (a.testBit(i) && a.testBit(j)) {
            System.out.format("Результат обмена: %s\n", a.toString(2));
        } else if (!a.testBit(i) && !a.testBit(j)) {
            System.out.format("Результат обмена: %s\n", a.toString(2));
        } else if (a.testBit(i)) {
            System.out.format("Результат обмена: %s\n", a.flipBit(i).setBit(j).toString(2));
        } else {
            System.out.format("Результат обмена: %s\n", a.setBit(i).flipBit(j).toString(2));
        }

        System.out.print("Введите m: ");
        int m = scanner.nextInt();
        System.out.format("Результат обнуления младших m битов: %s\n", a.shiftRight(m).shiftLeft(m).toString(2));
    }
}
