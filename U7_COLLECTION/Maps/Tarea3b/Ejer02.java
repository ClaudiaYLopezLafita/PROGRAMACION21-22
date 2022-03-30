package com.company.Maps.Tarea3b;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Actividad 2: Añada al programa anterior la siguiente funcionalidad. El programa pedirá al usuario un dni,
calculará la clave que ha de consultar, comprobará que dicha clave existe, y, en tal caso, mostrará el
valor asociado a esa clave en el HashMap.
 */
public class Ejer02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dni="";

        Map<Integer,String> students = new HashMap<>();

        do {
            System.out.print("dni: ");
            dni = sc.nextLine();
            if (!students.containsKey(dniValor(dni))) {
                if (!dni.equalsIgnoreCase("fin")) {
                    students.put(dniValor(dni), dni);
                }
            }else {
                System.out.println("Ya existe, valor: "+students.get(dniValor(dni)));
                break;
            }
        }while (!dni.equalsIgnoreCase("fin"));

        System.out.println(students);
    }

    public static Integer dniValor(String dni){

        Integer suma = 0;
        Integer num = 0;

        for (int i = 0; i < dni.length()-1; i++) {
            num =  Character.getNumericValue(dni.charAt(i));
            suma+=num;
        }

        return suma;
    }
}
