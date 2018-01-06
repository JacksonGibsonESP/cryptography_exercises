package com.dep810;

import java.util.Scanner;

/**
 * Created by JacksonGibsonESP on 05.01.2018.
 */
public class Excercise_3_5 {

	public static int mult(int number1, int number2) {
		int[] bin1 = new int[8];
		int[] bin2 = new int[8];
		for (int i = 0; i < 8; i++) {
			bin1[7 - i] = (number1 >> i) % 2;
			bin2[7 - i] = (number2 >> i) % 2;
		}

		int[] mult = new int [64];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				mult[i * 8 + j] = bin1[i] * bin2[j];
			}
		}

		int[] res = new int [15];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				res[i + j] += mult[i * 8 + j];
				res[i + j] %= 2;
			}
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 15; i++) {
			builder.append(String.valueOf(res[i]));
		}
		int toreduce = Integer.valueOf(builder.toString(), 2);

		if (toreduce > 255) {
			int length = 8;
			while (toreduce >> length != 0) {
				length++;
			}
			while (length != 8) {
				if ((toreduce & (256 << (length - 9))) > 0) {
					toreduce ^= 0x11b << (length - 9);
				}
				length--;
			}
		}

		return toreduce;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите число: ");
		int number = scanner.nextInt();

		String polynom = Excercise_3_4.convert(number);
		System.out.println("Полином: " + polynom);

		int res = number;

		for(int i = 0; i < 253; i++) {
			res = mult(number, res);
		}

		polynom = Excercise_3_4.convert(res);

		System.out.println("Обратный полином: " + polynom);
	}
}
