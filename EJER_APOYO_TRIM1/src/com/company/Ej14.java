package com.company;
/*
Crea una función con la siguiente cabecera:
public String convierteEnMorse(int n)
Esta función convierte el número n al sistema Morse y lo devuelve en
una cadena de caracteres. Por ejemplo, el 213 es el . . _ _ _ . _ _ _
_ . . . _ _ en Morse. Utiliza esta función en un programa para
comprobar que funciona bien. Desde la función no se debe mostrar nada
por pantalla, solo se debe usar print desde el programa principal.
 */

import java.util.Scanner;

public class Ej14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el numero para transformarlo en morse: ");
        int num = sc.nextInt();

        System.out.println();
        System.out.println("Tu numero transformado es: ");
        System.out.println(convierteEnMorse(num));

    }

    public static String convierteEnMorse(int n){
        String resultado = "";

        String[] morse = {"_ _ _ _ _", ". _ _ _ _", ". . _ _ _", ". . . _ _", ". . . . _", ". . . . .",
                          "_ . . . .", "_ _ . . .", "_ _ _ . .", "_ _ _ _ ."};

        while (n > 0){
            int cifra = n%10;
            for (int i = 0; i < morse.length; i++) {
                if (cifra == i){
                    resultado = morse[i]+" "+resultado;
                }
            }
            n/=10;
        }

        return resultado;
    }
}
