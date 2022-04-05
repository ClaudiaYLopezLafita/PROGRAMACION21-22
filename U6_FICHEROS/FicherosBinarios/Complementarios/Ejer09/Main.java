package com.company.FicherosBinarios.Complementarios.Ejer09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion="";

        do {
            mostrarMenu();
            System.out.println("Elige una opcion: ");
            opcion = sc.nextLine();

            switch (opcion){
                case "1":

                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
            }
        }while (!opcion.equals("7"));
    }

    public static void mostrarMenu(){
        System.out.println("1. Alta locomotoras");
        System.out.println("2. Baja locomotora");
        System.out.println("3. Mostrar locomotoras");
        System.out.println("4. Alta Vagon");
        System.out.println("5. Baja vagon");
        System.out.println("6. Mostrar vagones");
        System.out.println("7. Salir");
    }
}
