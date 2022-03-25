package com.company.Listas.Tarea1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/*
Actividad 4: Introducir por consola una frase que conste exclusivamente de palabras separadas por espacios.
Almacenar en una lista las palabras de la frase, una en cada nodo y mostrar por pantalla las palabras que
estén repetidas. A continuación, mostrar las que no lo estén.
 */
public class Ejer04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();
        ArrayList<String> repetidos = new ArrayList<>();

        System.out.println("Escribe una frase: ");
        String frase = sc.nextLine();

        String[] palabras = frase.split(" ");

        // recorremos el string y vamos añadiendo palabras
        for (String p:palabras) {
            lista.add(p);
        }

        // no hay un constrictor que nos permita crear un arraylis pasandole un Array de palabras.

        // addAll -- permite con otro collection pero  no con cadenas.

        System.out.println(lista);

        System.out.println("Elementos repetidos: ");
        Iterator it = lista.iterator();
        while (it.hasNext()){
            String element = (String) it.next();
            if (lista.indexOf(element)!=lista.lastIndexOf(element)){ // esta repetido
                if (!repetidos.contains(element)){ // no esta en la lista de repetidos
                    repetidos.add(element);
                    System.out.println(element);
                }
            }
        }
        System.out.println("Elementos no repetidos: ");
        it = lista.iterator();
        while (it.hasNext()){
            String element = (String) it.next();
            if (lista.indexOf(element)==lista.lastIndexOf(element)){ // no esta repetido
                System.out.println(element);
            }
        }
    }
}
