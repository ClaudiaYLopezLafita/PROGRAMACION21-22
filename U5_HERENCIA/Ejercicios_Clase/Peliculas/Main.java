package com.company.Peliculas;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Pelicula p1 = new Pelicula("Pajaros", 1995, 120);
        Pelicula p2 = new Pelicula("Lluvia de albondigas", 2012, 140);
        Pelicula p3 = new Pelicula("Gru, mi villano favorito", 2012, 200);
        Pelicula p4 = new Pelicula("Cats", 1990, 130);

        Pelicula[] peliculas = {p1, p2, p3, p4};
        System.out.println(Arrays.toString(peliculas));
        Arrays.sort(peliculas);
        System.out.println(Arrays.toString(peliculas));

        Arrays.sort(peliculas, new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula p1, Pelicula p2) {

                if (p1.getAnio().equals(p2.getAnio())){
                    return p2.getDuracion()-p1.getDuracion();// duracion descendente
                }
                return p1.getAnio()-p2.getAnio(); // año ascendente.
            }
        });

        System.out.println(Arrays.toString(peliculas));
    }
}
