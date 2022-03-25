package com.company.Conjuntos.Tarea2;

import java.util.HashSet;
import java.util.Set;

/*
Actividad 9: Implementar el método unión de dos conjuntos, que devuelva un nuevo conjunto con todos
los elementos que pertenezcan, al menos, a uno de los dos conjuntos. Su prototipo es:

Set union (Set conjunto1, Set conjunto2)
 */
public class Ejer09 {
    public static void main(String[] args) {

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("Hola");
        set1.add("como");
        set1.add("estas");
        set1.add("gato");

        set2.add("El");
        set2.add("gato");
        set2.add("con");
        set2.add("botas");
        set2.add("gordo");

        System.out.println(set1);
        System.out.println(set2);
        System.out.println();
        System.out.println("Tu conjunto de conjuntos: ");
        System.out.println(union(set1, set2));

    }

    public static Set union(Set conjunto1, Set conjunto2){

        Set<String> setResult = new HashSet<>(conjunto1);

        setResult.addAll(conjunto2);

        return setResult;
    }
}
