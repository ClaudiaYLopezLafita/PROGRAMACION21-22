package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Currency;

public class Main {

    public static void main(String[] args) {

        // CREACION DE OBJETOS

        Coro c1 = new Coro("Los niños del Coro", "Pepe","Juan",
                "Manolo","Infantil",85,5,2);
        Coro c2 = new Coro("Santos inocentes", "Jaime","Antonio",
                "Clara","papa",75,2,7);

        Comparsa cp1 = new Comparsa("Arsaa", "Emilio","Jessi",
                "Manueh","Flamencos",90,"Coviran");
        Comparsa cp2 = new Comparsa("Olée", "Stefano","Maria",
                "Decorah","Bebes",100,"Cortefiel");

        Chirigota ch1 = new Chirigota("Los del barrio", "Miguel", "EL dorado",
                "Disney","Gatos", 78,6);
        Chirigota ch2 = new Chirigota("Los chunguitos", "Maria", "Los bebos del barrio",
                "Manolo escobar","Marineros", 20,6);

        Cuarteto ct1 = new Cuarteto("Las burguesas de Queen", "MAI", "La mary",
                "Jesus", "UNiversitario",65,8);
        Cuarteto ct2 = new Cuarteto("Las mamas flotantes", "Juan", "El gato en bici",
                "Mario", "Globos",10,7);

        Romancero r1 = new Romancero("Los loritos", "Bequer", "Manolo","Auto",
                "rosas","Las golondrinas enamoradas");
        Romancero r2 = new Romancero("MInios", "Bonillo", "Hermosilla","Ven",
                "Queso","Quesos ladrones");

        Integrante i1 = new Integrante(120,"Juan",23,"Cadiz");
        Integrante i2 = new Integrante(125,"Manolo",27,"Sevilla");
        Integrante i3 = new Integrante(126,"Antonio",18,"Chiclana");
        Integrante i4 = new Integrante(129,"Javier",40,"Jerez");
        Integrante i5 = new Integrante(130,"Juani",52,"San Fernando");

        COAC coac = new COAC();

        //comprobacion de añadir y borrar integrantes

        ct1.insertar_integrante(i1);
        ct1.insertar_integrante(i2);
        ct1.insertar_integrante(i3);
        System.out.println(ct1);
        ct1.eliminar_integrante(i2);
        System.out.println();
        System.out.println(ct1);

        c2.insertar_integrante(i2);
        c1.insertar_integrante(i5);
        ch2.insertar_integrante(i4);
        cp1.insertar_integrante(i2);
        System.out.println(c1);
        System.out.println(ch2);
        System.out.println(cp1);
        c1.eliminar_integrante(i5);
        ch2.eliminar_integrante(i4);
        cp1.eliminar_integrante(i2);
        System.out.println(c1);
        System.out.println(ch2);
        System.out.println(cp1);

        // Comprobacion de añadir agrupaciones oficiales

        coac.inscribir_agrupacion(c1);
       coac.inscribir_agrupacion(ct1);
        coac.inscribir_agrupacion(ch1);
       System.out.println(coac);
       coac.eliminar_agrupacion(ct1);
       System.out.println(coac);

        // ordenacion de los grupos oficales por la cantidad de punto sin se esta ompracion por defecto.
        // ordenacion descendente
        Arrays.sort(coac.agrupacions, new Comparator<AgrupacionOficial>() {
            @Override
            public int compare(AgrupacionOficial o1, AgrupacionOficial o2) {
                return o2.getNumPuntos()-o1.getNumPuntos();
            }
        });
        System.out.println(Arrays.toString(coac.agrupacions));

        // Comparación de las agrupaciones oficales por el autor (Mirando la rubrica)
        // de manera descendente
        Arrays.sort(coac.agrupacions, new Comparator<AgrupacionOficial>() {
            @Override
            public int compare(AgrupacionOficial o1, AgrupacionOficial o2) {
                return o2.getAutor().compareTo(o1.getAutor());
            }
        });
        System.out.println(Arrays.toString(coac.agrupacions));



        /* comparación de las agrupaciones (en general) por autor:
        Se hace mediante la implementaciñon en Compararto e indicando el atributo que necesitamos.
         */

        // comprobacion de los metodos de ordenación.
        System.out.println(coac);
        System.out.println();
        coac.ordenar_por_nombre(); // ascendente
        System.out.println();
        coac.ordenar_por_puntos(); // ascendente
        System.out.println();
        coac.ordenar_por_autor(); // descendente

        // Comprobación de los interfaces.
        ch1.amo_a_escucha();
        ct2.amo_a_escucha();
        r2.amo_a_escucha();

        // Comprobacion de los metodos

        c2.cantar_la_presentacion();
        ch2.cantar_la_presentacion();
        ct2.cantar_la_presentacion();
        cp2.cantar_la_presentacion();
        r1.cantar_la_presentacion();
        c1.caminito_del_falla();
        ch1.caminito_del_falla();
        ct2.caminito_del_falla();
        cp2.caminito_del_falla();
        ct1.hacer_tipo();
        c1.hacer_tipo();
        cp2.hacer_tipo();
        ct2.hacer_tipo();
        r1.hacer_tipo();

        // Contabilizar el numero de agrupaciones

        coac.cantidadAgrupaciones();

    }
}
