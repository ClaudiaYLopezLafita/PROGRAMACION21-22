package com.company.Listas.Tarea2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Actividad 14: Implementar la función leeCadena con el siguiente prototipo:

List<Character> leeCadena()

Dicha función lee una cadena por teclado y nos la devuelve en una lista con un carácter en cada nodo.
 */
public class Ejer14 {
    public static void main(String[] args) {

        List<Character> lista = leeCadena();
        System.out.println("Resultado: ");
        System.out.println(lista);

    }

    public static List<Character> leeCadena(){
        Scanner sc = new Scanner(System.in);
        List<Character> result = new ArrayList<>();

        System.out.println("Introduce una frase: ");
        String frase = sc.nextLine();

        for (int i = 0; i < frase.length(); i++) {
            result.add(frase.charAt(i));
        }

        return result;
    }
}
