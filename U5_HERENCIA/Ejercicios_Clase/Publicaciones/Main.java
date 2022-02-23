package com.company.Publicaciones;
/*
Se quiere informatizar una biblioteca. Crea las clases Publicacion, Libro y
Revista. Las clases deben estar implementadas con la jerarquía correcta. Las
características comunes de las revistas y de los libros son el código ISBN, el
título, y el año de publicación. Los libros tienen además un atributo prestado.
Cuando se crean los libros, no están prestados. Las revistas tienen un número.
La clase Libro debe implementar la interfaz Prestable que tiene los métodos
presta, devuelve y estaPrestado.
 */
public class Main {
    public static void main(String[] args) {
        Libro l1 = new Libro("12345ACL", "Orgullo y Prejuicio", 1856, false);
        Libro l2 = new Libro("789654ACL", "1000 maneras de morir", 2000, false);
        Libro l3 = new Libro("456982ACL", "Mis gatos y yo", 2015, false);

        Revista r1 = new Revista("78951321684zzc", "Historia", 1956, 145);
        Revista r2 = new Revista("78951zzc", "National Geographic", 2000, 203);
        Revista r3 = new Revista("12345los", "Nature", 1994, 105);

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(r1);
        System.out.println(r2);

        l1.presta();
        if (l1.estaPrestado()){
            System.out.println("Libro prestado");
        }

        if (l2.estaPrestado()){
            System.out.println("Libro prestado");
        }else {
            System.out.println("Libro disponible");
        }
        System.out.println(l1);
        System.out.println(l2);

    }
}
