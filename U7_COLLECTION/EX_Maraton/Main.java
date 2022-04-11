package com.company.EX_Maraton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Maraton m = new Maraton();
        String opcion="";

        m.cargarAtletas();

       do {
           mostrarMenu();
           System.out.println("Escoge una opcion: ");
           opcion = sc.nextLine();

           switch (opcion){
               case "1":
                   Atleta a = m.crearAtleta();
                   m.addAtleta(a);
                   break;
               case "2":
                   m.saveMarca();
                   break;
               case "3":
                   m.removeAtleta();
                   break;
               case "4":
                   m.MostrarListaFinishers();
                  break;
               case "5":
                   System.out.println("Introduce la categoría (JUNIOR/SENIOR/VETERANO): ");
                   Categoria categoria = Categoria.valueOf(sc.nextLine());
                   m.mostrarListaCategoria(categoria);
                   break;
               case "6":
                   System.out.println("Introduce un Pais: ");
                   String pais = sc.nextLine();
                   m.mostrarListaPorPais(pais);
                   break;
               case "7":
                   System.out.println(m.atletas.values());
                   m.guardarAtleta();
                   break;
               default:
                   System.out.println("Opción incorrecta.");
           }

       }while (!opcion.equals("7"));

    }

    public static void mostrarMenu(){

        System.out.println("1. Imscribir atleta");
        System.out.println("2. Guardar Tiempo");
        System.out.println("3. Borrar Atleta");
        System.out.println("4. Mostrar Lista Finisher");
        System.out.println("5. MOstrar Lista Categoria");
        System.out.println("6. Mostrar LIsta por Pais");
        System.out.println("7. Salir");
    }

}
