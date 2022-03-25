package com.company.Listas.Tarea1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
Actividad 7: Introducir por teclado, hasta que se introduzca "fin",
una serie de nombres que se insertarán por orden alfabético en una colección que no permita
repeticiones. Mostrar luego la lista de nombres por pantalla.
 */
public class Ejer07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>();

        System.out.println("Empieza a escribir nombres: ");
        String palabra;

        do {
            palabra = sc.nextLine();
            if (!lista.contains(palabra) && !palabra.equalsIgnoreCase("fin")){
                lista.add(palabra);
            }
        }while (!palabra.equalsIgnoreCase("Fin"));

        lista.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println(lista);
    }
}
