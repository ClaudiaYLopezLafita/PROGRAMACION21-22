package com.company.T2_Cliente;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente("12345678X", "Maria",22, 1000.03);
        Cliente c2 = new Cliente("87654321Y", "Gabriel",33,  1050.03);
        Cliente c3 = new Cliente("12387568X", "Zacarias",44, 1200.03);
        Cliente c4 = new Cliente("96385274X", "Jael",66,  100.03);
        Cliente c5 = new Cliente("14785236X", "Pepe",55, 17500.03);

        Cliente[] clientes= {c1,c2,c3,c4,c5};

        Arrays.sort(clientes);
        System.out.println(Arrays.toString(clientes));

        /**
         * metodo de ordenacion que compara un Array en un interfaz [new nombreInterfaz()]
         * que tiene los metodos de comparacion mediante el nombre alfabetico
         */
        Arrays.sort(clientes, new ComparadorNombre());
        System.out.println(Arrays.toString(clientes));

        Arrays.sort(clientes, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.getDni().compareTo(o2.getDni());
            }
        });

    }
}
