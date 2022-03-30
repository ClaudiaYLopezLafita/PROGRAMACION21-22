package com.company.Maps.Tarea3b;
import java.util.*;

/*
Actividad 3: Recorre el Map anterior, extrayendo cada pareja clave-valor, y mostrándolas,
de tal forma que se escriban los datos así:

La clave 37 está asociada al nombre "Pedro Gonzalez Jimenez".

La clave ... está asociada al nombre ....
 */
public class Ejer03 {

    public static void main(String[] args) {

        Map<String,String> students = new HashMap<>();
        Set<Map.Entry<String,String>> result = students.entrySet();

        students.put("12345678A","Ana");
        students.put("32165498A","Andrea");
        students.put("78945612A","Jorge");
        students.put("74185296A","Manuel");
        students.put("36925814A","Claudia");

        Iterator it = result.iterator();
        while (it.hasNext()){
            Map.Entry<String,String> e = (Map.Entry<String,String>) it.next();
            // e es un objeto que contiene la clave y el valor
            System.out.println("La clave "+ e.getKey()+" está asociada al nombre "+ e.getValue()+".");
        }

    }
}
