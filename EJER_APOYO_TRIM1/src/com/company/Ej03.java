package com.company;
/*
ealiza un programa que pinte la letra U por pantalla hecha con
asteriscos. El programa pedirá la altura. Fíjate que el programa
inserta un espacio y pinta dos asteriscos menos en la base para
simular la curvatura de las esquinas inferiores.
 */

import java.util.Scanner;

public class Ej03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la altura de la U: ");
        int altura = sc.nextInt();

        for (int i = 0; i < altura; i++) {
            if (i==altura-1){ /// base
                for (int j = 0; j <= altura-2; j++) {
                    if (j==0){
                        System.out.print("  ");
                    } else {
                        System.out.print("* ");
                    }
                }
            } else {///palitos de la U
                for (int j = 0; j < altura; j++) {
                    if (j==0 || j==altura-1){
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }

        }
    }
}
