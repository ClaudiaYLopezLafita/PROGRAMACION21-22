package com.company.Listas.Tarea1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
Actividad 8: Implementar una función a la que se le pase una lista de nombres y devuelva una copia
sin elementos repetidos (sin modificar la original), con el prototipo:

List eliminaRepetidos (List c)
 */
public class Ejer08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>();

        String palabra;

        do {
            palabra = sc.nextLine();
            lista.add(palabra);
        }while (!palabra.equalsIgnoreCase("Fin"));

        System.out.println(eliminaRepetidos(lista));
    }

    public static List eliminaRepetidos(List c){

        ArrayList<String> listaSinRep = new ArrayList<>();

        Iterator it = listaSinRep.iterator();
        while (it.hasNext()){
            String palabra = (String) it.next();
            if (!listaSinRep.contains(palabra)){
                listaSinRep.add(palabra);
            }
        }

        return listaSinRep;

        /*
        Set<String> sinRepetidos = new HashSet<List>;

        return sinRepetidos.
         */
    }
}
