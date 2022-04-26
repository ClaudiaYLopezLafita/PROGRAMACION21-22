package com.company;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Trabajador t1 = new Trabajador("Manuel", "GA", "12345678A",
                32, "Universitario");
        Trabajador t2 = new Trabajador("Claudia", "LL", "74185296A",
                23, "Grado Superios");
        Trabajador t3 = new Trabajador("Guadalupe", "LL", "78965412W",
                54, "Universitario");
        Trabajador t4 = new Trabajador("Gema", "SE", "75386942q",
                45, "Grado SUperior");
        Trabajador t5 = new Trabajador("Carlos", "CC", "98752146a",
                48, "Doctorado");
        Trabajador t6 = new Trabajador("Pilar", "GD", "789654122s",
                18, "Grado Medio");
        Trabajador t7 = new Trabajador("Juan", "LD", "78965413E",
                65, "Universitario");
        Trabajador t8 = new Trabajador("Andrea", "VH", "963587418D",
                25, "Universitario");
        Trabajador t9 = new Trabajador("Mario", "JD", "12378978A",
                48, "Maestria");
        Trabajador t10 = new Trabajador("Stefano", "MF", "98321457S",
                20, "Bachillerato");

        Oferta of1 = new Oferta(1236, "Profesor de secundaria", false);
        Oferta of2 = new Oferta(9874, "Teleoperador de transporte", false);
        Oferta of3 = new Oferta(1698, "Sustitucion de médico", true);
        Oferta of4 = new Oferta(8542, "Plomero", false);
        Oferta of5 = new Oferta(8462, "Dependienta de zapateria", true);

        Sae sae = new Sae();

        sae.cargarDatos();

        // comprobacion de añadir ofertas
        sae.addOferta(of1);
        sae.addOferta(of3);
        sae.addOferta(of5);
        sae.addOferta(of4);
        sae.addOferta(of2);

        // comprobacion de añadir trabajador a un oferta
        sae.addTrabajador(of1.getCodigo(),t1);
        sae.addTrabajador(of1.getCodigo(),t2);
        sae.addTrabajador(of1.getCodigo(),t6);

        sae.addTrabajador(of3.getCodigo(),t3);
        sae.addTrabajador(of3.getCodigo(),t2);
        sae.addTrabajador(of3.getCodigo(),t5);
        sae.addTrabajador(of3.getCodigo(),t9);
        sae.addTrabajador(of3.getCodigo(),t6);

        sae.addTrabajador(of5.getCodigo(),t2);

        sae.addTrabajador(of2.getCodigo(), t10);
        sae.addTrabajador(of2.getCodigo(), t3);

        System.out.println(sae);

        //Comprobacion de eliminar trabajador de una oferta
        sae.removeTrabajador(of1.getCodigo(),t1);
        System.out.println(sae);

//        // Comprobacion de mostrar trabajadores de una oferta
        sae.mostrarTrabajadores(of3.getCodigo());
        sae.mostrarTrabajadores(of4.getCodigo());

        // Comprobacion de mostrar trabajadores de una edad de una oferta
        sae.mostrarTrabajadoresXEdad(of3.getCodigo());
        sae.mostrarTrabajadoresXEdad(of1.getCodigo());

        //Comprobacion de la cantida de ofertas donde a parace un trabajador
        System.out.println("El trabajador con dni "+t2.getDni()+" esta inscrito en "+
                sae.cantidadOfertas(t2.getDni())+" ofertas");
        System.out.println("El trabajador con dni "+t8.getDni()+" esta inscrito en "+
                sae.cantidadOfertas(t8.getDni())+" ofertas");

        // Comprobacion de mostrar ofertas de mayor a menor numero de trabajadores inscritos
        sae.mostrarOfertas();

        sae.guardarDatos();

    }
}
