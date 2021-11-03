package com.company;

import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         /*
        Escribe un programa que pinte por pantalla un árbol de navidad. El usuario debe introducir la altura.
         En esa altura va incluida la estrella y el tronco. Suponemos que el usuario introduce una altura
         mayor o igual a 4. Si la altura no es correcta se volverá a pedir hasta que el usuario
         introduzca una altura correcta.
         */

        int altura;

        do {
            System.out.println("Introduce la altura del arbol");
            altura = sc.nextInt();
        } while (altura<4);

        for (int i = 1; i <=altura; i++) {

            for (int j = 1; j <=altura-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (i*2)-1; j++) {
                System.out.print("^");
            }
            System.out.println();
        }
    }
}
