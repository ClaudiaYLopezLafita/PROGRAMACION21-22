package com.company;

import java.util.Scanner;
/*
Escribe un programa que pida un número entero positivo por teclado y
que muestre a continuación los 5 números consecutivos a partir del
número introducido. Al lado de cada número se debe indicar si se trata
de un primo o no.
 */
public class Ej05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero: ");
        int num = sc.nextInt();

        for (int i = num; i < num+5; i++) {
           if (esPrimo(i)){
               System.out.println(i+" es primo");
           } else {
               System.out.println(i+" no es primo");
           }
        }
    }

    public static boolean esPrimo(int x){
        boolean esPrimo = true;

        for (int i = 2; i < x; i++) {
            if (x%i == 0){
                esPrimo = false;
                break;
            } else {
                esPrimo = true;
            }
        }

        return esPrimo;
    }
}
