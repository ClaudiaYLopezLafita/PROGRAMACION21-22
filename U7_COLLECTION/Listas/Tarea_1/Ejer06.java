package com.company.Listas.Tarea1;

import java.util.ArrayList;
import java.util.Scanner;
/*
Actividad 6: Introducir por teclado, hasta que se introduzca "fin", una serie de nombres que se
insertarán en una colección, de forma que se conserve el orden de inserción y que no puedan repetirse.
Mostrar la estructura por pantalla.
 */
public class Ejer06 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();
        String palabra;

        System.out.println("Empieza a escribir palabras: ");
        do {
            palabra = sc.nextLine();
            if (!lista.contains(palabra) && !palabra.equalsIgnoreCase("fin")){
                lista.add(palabra);
            }
        }while (!palabra.equalsIgnoreCase("Fin"));

        System.out.println(lista);
    }
}
