package com.company.Maps.Tarea5_MapyFicheros;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            mostrasMenu();
            System.out.println("Elige una opción: ");
            opcion = sc.nextLine();
            switch (opcion){
                case "1":
                    IntroducirAspirantes ia = new IntroducirAspirantes();
                    ia.insetarApirante();
                    ia.guardarFciheros();
                    break;
                case "2":
                   CalificarPrueba cp = new CalificarPrueba();
                   cp.leerIDs();
                   cp.introducirCalificaciones();
                   cp.guardarCalificaciones();
                    break;
                case "3":
                    Aprobados aprobados = new Aprobados();
                    aprobados.leerCalificaciones();
                    aprobados.generarInforme();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }while (!opcion.equalsIgnoreCase("4"));

    }

    public static void mostrasMenu(){

        System.out.println("1. Introducir datos de aspirantes");
        System.out.println("2. Calificar prueba");
        System.out.println("3. Aprobados");
        System.out.println("4. Salir");
    }

}
