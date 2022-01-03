package com.company;
/*
Realiza un programa que pinte un triángulo hueco tal como se muestra
en los ejemplos. El usuario debe introducir la altura de la figura.
Utiliza funciones para pintar las líneas.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Ej16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la altura del trianulo");
        int altura = sc.nextInt();

        System.out.println("Tu triangulo es: ");

        System.out.println(pintaTriangulo(altura));
    }
    
    public static int[][] pintaTriangulo(int a){
        int[][] resultado = new int[a][a];

        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                if(i == 0 || j == 0 || i+j==a-1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        return resultado;
    }
}
