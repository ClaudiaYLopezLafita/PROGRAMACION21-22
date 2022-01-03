package com.company;

import java.util.Scanner;
/*
Escribe un programa que, dado un número entero positivo, diga cuáles
son y cuánto suman los dígitos pares. Los dígitos pares se deben
mostrar en orden, de izquierda a derecha. Usa long en lugar de int
donde sea necesario para admitir números largos.
 */

public class Ej02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Introduce tu numero: ");
        long num = sc.nextLong();
        String numPares ="";
        int suma=0;

        while (num>0){
            long cifra = num%10;
            String cifraCad = Long.toString(cifra);
            if (cifra%2==0){
            numPares=cifraCad+" "+numPares;
            suma+=cifra;
            }
            num/=10;
        }
        System.out.println("Digitos pares: "+numPares);
        System.out.println("Suma de los digitos pares: "+suma);
    }
}
