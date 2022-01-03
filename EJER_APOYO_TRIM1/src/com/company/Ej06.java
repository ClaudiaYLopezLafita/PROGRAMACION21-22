package com.company;

import java.util.Scanner;

/*
Escribe un programa que cambie un dígito dentro de un número dando la
posición y el valor nuevo. Las posiciones se cuentan de izquierda a
derecha empezando por el 1. Se recomienda usar long en lugar de int ya
que el primero admite números más largos. Suponemos que el usuario
introduce correctamente los datos.
 */
public class Ej06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un numero entero positivo: ");
        int num = sc.nextInt();
        System.out.print("Introduce la posición dentro del número: ");
        int pos = sc.nextInt();
        System.out.print("Introduzca el nuevo dígito: ");
        int dig = sc.nextInt();

        String nunCad = Integer.toString(num);
        String digCad = Integer.toString(dig);
        String nuevaCad="";

        for (int i = 0; i < nunCad.length(); i++) {
            if (i+1 == pos){
                nuevaCad = nunCad.replace(nunCad.charAt(i), digCad.charAt(0));
            }
        }
        int nuevoNum = Integer.parseInt(nuevaCad);

        System.out.println("Tu nuevo numero es: "+nuevoNum);

    }
}
