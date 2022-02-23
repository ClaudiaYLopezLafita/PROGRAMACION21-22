package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Persona p1= new Persona("12345678Q", "Pepe", "Lopez");
        Persona p2= new Persona("12344562Z", "Laura", "Hermoso");
        Persona p3= new Persona("78963214A", "Rosa", "Martinez");
        Persona p4= new Persona("78945635S", "Stefeno", "Mazzini");

        LocalIndustrial li1 = new LocalIndustrial(1994, "Calle Girasol, 1",
                120.23, p1,12000.0,200);
        LocalIndustrial li2 = new LocalIndustrial(2000, "Calle Conde Gato, 31",
                150.0, p4,22000.0,50);
        LocalIndustrial li3 = new LocalIndustrial(1980, "Calle Sierpes, 101",
                220.23, p2,120000.0,1000);
        LocalIndustrial li4 = new LocalIndustrial(2014, "Calle Real, 10",
                320.23, p3,1200.0,500);

        LocalComercial lc1 = new LocalComercial(2015,"Calle Panadero", 150.56,p2,
                25000.23,"Panaderia");
        LocalComercial lc2 = new LocalComercial(2015,"Av. montequinto, 032",
                1250.56,p1,15000000.23,"Cuidado de personas mayores");
        LocalComercial lc3 = new LocalComercial(1994,"Centro COmerciall Sevilla NOrte",
                959.56,p2,150000.23,"Venta de material de construccion");
        LocalComercial lc4 = new LocalComercial(2021,"Calle Pepe", 1800.56,p4,
                1600.23,"Veterinaria natual");
        LocalComercial lc5 = new LocalComercial(1988,"Calle Mero, 200", 150.56,p3,
                15070.23,"Venta de Turrones");

        Vivienda v1 = new Vivienda(1589,"Calle Moro", 152.2, 3,
                4, 5,22000.2);
        Vivienda v2 = new Vivienda(2002,"Calle Real", 32.2, 1,
                1, 2,12000.2);
        Vivienda v3 = new Vivienda(1996,"Av San Juan", 52.2, 1,
                2, 3,2000.2);
        Vivienda v4 = new Vivienda(2020,"Av Madrird", 72.2, 1,
                3, 3,10000.2);

        EquipamientoServicio es1 = new EquipamientoServicio(2015, "Calle zarzamora, 201",
                2520.3,Tipo.DEPORTIVO);
        EquipamientoServicio es2 = new EquipamientoServicio(2018, "Calle europa, 201",
                1220.3,Tipo.SANITARIO);
        EquipamientoServicio es3 = new EquipamientoServicio(2005, "Calle trenza, 201",
                1020.3,Tipo.OTROS);
        EquipamientoServicio es4 = new EquipamientoServicio(1995, "Calle Pollo, 201",
                1520.3,Tipo.EDUCATIVO);

        Registro r1 = new Registro();

        // Comprobacion del metodo mostrarPropiedad()
        li1.mostrarPropiedad();
        System.out.println();
        lc2.mostrarPropiedad();
        System.out.println();
        v4.mostrarPropiedad();
        System.out.println();
        es3.mostrarPropiedad();

        // Comprobacion de add personas y eliminar personas en vivienda
        v1.addPersona(p1);
        v1.addPersona(p2);
        v1.addPersona(p4);
        v1.mostrarPropiedad();
        v1.eliminarPersona(p2);
        v1.mostrarPropiedad();

        // Comprobacion de que no se añade más personas que la capacidad máxima indicada
        v3.addPersona(p1);
        v3.addPersona(p2);
        v3.addPersona(p4);
        v3.addPersona(p3);
        v3.mostrarPropiedad();

        //Comprobacion del interfaz mosntrarPrecioVenta
        lc1.mostrarPrecioVenta();
        v2.mostrarPrecioVenta();
        li3.mostrarPrecioVenta();

        // Comprobacion añadir y eliminar propiedades en registros

        r1.addPropiedad(v1);
        r1.addPropiedad(es1);
        r1.addPropiedad(lc1);
        r1.addPropiedad(lc2);
        r1.addPropiedad(li1);
        r1.addPropiedad(li4);
        System.out.println(r1);
        r1.eliminarPropiedad(lc1);
        System.out.println();

        // ordenacion de propiedades ascendentemente segun la superficie
        r1.informeSuperficie();
        System.out.println();

        // ordenacion de propiedades por año descendentemente y en caso de coincidr años
        // se tiene encuenta laa superficie descendentemente
        r1.informeAntiguedad();

        //ordenacion de viviendadas segun el numero de habitaciones de menor
        // a mayor numeros de habitaciones
        Vivienda[] viviendas = {v1,v2,v3,v4};
        System.out.println(Arrays.toString(viviendas));
        Arrays.sort(viviendas, new Comparator<Vivienda>() {
            @Override
            public int compare(Vivienda v1, Vivienda v2) {
                return v1.getNumHabitaciones()-v2.getNumHabitaciones();
            }
        });
        System.out.println(Arrays.toString(viviendas));

    }
}
