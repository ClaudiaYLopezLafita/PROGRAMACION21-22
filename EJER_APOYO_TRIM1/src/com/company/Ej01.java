package com.company;
/*
Escribe un programa que lea un número n e imprima una pirámide de
números con n filas como en la siguiente figura:
 */

import java.util.Scanner;

public class Ej01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Indica cuantas filas quieres en tu piramide: ");
        int numFilas = sc.nextInt();

        int altura = 1; // al altura  minima es de un valor (==1)
        int numEspacios = numFilas - 1;

        while (numFilas >= altura) {

            for (int i = 1; i <= numEspacios; i++) {
                System.out.print(" ");
            }

            for (int i = 1; i < altura; i++) {
                System.out.print(i);
            }

            for (int i = altura; i > 0; i--) {
                System.out.print(i);
            }

            System.out.println();

            altura++;
            numEspacios--;
        }
    }
}
