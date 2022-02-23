package com.company.Peliculas;

import java.util.Arrays;
import java.util.Comparator;

public class OrdenarPorAnio implements Comparator<Pelicula> {

        public int compare(Pelicula p1, Pelicula p2) {

            if (p1.getAnio()==p2.getAnio()){
                return p2.getDuracion()-p1.getDuracion();// duracion descendente
            }
            return p1.getAnio()-p2.getAnio(); // año ascendente.
        };

}
