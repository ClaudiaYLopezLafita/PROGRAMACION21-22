package com.company.Conjuntos.Tarea2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Actividad 12: Escribir el método incluido(), que devuelve true si todos los elementos del primer
 conjunto pertenecen al segundo y false si hay algún elemento del primero que no pertenezca al
 segundo. Su prototipo es:

boolean incluido(Set conjunto1, Set conjunto2)
 */
public class Ejer12 {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("Hola");
        set1.add("como");
        set1.add("estas");
        set1.add("gato");

        set2.add("El");
        set2.add("mundo");
        set2.add("del");
        set2.add("gato");
        set2.add("peludo");

        System.out.println(set1);
        System.out.println(set2);
        System.out.println();
        System.out.println("Tu metodo incluido de conjuntos dice: ");
        System.out.println(incluido(set1, set2));
    }

    public static boolean incluido(Set c1, Set c2){
        return c2.containsAll(c1);
        // se usa para verificar si una conjunto contiene un elementos o no
        //TRUE --> el método devuelve True si todos los elementos de la colección col están presentes
        //FALSE --> el metodo devulve False si ningun elem de la coleccion está presente.
    }
}
