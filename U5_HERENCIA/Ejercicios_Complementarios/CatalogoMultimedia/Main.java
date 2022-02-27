package com.company.GrupoTarde;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Catalogo catalogo = new Catalogo();

        Pelicula p1 = new Pelicula("Titanic", "Spilber", 2000, false,
                120, "FOX", "EE.UU");
        Pelicula p2 = new Pelicula("El Mito", "CAmeron", 2015, true,
                160, "Paramount", "China");
        Pelicula p3 = new Pelicula("Gozdilla", "Nipon", 1994, true,
                200, "Tecniogh", "Japon");
        Pelicula p4 = new Pelicula("Moana", "Felix", 2018, false,
                140, "Disney", "EE.UU");
        Pelicula p5 = new Pelicula("La piel que habito", "Almodobar", 2005, true,
                190, "Catab", "España");

        Serie s1 = new Serie("Pasion de Gavilarnes", "Carme Lomana", 2006,
                true, 2);
        Serie s2 = new Serie("Betty la fea", "Santiago", 1996,
                false, 3);
        Serie s3 = new Serie("El internado", "Popeye", 2008,
                true, 6);
        Serie s4 = new Serie("KImetsu no Yaiba", "Tomoko kimutra", 2020,
                false, 4);
        Serie s5 = new Serie("Attac of titan", "Oda HIro", 2015,
                false, 5);

        Capitulo c1 = new Capitulo("S01E01");
        Capitulo c2 = new Capitulo("S01E02");
        Capitulo c3 = new Capitulo("S01E03");
        Capitulo c4 = new Capitulo("S02E01");
        Capitulo c5 = new Capitulo("S02E02");
        Capitulo c6 = new Capitulo("S02E03");

        Libro l1 = new Libro("Pinocho", "Hermanos Gretel", 1899, true,
                "Rayuela", "12345679RY", 250);
        Libro l2 = new Libro("1Q90", "Haruki MUrakami", 2012, false,
                "Belinda", "453457899BL", 500);
        Libro l3 = new Libro("Lenguage de Marca", "DAmid", 2001, true,
                "GArceta", "01234567GR", 600);
        Libro l4 = new Libro("Tomates verdes fritos", "Leon ruiz", 1999, false,
                "EL gusano Lector", "1346546GL", 350);
        Libro l5 = new Libro("Orgullo y prejuicio", "Jane Austin", 1885, true,
                "McMillan", "12345679ML", 900);

        // COMPROBACION DE AÑADIR CAPITULOS

       s2.addCapitulo(c1);
        s2.addCapitulo(c2);
        s2.addCapitulo(c3);
        System.out.println(s2);

        s4.addCapitulo(c4);
        s4.addCapitulo(c5);
        s4.addCapitulo(c6);
        System.out.println(s4);

        // COMPROBACION DE ELEIMINAR CAPITULOS

        s2.removeCapitulo(c2);
        System.out.println(s2);
        s4.removeCapitulo(c5);
        System.out.println(s4);

        // COMPROBACION DE AÑADIR MULTIMEDIA EN CATALIGO

        catalogo.addMultimedia(p2);
        catalogo.addMultimedia(s2);
        catalogo.addMultimedia(l1);
        catalogo.addMultimedia(l4);
       // System.out.println(catalogo);

        // COMPROBACION DE ELIMINAR MULTIMEDIA

       // catalogo.removeMultimedia(l4);

        System.out.println(catalogo);

        // COMPROBACION DEL COMPARABLE (ORDENAR POR ID DE MENOR A MAYOR)

        catalogo.ordenar_por_id();

        // COMPROBACION DE ORDENACION POR TITULO ALFABETICAMENTE DESCENDENTE (Z a A)

        catalogo.ordenar_por_titulo();

        //COMPROBACION DE ORDENACION POR AÑO DE MENOR A MAYOR

        catalogo.ordenar_por_year();

        // Visualizacion de la cantidad de elementos creados:

        catalogo.numeros_de_elementos();
    }
}
