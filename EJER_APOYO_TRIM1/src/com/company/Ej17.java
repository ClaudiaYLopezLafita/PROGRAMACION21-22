package com.company;

import java.util.Arrays;
import java.util.Scanner;
/*
Define la función convierteArrayEnString con la siguiente cabecera:
public static String convierteArrayEnString(int[] a)
Esta función toma como parámetro un array que contiene números y
devuelve una cadena de caracteres con esos números. Por ejemplo, si a
= { }, convierteArrayEnString(a) devuelve “”; si a = { 8 },
convierteArrayEnString(a) devuelve “8”; si a = { 6, 2, 5, 0, 1 },
convierteArrayEnString(a) devuelve “62501”.
 */

public class Ej17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el tamaño de tu Array: ");
        int tam = sc.nextInt();
        
        int[] num = new int[tam];

        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random()*51);
        }

        System.out.println(Arrays.toString(num));
        System.out.println("Tu array trannsformado en cadena es: ");
        System.out.println(convierteArrayEnString(num));

    }

    public static String convierteArrayEnString(int[] a){

        String resultado = "";

        for (int i = 0; i < a.length; i++) {
            resultado = resultado+a[i];
        }

        return resultado;
    }
}
