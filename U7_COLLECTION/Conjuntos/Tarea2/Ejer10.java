package com.company.Conjuntos.Tarea2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Actividad 10: Hacer lo mismo que en el ejercicio anterior con la intersección , formada por los
elementos comunes a los dos conjuntos. Su prototipo es:

Set interseccion (Set conjunto1, Set conjunto2)
 */
public class Ejer10 {
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
        System.out.println("Tu interseccion de conjuntos: ");
        System.out.println(interseccion(set1, set2));
    }

    public static Set interseccion(Set conjunto1, Set conjunto2){

        Set<String> setResult = new HashSet<>(conjunto1);

        setResult.retainAll(conjunto2);

        return setResult;
    }

    public static Set interseccion2 (Set conjunto1, Set conjunto2){

        Set<String> setResult = new HashSet<>(conjunto1);

        Iterator it = conjunto1.iterator();
        while (it.hasNext()){
            String palabra = (String) it.next();
            if (conjunto2.contains(palabra)){
                setResult.add(palabra);
            }
        }

        return setResult;
    }

    public static Set diferencia(Set conjunto1, Set conjunto2){
        Set<String> setResult = new HashSet<>(conjunto1);

        Iterator it = conjunto1.iterator();
        while (it.hasNext()){
            String palabra = (String) it.next();
            if (!conjunto2.contains(palabra)){
                setResult.add(palabra);
            }
        }

        return setResult;    }
}
