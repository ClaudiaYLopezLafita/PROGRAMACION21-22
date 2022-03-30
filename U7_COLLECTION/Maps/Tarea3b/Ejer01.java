package com.company.Maps.Tarea3b;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Actividad 1: Crea un HashMap cuya clave sea un Integer, y cuyos valores sean los nombres de algunos de
tus compañeros. La clave ha de calcularse mediante un método que reciba un String que represente el dni,
y devuelva la suma de sus dígitos.

46221877D -> 4+6+2+2+1+8+7+7=37
Una vez guardados los elementos, deben mostrarse todos los elementos (clave-valor) del HasMap.
 */
public class Ejer01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dni="";
        String name="";

        Map<Integer,String> students = new HashMap<>();
        do {
            System.out.print("name: ");
            name = sc.nextLine();
            System.out.print("dni: ");
            dni = sc.nextLine();
            if (!name.equalsIgnoreCase("fin")){
                students.put(dniValor(dni),name);
            }
        }while (!name.equalsIgnoreCase("fin") || !dni.equalsIgnoreCase("fin"));

//        System.out.println(dniValor("46221877D"));
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

    public static Integer dniValor2(String dni){
        Integer suma = 0;

        for (int i = 0; i < dni.length()-1; i++) {
            suma+=Integer.parseInt(""+dni.charAt(i));
            // necesita una cadena para hacer la transformacion
        }
        return suma;
    }
}
