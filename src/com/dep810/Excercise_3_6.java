package com.dep810;

import java.math.BigInteger;
import java.util.Scanner;

public class Excercise_3_6 {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Введите p: ");
      BigInteger p = new BigInteger(scanner.next());
      System.out.print("Введите q: ");
      BigInteger q = new BigInteger(scanner.next());

      BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
      BigInteger n = p.multiply(q);
      BigInteger publicKey = new BigInteger("65537");
      System.out.println("Публичный ключ: " + publicKey);
      BigInteger privateKey = publicKey.modInverse(phi);
      System.out.println("Приватный ключ: " + privateKey);

      System.out.print("Введите числовое сообщение: ");
      BigInteger message = new BigInteger(scanner.next());

      BigInteger encrypt = message.modPow(publicKey, n);
      BigInteger decrypt = encrypt.modPow(privateKey, n);
      System.out.println("Зашифрованное = " + encrypt);
      System.out.println("Дешифрованное = " + decrypt);
   }
}
